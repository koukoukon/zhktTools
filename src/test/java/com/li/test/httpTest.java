package com.li.test;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.google.gson.Gson;
import com.li.bean.ClassBean;
import com.li.bean.Userz;
import com.li.httpclient.GalaJobRequest;
import com.li.httpclient.SendHttpRequest;
import com.li.mapper.UserzMapper;
import com.li.service.UserzService;
import com.li.serviceImpl.UserzServiceImpl;
import com.li.utils.Tools;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.javassist.compiler.ast.StringL;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.net.URL;
import java.util.*;

public class httpTest {

    @Autowired
    SendHttpRequest srf;


    @Autowired
    UserzMapper userzMapper;

    @Test
    public void test1() throws Exception {

//        SendHttpRequest srf = new SendHttpRequest();

        Map<String, String> stringObjectMap = srf.queryUserInfo("JSESSIONID=F37526C96EAE0B2A5107674B8F1C3C57");
        System.out.println(stringObjectMap);
    }


    @Test
    public void test2() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String url2 = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletKt";

        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("commandType", "wx_getKtList"));
        formList.add(new BasicNameValuePair("cssl", "6"));
        formList.add(new BasicNameValuePair("cslist", "1"));
        formList.add(new BasicNameValuePair("cslist", "100"));
        formList.add(new BasicNameValuePair("cslist", "_a.id,_a.kcmc,_a.bjms,-danyinhao_en--danyinhao_en-"));
        formList.add(new BasicNameValuePair("cslist", "exists-kongge-(%E5%BD%93%E5%89%8D%E5%AD%A6%E7%94%9F%E8%AF%BE%E5%A0%82=-danyinhao_en-" + "18141301003" + "-danyinhao_en-)-kongge-$a-n-d$-kongge-_a.sfxs=-danyinhao_en-%E6%98%AF-danyinhao_en-"));
        formList.add(new BasicNameValuePair("cslist", "_a.kcmc,_a.bjms"));
        formList.add(new BasicNameValuePair("cslist", "ZHJX_J_KT_ZB"));
        formList.add(new BasicNameValuePair("zfj", "%E4%B8%AD"));
        formList.add(new BasicNameValuePair("time", Tools.time()));
        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        HttpPost httpPost = new HttpPost(url2);
        httpPost.addHeader(new BasicHeader("Cookie","JSESSIONID=CFC5F09DCCB4BA6CDF7D7BA64D3AD123"));
        httpPost.setEntity(rqeEntity);
        HttpResponse response = client.execute(httpPost);
        HttpEntity en = response.getEntity();
        String string = EntityUtils.toString(en, "utf-8");

        client.close();
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(string);
        }
    }

    @Test
    public void testJson() throws Exception{


//        System.out.println(ktMap);
    }

//    @Test
//    public void testZy() throws Exception{
//
//        SendHttpRequest instance = SendRequestFactory.getInstance();
//        String zyList = instance.getZyMethod("JSESSIONID=A5936934FE69A68A978CE23AB5B71015", "00200210162208057001");
//        System.out.println(zyList);
//
//        Document doc = DocumentHelper.parseText(zyList);
//        Element rootElement = doc.getRootElement();
//        List<Element> rList = rootElement.elements("r");
//
//        int partitionFlag = Integer.parseInt(rList.get(2).getText());
//        rList.remove(0);
//        rList.remove(0);
//        rList.remove(0);
//        System.out.println(rList.size());
//        Map<String, String> map = new HashMap<>();
//        for (int i = 0; i < rList.size();) {
//            map.put((rList.get(i).getText()),(rList.get(i+5).getText()));
//            i += partitionFlag;
//        }
//
//        System.out.println(map);
//
//    }

//    @Test
//    public void testKtBh() throws Exception{
//        SendHttpRequest instance = SendRequestFactory.getInstance();
//        String xml = instance.getKtList("JSESSIONID=D81E403D34DBDB34B38AC6894DEE9F8B", "18141301003");
//        System.out.println(xml);
//        Document doc = DocumentHelper.parseText(xml);
//        Element rootElement = doc.getRootElement();
//        List<Element> rList = rootElement.elements("r");
//        int partition = Integer.parseInt(rList.get(2).getText());
//        rList.remove(0);
//        rList.remove(0);
//        rList.remove(0);
//        Map<String, String> ktMap = new HashMap<>();
//        for (int i = 0; i < rList.size();){
//            ktMap.put(rList.get(i+1).getText(), rList.get(i).getText());
//            i += partition;
//        }
//
//
//        System.out.println(ktMap);
//    }

