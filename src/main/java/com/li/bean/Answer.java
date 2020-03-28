package com.li.bean;

import java.util.List;

public class Answer {
    @Override
    public String toString() {
        return "Answer{" +
                "objs=" + objs +
                ", subs=" + subs +
                '}';
    }

    public Answer() {
    }

    private List<ObjsBean> objs;
    private List<SubsBean> subs;

    public List<ObjsBean> getObjs() {
        return objs;
    }

    public void setObjs(List<ObjsBean> objs) {
        this.objs = objs;
    }

    public List<SubsBean> getSubs() {
        return subs;
    }

    public void setSubs(List<SubsBean> subs) {
        this.subs = subs;
    }

    public static class ObjsBean {
        public ObjsBean() {
        }

        @Override
        public String toString() {
            return "ObjsBean{" +
                    "Title='" + Title + '\'' +
                    ", Item1='" + Item1 + '\'' +
                    ", Image1=" + Image1 +
                    ", Item2='" + Item2 + '\'' +
                    ", Image2=" + Image2 +
                    ", Item3='" + Item3 + '\'' +
                    ", Image3=" + Image3 +
                    ", Item4='" + Item4 + '\'' +
                    ", Image4=" + Image4 +
                    ", Answer='" + Answer + '\'' +
                    '}';
        }

        /**
         * Title : <p>下面关于Spring MVC特点说法错误的是。（  ）</P>
         * Item1 : 灵活性强，但不易于与其他框架集成
         * Image1 : null
         * Item2 : 可自动绑定用户输入，并能正确的转换数据类型
         * Image2 : null
         * Item3 : 支持国际化
         * Image3 : null
         * Item4 : 使用基于XML的配置文件，在编辑后，不需要重新编译应用程序
         * Image4 : null
         * Answer : 1
         */

        private String Title;
        private String Item1;
        private Object Image1;
        private String Item2;
        private Object Image2;
        private String Item3;
        private Object Image3;
        private String Item4;
        private Object Image4;
        private String Answer;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getItem1() {
            return Item1;
        }

        public void setItem1(String Item1) {
            this.Item1 = Item1;
        }

        public Object getImage1() {
            return Image1;
        }

        public void setImage1(Object Image1) {
            this.Image1 = Image1;
        }

        public String getItem2() {
            return Item2;
        }

        public void setItem2(String Item2) {
            this.Item2 = Item2;
        }

        public Object getImage2() {
            return Image2;
        }

        public void setImage2(Object Image2) {
            this.Image2 = Image2;
        }

        public String getItem3() {
            return Item3;
        }

        public void setItem3(String Item3) {
            this.Item3 = Item3;
        }

        public Object getImage3() {
            return Image3;
        }

        public void setImage3(Object Image3) {
            this.Image3 = Image3;
        }

        public String getItem4() {
            return Item4;
        }

        public void setItem4(String Item4) {
            this.Item4 = Item4;
        }

        public Object getImage4() {
            return Image4;
        }

        public void setImage4(Object Image4) {
            this.Image4 = Image4;
        }

        public String getAnswer() {
            return Answer;
        }

        public void setAnswer(String Answer) {
            this.Answer = Answer;
        }
    }

    public static class SubsBean {
        public SubsBean() {
        }

        @Override
        public String toString() {
            return "SubsBean{" +
                    "Title='" + Title + '\'' +
                    ", ParsingType=" + ParsingType +
                    ", Parsing='" + Parsing + '\'' +
                    '}';
        }

        /**
         * Title : 什么是Spring MVC ？简单介绍下你对springMVC的理解?
         * ParsingType : 1
         * Parsing : Spring MVC是一个基于Java的实现了MVC设计模式的请求驱动类型的轻量级Web框架，通过把Model，View，Controller分离，将web层进行职责解耦，把复杂的web应用分成逻辑清晰的几部分，简化开发，减少出错，方便组内开发人员之间的配合
         */

        private String Title;
        private int ParsingType;
        private String Parsing;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public int getParsingType() {
            return ParsingType;
        }

        public void setParsingType(int ParsingType) {
            this.ParsingType = ParsingType;
        }

        public String getParsing() {
            return Parsing;
        }

        public void setParsing(String Parsing) {
            this.Parsing = Parsing;
        }
    }
}
