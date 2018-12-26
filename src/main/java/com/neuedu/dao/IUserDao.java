package com.neuedu.dao;


import com.neuedu.pojo.User;

public interface IUserDao {
    public int insert(User user);
    public User getOne(String username);
    public int updatePwd(User user);
}
