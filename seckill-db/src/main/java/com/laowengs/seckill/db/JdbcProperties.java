package com.laowengs.seckill.db;

import java.io.Serializable;

public class JdbcProperties implements Serializable {

    private String url;
    private String username;
    private String password;
    //TODO 补充字段

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}