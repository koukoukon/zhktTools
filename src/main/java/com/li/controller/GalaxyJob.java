package com.li.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.li.bean.Answer;
import com.li.bean.ChapterInfo;
import com.li.bean.MajorCurriculum;
import com.li.listener.ServerListener;
import com.li.service.GalaxyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("job")
public class GalaxyJob {

    final static Map<String, String> teachersSessionIdMap = ServerListener.map;

    @Autowired
    GalaxyJobService galaxyJobService;

    @PostMapping("/classInfo")
    public @ResponseBody Map<String, Integer> getClassInfo(HttpSession session) throws Exception {
        if (session.getAttribute("user") != null) {
            return galaxyJobService.getClassInfo(teachersSessionIdMap.get("zhangJinDing"));
        } else {
            return null;
        }
    }

    @GetMapping("/galaJob/{className}/{classId}")
    public String majorList(@PathVariable String className,@PathVariable String classId, Model model) throws Exception{
        String majorCurriculum = galaxyJobService.getMajorCurriculum(teachersSessionIdMap, classId);
        model.addAttribute("majorCurriculum", majorCurriculum);
        model.addAttribute("classId",classId);
        model.addAttribute("className",className);
        return "jobPage";
    }

    @PostMapping("/getJobInfo")
    public @ResponseBody List<ChapterInfo> getJobInfo(String classId, String subjectId, String majorName,String className) throws Exception{
        List<ChapterInfo> jobCountInfo = galaxyJobService.getJobCountInfo(teachersSessionIdMap, classId, subjectId, majorName,className);
        return jobCountInfo;
    }

    @PostMapping("/getAnswer")
    public @ResponseBody Answer getAnswer(String chapterId) throws Exception{
        String answerStr = galaxyJobService.getAnswer(chapterId, teachersSessionIdMap.get("zhangJinDing"));
        Gson gson = new Gson();
        Answer answer = gson.fromJson(answerStr, Answer.class);
        return answer;
    }

}
