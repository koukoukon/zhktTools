package com.li.controller;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.li.bean.Userz;
import com.li.httpclient.SendHttpRequest;
import com.li.service.UserzService;
import com.li.serviceImpl.UserzServiceImpl;
import com.li.utils.Tools;
import javafx.application.Application;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("user")
public class User {

    private Timer timer = null;
    private static boolean openSignFlag = true;

    private boolean loginFlag = true;

    @Autowired
    SendHttpRequest sendHttpRequest;

    @Autowired
    UserzService userzService;


    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String userLogin(Model model, HttpSession session, @RequestParam("account") String account, @RequestParam("password") String password) throws Exception {

        Userz userz = testLogin(account, password, true);

        if (userz != null) {
            session.setAttribute("user", userz);
            return "forward:/WEB-INF/jsp/home.jsp";
        }else {
            model.addAttribute("mes","账号或密码错误");
            return "login";
        }

    }

    public Userz testLogin(String account, String password, boolean isUpdate) throws Exception {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        String url = "http://zhkt.zmdvtc.cn/zhjx/pages/kjkt/login/login.html";
        initWebClient(webClient);
        HtmlPage page = webClient.getPage(url);
        webClient.setAlertHandler(new AlertHandler() {
            @Override
            public void handleAlert(Page page, String s) {
                if ((s==null || s == "" || s.equals("") || s.equals(null))) {
                    loginFlag = false;
                }
            }
        });
        CookieManager cm = webClient.getCookieManager();
        HtmlInput accountInput = (HtmlInput)page.getHtmlElementById("dlmc");
        accountInput.setValueAttribute(String.valueOf(account));
        HtmlInput passwordInput = (HtmlInput)page.getHtmlElementById("yhmm");
        passwordInput.setValueAttribute(password);
        DomNodeList<DomElement> domElement = page.getElementsByTagName("button");
        DomElement button = domElement.get(0);
        HtmlPage sucPage = (HtmlPage)button.click();
        if (sucPage.asText().contains("换一种登录方式")) {
            loginFlag = false;
        }

        if (loginFlag) {
            Cookie jsessionid = cm.getCookie("JSESSIONID");
            String sessionId = jsessionid.getName() + "=" + jsessionid.getValue();
            Map<String, String> infoMap = sendHttpRequest.queryUserInfo(sessionId);
            Userz user = userzService.selectUser(account);
            //第一次登录
            if (user == null){
                System.out.println(sessionId);
                Userz userz = new Userz(account, password, infoMap.get("yhmc"), infoMap.get("yhlx"), 0, sessionId,Tools.getTime());
                userzService.addUser(userz);

                return userz;
            }else {
                //登录密码与数据库不同,更改数据库
                if (!password.equals(user.getPassword())) {
                    user.setPassword(password);
                    user.setZSess(sessionId);
                    if (isUpdate) {
                        user.setLatelyDate(Tools.getTime());
                    }
                    userzService.updateUser(user, user.getId());
                    Userz user1 = userzService.selectUser(user.getAccount());
                    return user1;
                }else {
                    user.setZSess(sessionId);
                    if (isUpdate) {
                        user.setLatelyDate(Tools.getTime());
                    }
                    userzService.updateUser(user, user.getId());
                    Userz user2 = userzService.selectUser(user.getAccount());
                    return user2;
                }
            }
        }
        loginFlag = true;
        webClient.close();
        return null;
    }

    private static void initWebClient(WebClient webClient) {
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.setCookieManager(new CookieManager());
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setThrowExceptionOnScriptError(false);
    }

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public @ResponseBody Userz userInfo(HttpSession session){

        Userz user = (Userz) session.getAttribute("user");
        Userz userz = new Userz(user.getAccount(),null,user.getName(),user.getIdentity(),user.getAutoSign(),null,null);
        return userz;
    }

    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    public void Sign(HttpServletResponse response, HttpSession session, @RequestParam("zt") String zt) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Userz user = (Userz)session.getAttribute("user");
        if ("学生".equals(user.getIdentity())) {
            if ("open".equals(zt)) {
                user.setAutoSign(1);
                int i = userzService.updateUser(user, user.getId());
                if (i == 1) {
                    out.write("{\"result\":\"openSuccess\"}");
                } else {
                    out.write("{\"result\":\"勿重复开启\"}");
                }
            } else if ("clo".equals(zt)) {
                user.setAutoSign(0);
                int i = userzService.updateUser(user, user.getId());
                if (i == 1) {
                    out.write("{\"result\":\"cloSuccess\"}");
                } else {
                    out.write("{\"result\":\"勿重复关闭\"}");
                }
            }
        } else {
            out.write("{\"result\":\"教师身份无效果。。。。\"}");
        }
        out.close();
    }

    @RequestMapping(value = "/start")
    public String Sign() throws Exception {
        if (openSignFlag) {
            System.out.println("开始");
            openSignFlag = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    List<Userz> users = userzService.selectOpenedUserSess();
                    if (!users.isEmpty()) {

                        //晚上1点更新所有开启签到的session
                        if ("0101".equals(Tools.flushSessTime()) || "0101" == Tools.flushSessTime()) {
                            for (Userz u: users) {
                                try {
                                    testLogin(u.getAccount(), u.getPassword(), false);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        for (Userz u: users ) {
                            try {
                                sendHttpRequest.signIn(u.getAccount(),u.getZSess());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            TimeUnit.MICROSECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Tools.logs(Tools.GXSS, Tools.getTime() + "------成功执行------");
                    }
                }
            },0,40000);
        }
        return "login";
    }


    @PostMapping("/getKtInfo")
    public @ResponseBody Map<String,String> getKtInfo(HttpSession session) throws Exception {
        Userz user = (Userz)session.getAttribute("user");
        if ("学生".equals(user.getIdentity())) {
            Map<String, String> ktList = userzService.getKtList(user.getZSess(), user.getAccount());
            return ktList;
        }else {
            Map<String, String > map = new HashMap<>();
            map.put("result","-1");
            return map;
        }
    }

}

