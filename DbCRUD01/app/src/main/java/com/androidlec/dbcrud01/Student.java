package com.androidlec.dbcrud01;

public class Student {


    // field
    String code;
    String name;
    String dept;
    String phone;


    // contructor


    public Student(String code, String name, String dept, String phone) {
        this.code = code;
        this.name = name;
        this.dept = dept;
        this.phone = phone;
    }


    // getter and setter


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
} //---------------------
