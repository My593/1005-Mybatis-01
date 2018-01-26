package com.ssm.domain;

import java.io.Serializable;

/**
 * Created by dllo on 18/1/26.
 */
public class Student implements Serializable {

    private int sid;
    private String sname;

    public Student() {
    }

    public Student(String sname) {
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }
}
