package com.li.bean;

public class ChapterInfo {

    private String ClassName;
    private String ChapterName;
    private Integer jobId;

    @Override
    public String toString() {
        return "ChapterInfo{" +
                "ClassName='" + ClassName + '\'' +
                ", ChapterName='" + ChapterName + '\'' +
                ", jobId=" + jobId +
                '}';
    }

    public ChapterInfo() {
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}
