package com.neuedu.pojo;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private int lv;


    public User(int userId, String username, String password, String email, int lv) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.lv = lv;
    }

    public User() {
    }
}
