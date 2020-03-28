package com.li.bean;

import java.util.List;

public class JobCorrect {
    public JobCorrect() {
    }

    @Override
    public String toString() {
        return "JobCorrect{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    /**
     * rows : [{"Id":26507,"ClassId":"2018级Java开发1班","Subject":"Java企业级持久层框架|2018","ChapterId":"第3次","ChapterName":"基于注解的实现","IsAssign":true,"CreateTime":"2020/3/16 11:48:24","EndTime":"2020/3/22 15:00:00","TeacherId":735,"StudentName":"李勃辉","RandCode":"ZBW0HJ","StudentStatus":1,"TeacherStatus":1,"Cid":2949,"IsQueryAnswer":false},{"Id":26506,"ClassId":"2018级Java开发1班","Subject":"Java企业级持久层框架|2018","ChapterId":"第2次","ChapterName":"基于XML的实现","IsAssign":true,"CreateTime":"2020/3/12 16:14:48","EndTime":"2020/3/15 16:10:00","TeacherId":735,"StudentName":"李勃辉","RandCode":"QYAXCI","StudentStatus":1,"TeacherStatus":1,"Cid":2948,"IsQueryAnswer":true}]
     * total : 2
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
        public RowsBean() {
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "Id=" + Id +
                    ", ClassId='" + ClassId + '\'' +
                    ", Subject='" + Subject + '\'' +
                    ", ChapterId='" + ChapterId + '\'' +
                    ", ChapterName='" + ChapterName + '\'' +
                    ", IsAssign=" + IsAssign +
                    ", CreateTime='" + CreateTime + '\'' +
                    ", EndTime='" + EndTime + '\'' +
                    ", TeacherId=" + TeacherId +
                    ", StudentName='" + StudentName + '\'' +
                    ", RandCode='" + RandCode + '\'' +
                    ", StudentStatus=" + StudentStatus +
                    ", TeacherStatus=" + TeacherStatus +
                    ", Cid=" + Cid +
                    ", IsQueryAnswer=" + IsQueryAnswer +
                    '}';
        }

        /**
         * Id : 26507
         * ClassId : 2018级Java开发1班
         * Subject : Java企业级持久层框架|2018
         * ChapterId : 第3次
         * ChapterName : 基于注解的实现
         * IsAssign : true
         * CreateTime : 2020/3/16 11:48:24
         * EndTime : 2020/3/22 15:00:00
         * TeacherId : 735
         * StudentName : 李勃辉
         * RandCode : ZBW0HJ
         * StudentStatus : 1
         * TeacherStatus : 1
         * Cid : 2949
         * IsQueryAnswer : false
         */

        private int Id;
        private String ClassId;
        private String Subject;
        private String ChapterId;
        private String ChapterName;
        private boolean IsAssign;
        private String CreateTime;
        private String EndTime;
        private int TeacherId;
        private String StudentName;
        private String RandCode;
        private int StudentStatus;
        private int TeacherStatus;
        private int Cid;
        private boolean IsQueryAnswer;

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

        public String getSubject() {
            return Subject;
        }

        public void setSubject(String Subject) {
            this.Subject = Subject;
        }

        public String getChapterId() {
            return ChapterId;
        }

        public void setChapterId(String ChapterId) {
            this.ChapterId = ChapterId;
        }

        public String getChapterName() {
            return ChapterName;
        }

        public void setChapterName(String ChapterName) {
            this.ChapterName = ChapterName;
        }

        public boolean isIsAssign() {
            return IsAssign;
        }

        public void setIsAssign(boolean IsAssign) {
            this.IsAssign = IsAssign;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getTeacherId() {
            return TeacherId;
        }

        public void setTeacherId(int TeacherId) {
            this.TeacherId = TeacherId;
        }

        public String getStudentName() {
            return StudentName;
        }

        public void setStudentName(String StudentName) {
            this.StudentName = StudentName;
        }

        public String getRandCode() {
            return RandCode;
        }

        public void setRandCode(String RandCode) {
            this.RandCode = RandCode;
        }

        public int getStudentStatus() {
            return StudentStatus;
        }

        public void setStudentStatus(int StudentStatus) {
            this.StudentStatus = StudentStatus;
        }

        public int getTeacherStatus() {
            return TeacherStatus;
        }

        public void setTeacherStatus(int TeacherStatus) {
            this.TeacherStatus = TeacherStatus;
        }

        public int getCid() {
            return Cid;
        }

        public void setCid(int Cid) {
            this.Cid = Cid;
        }

        public boolean isIsQueryAnswer() {
            return IsQueryAnswer;
        }

        public void setIsQueryAnswer(boolean IsQueryAnswer) {
            this.IsQueryAnswer = IsQueryAnswer;
        }
    }
}
