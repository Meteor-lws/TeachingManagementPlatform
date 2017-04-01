package com.hjj.vo;

/**
 * Created by 朱高 on 2017/3/17.
 */
public class EasyUI {
    private String manager;
    private String password;
    private int id;

    private String auth;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EasyUI{" +
                "manager='" + manager + '\'' +
                ", password='" + password + '\'' +
                ", id=" + auth +
                '}';
    }
}
