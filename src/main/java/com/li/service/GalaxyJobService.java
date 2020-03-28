package com.li.service;

import com.li.bean.ChapterInfo;

import java.util.List;
import java.util.Map;

public interface GalaxyJobService {

    Map<String, Integer> getClassInfo(String sess) throws Exception;

    String getMajorCurriculum(Map<String, String> map, String classId) throws Exception;

    List<ChapterInfo> getJobCountInfo(Map<String, String> sessMap, String classId, String subjectId, String majorName,String className) throws Exception;

    String getAnswer(String chapter, String sess) throws Exception;
}
