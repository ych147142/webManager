package com.neuedu.service;


import com.neuedu.pojo.User;

import java.util.List;

public interface IUserService {
    public int insert(User user);
    public User getOne(String username);
    public List<User> getList();
    public int update(User user);
    public int dele(int id);
}
