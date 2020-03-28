package com.li.bean;

import java.util.List;

public class JobInfo {

    public JobInfo() {
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    /**
     * rows : [{"Id":26508,"ClassId":"2018级Java开发1班","SortId":"第4次","ChapterId":2950,"ChapterName":"MyBatis优化","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26509,"ClassId":"2018级Java开发1班","SortId":"第5次","ChapterId":2951,"ChapterName":"一对一关联","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26510,"ClassId":"2018级Java开发1班","SortId":"第6次","ChapterId":2952,"ChapterName":"一对多关联","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26511,"ClassId":"2018级Java开发1班","SortId":"第7次","ChapterId":2953,"ChapterName":"动态SQL","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26512,"ClassId":"2018级Java开发1班","SortId":"第8次","ChapterId":2954,"ChapterName":"存储过程调用","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26513,"ClassId":"2018级Java开发1班","SortId":"第9次","ChapterId":2955,"ChapterName":"Mybatis一级缓存","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26514,"ClassId":"2018级Java开发1班","SortId":"第10次","ChapterId":2956,"ChapterName":"Mybatis二级缓存","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26515,"ClassId":"2018级Java开发1班","SortId":"第11次","ChapterId":2957,"ChapterName":"综合项目实战：小莱信息化管理系统(1)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26516,"ClassId":"2018级Java开发1班","SortId":"第12次","ChapterId":2958,"ChapterName":"综合项目实战：小莱信息化管理系统(2)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26517,"ClassId":"2018级Java开发1班","SortId":"第13次","ChapterId":2959,"ChapterName":"综合项目实战：小莱信息化管理系统(3)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26518,"ClassId":"2018级Java开发1班","SortId":"第14次","ChapterId":2960,"ChapterName":"综合项目实战：小莱信息化管理系统(4)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26519,"ClassId":"2018级Java开发1班","SortId":"第15次","ChapterId":2961,"ChapterName":"综合项目实战：小莱信息化管理系统(5)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26520,"ClassId":"2018级Java开发1班","SortId":"第16次","ChapterId":2962,"ChapterName":"综合项目实战：小莱信息化管理系统(6)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26521,"ClassId":"2018级Java开发1班","SortId":"第17次","ChapterId":2963,"ChapterName":"综合项目实战：小莱信息化管理系统(7)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26522,"ClassId":"2018级Java开发1班","SortId":"第18次","ChapterId":2964,"ChapterName":"综合项目实战：小莱信息化管理系统(8)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26523,"ClassId":"2018级Java开发1班","SortId":"第19次","ChapterId":2965,"ChapterName":"综合项目实战：小莱信息化管理系统(9)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26524,"ClassId":"2018级Java开发1班","SortId":"第20次","ChapterId":2966,"ChapterName":"综合项目实战：小莱信息化管理系统(10)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26525,"ClassId":"2018级Java开发1班","SortId":"第21次","ChapterId":2967,"ChapterName":"综合项目实战：小莱信息化管理系统(11)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"},{"Id":26526,"ClassId":"2018级Java开发1班","SortId":"第22次","ChapterId":2968,"ChapterName":"综合项目实战：小莱信息化管理系统(12)","SubjectName":"Java企业级持久层框架|2018","IsAssign":"未布置"}]
     * total : 19
     */

    private int total;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * Id : 26508
         * ClassId : 2018级Java开发1班
         * SortId : 第4次
         * ChapterId : 2950
         * ChapterName : MyBatis优化
         * SubjectName : Java企业级持久层框架|2018
         * IsAssign : 未布置
         */

        private int Id;

        public RowsBean() {
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "Id=" + Id +
                    ", ClassId='" + ClassId + '\'' +
                    ", SortId='" + SortId + '\'' +
                    ", ChapterId=" + ChapterId +
                    ", ChapterName='" + ChapterName + '\'' +
                    ", SubjectName='" + SubjectName + '\'' +
                    ", IsAssign='" + IsAssign + '\'' +
                    '}';
        }

        private String ClassId;
        private String SortId;
        private int ChapterId;
        private String ChapterName;
        private String SubjectName;
        private String IsAssign;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getClassId() {
            return ClassId;
        }

        public void setClassId(String ClassId) {
            this.ClassId = ClassId;
        }

        public String getSortId() {
            return SortId;
        }

        public void setSortId(String SortId) {
            this.SortId = SortId;
        }

        public int getChapterId() {
            return ChapterId;
        }

        public void setChapterId(int ChapterId) {
            this.ChapterId = ChapterId;
        }

        public String getChapterName() {
            return ChapterName;
        }

        public void setChapterName(String ChapterName) {
            this.ChapterName = ChapterName;
        }

        public String getSubjectName() {
            return SubjectName;
        }

        public void setSubjectName(String SubjectName) {
            this.SubjectName = SubjectName;
        }

        public String getIsAssign() {
            return IsAssign;
        }

        public void setIsAssign(String IsAssign) {
            this.IsAssign = IsAssign;
        }
    }
}
