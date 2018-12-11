package com.example.llyc.myapp.bean;

import java.io.Serializable;

/**
 * Created by Bright on 2018/11/6.
 *
 * @Describe 员工信息的极简封装
 * @Called
 */
public class Person implements Serializable {

    private String id;
    private String name;
    private String mobile;

    public Person() {
    }

    public Person(String id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
