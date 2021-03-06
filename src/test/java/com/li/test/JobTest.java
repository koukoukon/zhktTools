package com.li.test;

import com.google.gson.Gson;
import com.li.bean.Answer;
import com.li.bean.ChapterInfo;
import com.li.bean.JobCorrect;
import com.li.bean.JobInfo;
import com.li.httpclient.GalaJobRequest;
import com.li.listener.ServerListener;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class JobTest {

    GalaJobRequest galaJobRequest = new GalaJobRequest();

    @Test
    public void testJob() throws Exception{

        Map<String, String> map = new HashMap<>();
        map.put("fuLingLing","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlc2a1Q2ODZjdWN4MU5jbktRakI2dW9PcFFCbjY5a0ZOcXBZbERQMVVHN3c9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSjMzM0ROTXVINHlGMXVpRUNOWW5GVzVvTG9leFFjTVBpRGtGTGVuWEVXd3c9PQ==");
        map.put("zhangJinDing","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSnBLSmJIbXBOc2ZBOXQxN2svUG1Ra2QzcUtUYjl2NE8xR0xxSzNnSzl5MGc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSWU1cXByK0NUQklNTVpJMEh1UXhMTkY4UkVuR3RVRGNUUzU2bW9jMTFBNGc9PQ==");
        map.put("caoSaiLe","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSS9uUmhtRG9NSmZCaGFiZndUWjdSalRKaGY0MzQ2bFVHSWNEcTlQenBNQkE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS1JHUjFkSWcvQTN1RTZuMW1nUjBoQldNWjAxMzRCVnUxM0RZb3ZSNDBSR3c9PQ==");
        map.put("xvShiWei","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlRRdytxTVBvYVlpcTF0MmNHNDRnSEdqR1VEbG4zTWs5OHdzcUY4Y1k4eVE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUI3bmx6MHBVL3BsWnRNeTlKeDNFTjVtcG8va2RDSXB4QU02K3N0QXd5RFE9PQ==");
        map.put("wangYong","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS2pCdVgrZzZnYmtORG9EM294UDNiT1lPY1hSeDMyY0NPWEtHbnNKVlN0VEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMTFU1ZTdXeUJ5d2pySUJla1JXM1lHT2tucnZCTmRuSnJmeWNaMEtSK0JmL1E9PQ==");
        map.put("yangFan","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSVRTM2l3QW1GRGtoVFZ2M2VUaFdxVXdmU1JxVnpaUDVQcERrNHRVUEJkVEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSmNieGZPdEd4T3BZbkRNWmZNQWUyWkMxalpnTXIvZlF6bTcvd1V0dGcvT2c9PQ==");
        map.put("wangJun","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUZCOXFkVnF0T0FzRCs1U1dhdHU1UHlaRURCZGk3dHZZbDJrb1JjMll3M1E9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSU1VQ0dEbE1IY04wendsV2E2bmtuYVhGbk5HaWhpbzBYcXpPdlBmU2U5VXc9PQ==");
        String majorCurriculum = galaJobRequest.getMajorCurriculum(map, "273");

    }

    @Test
    public void testJobInfo() throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("fuLingLing","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlc2a1Q2ODZjdWN4MU5jbktRakI2dW9PcFFCbjY5a0ZOcXBZbERQMVVHN3c9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSjMzM0ROTXVINHlGMXVpRUNOWW5GVzVvTG9leFFjTVBpRGtGTGVuWEVXd3c9PQ==");
        map.put("zhangJinDing","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSnBLSmJIbXBOc2ZBOXQxN2svUG1Ra2QzcUtUYjl2NE8xR0xxSzNnSzl5MGc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSWU1cXByK0NUQklNTVpJMEh1UXhMTkY4UkVuR3RVRGNUUzU2bW9jMTFBNGc9PQ==");
        map.put("caoSaiLe","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSS9uUmhtRG9NSmZCaGFiZndUWjdSalRKaGY0MzQ2bFVHSWNEcTlQenBNQkE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS1JHUjFkSWcvQTN1RTZuMW1nUjBoQldNWjAxMzRCVnUxM0RZb3ZSNDBSR3c9PQ==");
        map.put("xvShiWei","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSlRRdytxTVBvYVlpcTF0MmNHNDRnSEdqR1VEbG4zTWs5OHdzcUY4Y1k4eVE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUI3bmx6MHBVL3BsWnRNeTlKeDNFTjVtcG8va2RDSXB4QU02K3N0QXd5RFE9PQ==");
        map.put("wangYong","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS2pCdVgrZzZnYmtORG9EM294UDNiT1lPY1hSeDMyY0NPWEtHbnNKVlN0VEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMTFU1ZTdXeUJ5d2pySUJla1JXM1lHT2tucnZCTmRuSnJmeWNaMEtSK0JmL1E9PQ==");
        map.put("yangFan","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSVRTM2l3QW1GRGtoVFZ2M2VUaFdxVXdmU1JxVnpaUDVQcERrNHRVUEJkVEE9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSmNieGZPdEd4T3BZbkRNWmZNQWUyWkMxalpnTXIvZlF6bTcvd1V0dGcvT2c9PQ==");
        map.put("wangJun","ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSUZCOXFkVnF0T0FzRCs1U1dhdHU1UHlaRURCZGk3dHZZbDJrb1JjMll3M1E9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSU1VQ0dEbE1IY04wendsV2E2bmtuYVhGbk5HaWhpbzBYcXpPdlBmU2U5VXc9PQ==");


        JobInfo jobInfo1 = galaJobRequest.getJobInfo("151", "253", "ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSnBLSmJIbXBOc2ZBOXQxN2svUG1Ra2QzcUtUYjl2NE8xR0xxSzNnSzl5MGc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSWU1cXByK0NUQklNTVpJMEh1UXhMTkY4UkVuR3RVRGNUUzU2bW9jMTFBNGc9PQ==");
        List<JobInfo.RowsBean> rows = jobInfo1.getRows();
        JobInfo.RowsBean endRowsBean = null;
        Map<String, String> countMap = new HashMap<>();

        List<JobCorrect.RowsBean> rowsBeans = new ArrayList<>();

        if (rows.size() != 0) {
            endRowsBean = rows.get(rows.size() - 1);
        }

        List<JobCorrect> jobCorrectInfo = galaJobRequest.getJobCorrectInfo(map);

        Integer maxNumbFlag = 0;
        String id = null;

        if (endRowsBean == null && jobCorrectInfo.size() == 0) {
            return;
        } else if (endRowsBean == null && jobCorrectInfo.size() != 0) {
            for (JobCorrect j:jobCorrectInfo){
                List<JobCorrect.RowsBean> rows1 = j.getRows();
                for (JobCorrect.RowsBean r:rows1) {
                    if (r.getSubject().equals("Java????????????????????????|2018")) {
                        if (r.getCid() > maxNumbFlag) {
                            maxNumbFlag = r.getCid();
                            id = String.valueOf(r.getId());
                        }
                        countMap.put("jobId",String.valueOf(maxNumbFlag));
                        countMap.put("count",r.getSubject());
                        countMap.put("id",id);
                    }
                }
            }
        } else if (endRowsBean != null) {
            for (JobCorrect j:jobCorrectInfo){
                List<JobCorrect.RowsBean> rows1 = j.getRows();
                for (JobCorrect.RowsBean r:rows1) {
                    if (r.getSubject().equals(endRowsBean.getSubjectName())) {
                        rowsBeans.add(r);
                    }
                }
            }
            for (JobCorrect.RowsBean r: rowsBeans) {
                if (r.getCid() >= endRowsBean.getChapterId()){
                    countMap.put("jobId", String.valueOf(r.getCid()));
                    countMap.put("count",r.getSubject());
                    countMap.put("id",String.valueOf(r.getId()));
                }else {
                    countMap.put("jobId", String.valueOf(endRowsBean.getChapterId()));
                    countMap.put("count",endRowsBean.getSortId());
                    countMap.put("id",String.valueOf(endRowsBean.getId()));
                }
            }
        }

        String count1 = countMap.get("count");
        Integer count = Integer.parseInt(count1.substring(1,count1.length()-1));
        Integer topicId = Integer.parseInt(countMap.get("id"))-(count-1);
        Integer jobId = Integer.parseInt(countMap.get("jobId"))-(count-1);

        List<ChapterInfo> zhangJinDing = galaJobRequest.getChapterInfo(topicId, count, map.get("zhangJinDing"));
        for (ChapterInfo c: zhangJinDing) {
            c.setJobId(jobId++);
        }

        for (ChapterInfo c: zhangJinDing) {
            System.out.println(c);
        }

    }


    @Test
    public void testGetAnswer() throws Exception{

        GalaJobRequest galaJobRequest = new GalaJobRequest();
        String answer = galaJobRequest.getAnswer("2925", "ASP.NET_SessionId=lolc12kgfpczldelxqoz1tnj; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSnBLSmJIbXBOc2ZBOXQxN2svUG1Ra2QzcUtUYjl2NE8xR0xxSzNnSzl5MGc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMSWU1cXByK0NUQklNTVpJMEh1UXhMTkY4UkVuR3RVRGNUUzU2bW9jMTFBNGc9PQ==");
        Gson gson = new Gson();
        Answer answer1 = gson.fromJson(answer, Answer.class);


    }

    @Test
    public void testThread() throws Exception{

        CloseableHttpClient client = HttpClients.createDefault();
        List<JobInfo> jobInfos = new ArrayList<>();
        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("classId", "151"));
        formList.add(new BasicNameValuePair("SubjectId", "252"));
        formList.add(new BasicNameValuePair("page", "1"));
        formList.add(new BasicNameValuePair("rows", "1000"));

        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

//        HttpPost post = new HttpPost("https://www.galayun.com/Admin/AssignWork/list");
        HttpPost post = new HttpPost("https://www.galayun.com/Admin/AssignWork/IndexList");
        post.addHeader(new BasicHeader("Cookie", "ASP.NET_SessionId=cuzue2yl0rrfz5rw3jljfccw; Himall-EmployeeManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS3djTUYxNkRBczh5aTE4cTVpR2ZON3RBMGR2a2tHbmE2TWRvbTBIR1JKbGc9PQ==; Himall-PlatformManager=c04veXhHWE5aNUpmUWM5a1hmNTRQcFJiV1htY3czaW5EQmJsTVVKVjFMS1NqSjNoZjZhcjlEOTROWE1FckhxQnZtTzlYa056dTV2RVFmM2Z5OGdlQ2c9PQ=="));
        post.setHeader("Connection", "keep-alive");
        post.setEntity(rqeEntity);
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String mes = EntityUtils.toString(entity, "utf-8");
        System.out.println(mes);
        Gson gson = new Gson();
        JobInfo jobInfo = gson.fromJson(mes, JobInfo.class);
        client.close();
        System.out.println(jobInfo);
    }

}