//    @Test
//    public void testKtList() throws Exception{
//        GalaJobRequest galaJobRequest = GalaJobRequestFactory.getInstance();
//        String classList = galaJobRequest.getClassList("ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSnBLSmJIbXBOc2ZBOXQxN2svUG1Ra2QzcUtUYjl2NE8xR0xxSzNnSzl5MGc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSWU1cXByK0NUQklNTVpJMEh1UXhMTkY4UkVuR3RVRGNUUzU2bW9jMTFBNGc9PQ==");
//
//        System.out.println(classList);
//        Gson gson = new Gson();
//        ClassBean classBean = gson.fromJson(classList, ClassBean.class);
//        System.out.println(classList);
//        List<ClassBean.RowsBean> rows = classBean.getRows();
//        for (ClassBean.RowsBean b: rows){
//
//            System.out.println(b.toString());
//
//        }
//    }

    @Test
    public void signTest() throws Exception {

        CloseableHttpClient client = HttpClients.createDefault();
        String url1 = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletXskq?commandType=zb_getList&time=1587742250499&zfj=%D6%D0&cssl=7&cslist=1&cslist=1&cslist=_kqzb.id,-kongge-_kqmx.id,-kongge-_kqzb.qdfs&cslist=-jinhao-DQXQ-jinhao--kongge-$a-n-d$-kongge-_kqmx.qdsj-kongge-is-kongge-null-kongge-$a-n-d$-kongge-_kqmx.id_xs=-danyinhao_en-18141301003-danyinhao_en--kongge-$a-n-d$-kongge-_kqzb.zt=-danyinhao_en--jinhao-ZT_JXZ-jinhao--danyinhao_en--kongge-$a-n-d$-kongge-_kqzb.id_kt=-danyinhao_en-00200209212655617001-danyinhao_en-&cslist=_kqzb.id-kongge-desc&cslist=&cslist=00200209212655617001";

        HttpPost getBhPost = new HttpPost(url1);
        getBhPost.addHeader(new BasicHeader("User-Agent", "mozilla/5.0 (linux; u; android 4.1.2; zh-cn; mi-one plus build/jzo54k) applewebkit/534.30 (khtml, like gecko) version/4.0 mobile safari/534.30 micromessenger/5.0.1.352"));
        getBhPost.addHeader(new BasicHeader("Cookie","JSESSIONID=EE369F56E49FB3A10E777AC71A7DD7EB"));
        getBhPost.addHeader(new BasicHeader("Referer","http://zhkt.zmdvtc.cn/zhjx/pages/weixin/shouye_xs.jsp?cslist=backpage=/zhjx/pages/weixin/kthd_xs/dmInfo_wx.jsp"));

        HttpResponse response = client.execute(getBhPost);
        HttpEntity en = response.getEntity();
        String string = EntityUtils.toString(en, "UTF-8");
        client.close();
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(string);
        }
    }

    @Test
    public void htmlTest() throws Exception{
        SendHttpRequest sendHttpRequest = new SendHttpRequest();
        Map<String, String> ktList = sendHttpRequest.getKtList("EE369F56E49FB3A10E777AC71A7DD7EB", "18141301003");
        System.out.println(ktList);
    }

    private static void initWebClient(WebClient webClient) {
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.setCookieManager(new CookieManager());
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getCookieManager().addCookie(new Cookie("/","JSESSIONID","76C4949DC3DEC49C5A070C789E87C517"));
    }














    @Test
    public void testQD() throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        String url2 = "http://zhkt.zmdvtc.cn/zhjx/servlet/ServletXskq?commandType=wx_xsqd&cssl=4&cslist=" + "0020042423442232500231" + "&cslist=" + "00200424234422325001" + "&cslist=&cslist=%C6%D5%CD%A8&time=" + Tools.time() + "&zfj=%D6%D0";

        HttpPost httpPost = new HttpPost(url2);
        httpPost.addHeader(new BasicHeader("User-Agent","mozilla/5.0 (linux; u; android 4.1.2; zh-cn; mi-one plus build/jzo54k) applewebkit/534.30 (khtml, like gecko) version/4.0 mobile safari/534.30 micromessenger/5.0.1.352"));
        httpPost.addHeader(new BasicHeader("Cookie","JSESSIONID=9A7D68EBAC90453DA3D7D0A0A47B4936"));
        httpPost.addHeader(new BasicHeader("Referer","http://zhkt.zmdvtc.cn/zhjx/pages/weixin/kthd_xs/dmInfo_wx.jsp?cslist=backpage=/zhjx/pages/weixin/shouye_xs.jsp;kqzbid=" + "00200424234422325001" + ";kqmxid=" + "0020042423442232500231" + ";qdfs=%E6%99%AE%E9%80%9A"));

        HttpResponse response = client.execute(httpPost);
        HttpEntity en = response.getEntity();
        String string = EntityUtils.toString(en, "utf-8");

        client.close();
        if (response.getStatusLine().getStatusCode() == 200) {

            Document doc = DocumentHelper.parseText(string);
            Element rootElement = doc.getRootElement();
            Element result = rootElement.element("result");
            if ("1".equals(result.getText()) || "1" == result.getText() || Integer.valueOf(result.getText()) == 1) {
                Tools.logs(Tools.ZZQD,  Tools.getTime() + "---签到成功---响应实体：" + string + "---SESS---");
//                System.out.println("签到成功");
            } else {
                Tools.logs(Tools.ZZQD,  Tools.getTime() + "---签到失败---响应实体：" + string + "---SESS---"  );
//                System.out.println("签到失败");
            }

        }else {
            Tools.logs(Tools.ZZQD, Tools.getTime() + "---签到时连接不通---响应实体：" + string + "---SESS:");
//            System.out.println("---签到时连接不通---响应实体：" + string + "---SESS---:" + sess + "\n");
        }
    }





}
