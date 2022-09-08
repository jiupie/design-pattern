package com.wl.singleton;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/9/3
 */

public class People {
    String username;
    String password;

    public People() {
    }

    public People(String username, String password) {
        this.username = username;
        this.password = password;
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
