package com.li.controller;

import com.li.bean.Userz;
import com.li.service.BrowseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("browse")
public class BrowseResources {

    @Autowired
    BrowseResourcesService browseService;

    @PostMapping("/getZyInfo")
    public @ResponseBody Map<String,String> getZyInfo(HttpSession session, String ktBh) throws Exception {
        Userz user = (Userz) session.getAttribute("user");
        Map<String, String> map = browseService.getZyInfo(user.getZSess(), ktBh);
        return map;
    }

    @PostMapping("/browseZy")
    public @ResponseBody Map<String, String> browseZy(HttpSession session, String zyBh, String ktBh) throws Exception{
        Userz user = (Userz) session.getAttribute("user");
        browseService.browseZy(user.getZSess(), zyBh);
        Map<String, String> zyInfo = browseService.getZyInfo(user.getZSess(), ktBh);
        return zyInfo;
    }

}
