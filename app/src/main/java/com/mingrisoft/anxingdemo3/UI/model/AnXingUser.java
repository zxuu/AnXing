package com.mingrisoft.anxingdemo3.UI.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by Hhuafei on 2018/6/1.
 * 用户类的定义
 * BmobUser包含:
 * private String username;
 * private String password;
 * private String email;
 * private String mobilePhoneNumber;
 * 可根据需要增删
 */

public class AnXingUser extends BmobUser {
/*
 * private String username;
 * private String password;
 * private String email;
 * private String mobilePhoneNumber;
 * 实现getter和setter
  */
    private String nickName;
    private String sex;
    private int age;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
