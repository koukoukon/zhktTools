package com.li.bean;

import java.util.List;

public class ClassBean {

    public ClassBean() {
    }

    /**
     * rows : [{"Id":273,"Name":"19级UI设计1班(普通班)","AliasId":89,"Alias":"UI设计","CreateTime":"2019/10/12 15:10:39","Enabled":"启用","Type":"普通班"},{"Id":272,"Name":"19级网络安全1班(普通班)","AliasId":87,"Alias":"网络安全","CreateTime":"2019/10/12 15:10:23","Enabled":"启用","Type":"普通班"},{"Id":154,"Name":"17级UI设计1班(毕业班)","AliasId":89,"Alias":"UI设计","CreateTime":"2019/8/29 12:00:02","Enabled":"启用","Type":"毕业班"},{"Id":153,"Name":"17级Java开发1班(毕业班)","AliasId":88,"Alias":"Java开发","CreateTime":"2019/8/29 12:00:10","Enabled":"启用","Type":"毕业班"},{"Id":152,"Name":"17级网络安全1班(毕业班)","AliasId":87,"Alias":"网络安全","CreateTime":"2019/8/29 12:00:18","Enabled":"启用","Type":"毕业班"},{"Id":151,"Name":"18级Java开发1班(普通班)","AliasId":88,"Alias":"Java开发","CreateTime":"2019/3/14 15:02:47","Enabled":"启用","Type":"普通班"}]
     * total : 6
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

        /**
         * Id : 273
         * Name : 19级UI设计1班(普通班)
         * AliasId : 89
         * Alias : UI设计
         * CreateTime : 2019/10/12 15:10:39
         * Enabled : 启用
         * Type : 普通班
         */


        private int Id;
        private String Name;
        private int AliasId;
        private String Alias;
        private String CreateTime;
        private String Enabled;
        private String Type;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getAliasId() {
            return AliasId;
        }

        public void setAliasId(int AliasId) {
            this.AliasId = AliasId;
        }

        public String getAlias() {
            return Alias;
        }

        public void setAlias(String Alias) {
            this.Alias = Alias;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getEnabled() {
            return Enabled;
        }

        public void setEnabled(String Enabled) {
            this.Enabled = Enabled;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "Id=" + Id +
                    ", Name='" + Name + '\'' +
                    ", AliasId=" + AliasId +
                    ", Alias='" + Alias + '\'' +
                    ", CreateTime='" + CreateTime + '\'' +
                    ", Enabled='" + Enabled + '\'' +
                    ", Type='" + Type + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ClassBean{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
