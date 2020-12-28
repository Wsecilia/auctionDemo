package com.jxfh.auciton.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    private int uId;
    private String username;
    @JsonIgnore
    private String password;
    private String tel;

    public User() {
    }



    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
