package com.li.httpclient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.li.bean.*;
import com.li.utils.Tools;
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
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GalaJobRequest {

    public Map<String, Integer> getClassList(String sess) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();

        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("pageNumber", "1"));
        formList.add(new BasicNameValuePair("page", "1"));
        formList.add(new BasicNameValuePair("rows", "1000"));

        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        HttpPost post = new HttpPost("http://www.galayun.com/Admin/Class/list");
        post.addHeader(new BasicHeader("Cookie", sess));
        post.setHeader("Connection", "keep-alive");
        post.setEntity(rqeEntity);
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String mes = EntityUtils.toString(entity, "utf-8");
        client.close();
        Gson gson = new Gson();
        ClassBean classBean = gson.fromJson(mes, ClassBean.class);
        List<ClassBean.RowsBean> rows = classBean.getRows();
        Map<String, Integer> ClassInfo =  new HashMap<String,Integer>();
        for (ClassBean.RowsBean b: rows){

            if ("启用".equals(b.getEnabled())) {
                ClassInfo.put(b.getName(),b.getId());
            }

        }
        return ClassInfo;
    }

    public String getMajorCurriculum(Map<String, String> sessMap,String classId) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();

        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("classId", classId));

        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        Set<String> strings = sessMap.keySet();
        Iterator<String> iterator = strings.iterator();
        StringBuffer stringBuffer = new StringBuffer();

        while (iterator.hasNext()){
            String key = iterator.next();
            HttpPost post = new HttpPost("http://www.galayun.com/Admin/AssignWork/GetSubjectsByClassId");
            post.addHeader(new BasicHeader("Cookie", sessMap.get(key)));
            post.setHeader("Connection", "keep-alive");
            post.setEntity(rqeEntity);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String mes = EntityUtils.toString(entity, "utf-8");
            if ("[]".equals(mes) || mes.contains("功能维护中") || mes.contains("无法找到资源")) {
            }else {
                mes = mes.substring(1,mes.length()-1);
                stringBuffer.append(mes+",");
            }
        }
        client.close();
        String s = stringBuffer.toString();
        s = s.trim();
        if (s == null || s == "" || ("").equals(s)) {
        }else {
            s = "[" + s.substring(0,s.length()-1) + "]";
        }
        return s;
    }

    public JobInfo getJobInfo(String classId, String subjectId, String sess) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        List<JobInfo> jobInfos = new ArrayList<>();
        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("classId", classId));
        formList.add(new BasicNameValuePair("SubjectId", subjectId));
        formList.add(new BasicNameValuePair("page", "1"));
        formList.add(new BasicNameValuePair("rows", "1000"));

        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        HttpPost post = new HttpPost("http://www.galayun.com/Admin/AssignWork/list");
        post.addHeader(new BasicHeader("Cookie", sess));
        post.setHeader("Connection", "keep-alive");
        post.setEntity(rqeEntity);
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String mes = EntityUtils.toString(entity, "utf-8");
        Gson gson = new Gson();
        JobInfo jobInfo = gson.fromJson(mes, JobInfo.class);
        client.close();
        return jobInfo;
    }

    public List<JobCorrect> getJobCorrectInfo(Map<String, String> sessMap) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();

        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("page", "1"));
        formList.add(new BasicNameValuePair("rows", "1000"));

        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        Set<String> strings = sessMap.keySet();
        Iterator<String> iterator = strings.iterator();

        List<JobCorrect> jobCorrects = new ArrayList<>();

        while (iterator.hasNext()){
            String key = iterator.next();
            HttpPost post = new HttpPost("http://www.galayun.com/Admin/AssignWork/IndexList");
            post.addHeader(new BasicHeader("Cookie", sessMap.get(key)));
            post.setHeader("Connection", "keep-alive");
            post.setEntity(rqeEntity);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String mes = EntityUtils.toString(entity, "utf-8");
            Gson gson = new Gson();
            JobCorrect jobCorrect = gson.fromJson(mes, JobCorrect.class);
            jobCorrects.add(jobCorrect);
        }

        client.close();
        return jobCorrects;
    }

    public List<ChapterInfo> getChapterInfo(Integer topicId, Integer count, String sess) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        List<ChapterInfo> classBeans = new ArrayList<>();
        for (int i = 0; i < count; i ++){
            ArrayList<NameValuePair> formList = new ArrayList<>();
            formList.add(new BasicNameValuePair("id", String.valueOf(topicId)));
            topicId++;
            UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
            rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

            HttpPost post = new HttpPost("http://www.galayun.com/Admin/AssignWork/AssignDetail");
            post.addHeader(new BasicHeader("Cookie", sess));
            post.setHeader("Connection", "keep-alive");
            post.setEntity(rqeEntity);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String mes = EntityUtils.toString(entity, "utf-8");
            Gson gson = new Gson();
            if (!mes.contains("页面丢失")) {
                ChapterInfo chapterInfo = gson.fromJson(mes, ChapterInfo.class);
                classBeans.add(chapterInfo);
            }
        }

        client.close();
        return classBeans;
    }

    public String getAnswer(String chapterId, String sess) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        ArrayList<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("ChapterId", chapterId));

        UrlEncodedFormEntity rqeEntity = new UrlEncodedFormEntity(formList, "utf-8");
        rqeEntity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");

        HttpPost post = new HttpPost("http://www.galayun.com/Admin/AssignWork/AnswerDetail");
        post.addHeader(new BasicHeader("Cookie", sess));
        post.setHeader("Connection", "keep-alive");
        post.setEntity(rqeEntity);
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String mes = EntityUtils.toString(entity, "utf-8");
        client.close();
        return mes;
    }

}
