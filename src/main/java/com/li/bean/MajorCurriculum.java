package com.li.bean;

public class MajorCurriculum {

    public MajorCurriculum() {
    }

    @Override
    public String toString() {
        return "MajorCurriculum{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }

    /**
     * Id : 389
     * Name : SQL Server数据库基础|2019
     */

    private int Id;
    private String Name;

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
}
