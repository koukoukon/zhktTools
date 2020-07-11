package com.li.serviceImpl;

import com.li.bean.ChapterInfo;
import com.li.bean.JobCorrect;
import com.li.bean.JobInfo;
import com.li.httpclient.GalaJobRequest;
import com.li.service.GalaxyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GalaxyJonServiceImpl implements GalaxyJobService {

    @Autowired
    GalaJobRequest galaJobRequest;

    @Override
    public Map<String, Integer> getClassInfo(String sess) throws Exception{
        Map<String, Integer> classList = galaJobRequest.getClassList(sess);
        return classList;
    }

    @Override
    public String getMajorCurriculum(Map<String, String> map, String classId) throws Exception {
        String majorCurriculum = galaJobRequest.getMajorCurriculum(map, classId);
        return majorCurriculum;
    }

    @Override
    public List<ChapterInfo> getJobCountInfo(Map<String, String> sessMap, String classId, String subjectId, String majorName,String className) throws Exception {
        JobInfo jobInfo1 = galaJobRequest.getJobInfo(classId, subjectId, sessMap.get("zhangJinDing"));
        List<JobInfo.RowsBean> rows = jobInfo1.getRows();

//        for (JobInfo.RowsBean r: rows) {
//            System.out.println(1);
//        }

        JobInfo.RowsBean endRowsBean = null;
        Map<String, String> countMap = new HashMap<>();

        List<JobCorrect.RowsBean> rowsBeans = new ArrayList<>();

        if (rows.size() != 0) {
            endRowsBean = rows.get(rows.size() - 1);
        }

        List<JobCorrect> jobCorrectInfo = galaJobRequest.getJobCorrectInfo(sessMap);

        Integer maxNumbFlag = 0;
        String id = null;
        String chapterId = "第一次";
        if (endRowsBean == null && jobCorrectInfo.size() == 0) {
            return null;
        } else if (endRowsBean == null && jobCorrectInfo.size() != 0) {
            for (JobCorrect j:jobCorrectInfo){
                List<JobCorrect.RowsBean> rows1 = j.getRows();
                System.out.println(rows1);
                for (JobCorrect.RowsBean r:rows1) {
                    if ((r.getSubject().trim()).equals(majorName.trim()) && (r.getClassId().trim()).equals(className.trim())) {
                        if (r.getCid() > maxNumbFlag) {
                            maxNumbFlag = r.getCid();
                            id = String.valueOf(r.getId());
                            chapterId = r.getChapterId();
                        }
                        countMap.put("jobId",String.valueOf(maxNumbFlag));
                        countMap.put("count",chapterId);
                        countMap.put("id",id);
                    }
                }
            }
        } else if (endRowsBean != null) {
            for (JobCorrect j:jobCorrectInfo){
                List<JobCorrect.RowsBean> rows1 = j.getRows();
                for (JobCorrect.RowsBean r:rows1) {
                    if (r.getClassId().equals(className) && r.getSubject().equals(majorName)) {
                        rowsBeans.add(r);
                    }
                }
            }
            for (JobCorrect.RowsBean r: rowsBeans) {
                if (r.getCid() >= endRowsBean.getChapterId()){
                    countMap.put("jobId", String.valueOf(r.getCid()));
                    countMap.put("count",r.getChapterId());
                    countMap.put("id",String.valueOf(r.getId()));
                }else {
                    countMap.put("jobId", String.valueOf(endRowsBean.getChapterId()));
                    countMap.put("count",endRowsBean.getSortId());
                    countMap.put("id",String.valueOf(endRowsBean.getId()));
                }
            }
        }

        if (rowsBeans.size() == 0 && endRowsBean != null) {
            countMap.put("jobId", String.valueOf(endRowsBean.getChapterId()));
            countMap.put("count",endRowsBean.getSortId());
            countMap.put("id",String.valueOf(endRowsBean.getId()));
        }

        String count1 = countMap.get("count");
        Integer count = Integer.parseInt(count1.substring(1,count1.length()-1));
        Integer topicId = Integer.parseInt(countMap.get("id"))-(count-1);
        Integer jobId = Integer.parseInt(countMap.get("jobId"))-(count-1);

        List<ChapterInfo> countJobInfo = galaJobRequest.getChapterInfo(topicId, count, sessMap.get("zhangJinDing"));
        for (ChapterInfo c: countJobInfo) {
            c.setJobId(jobId++);
        }
        return countJobInfo;
    }

    @Override
    public String getAnswer(String chapter, String sess) throws Exception {
        String answer = galaJobRequest.getAnswer(chapter, sess);
        return answer;
    }
}
