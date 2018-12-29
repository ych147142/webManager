package com.neuedu.dao;



import com.neuedu.pojo.User;

import java.util.List;

public interface IUserDao {
    public int insert(User user);
    public User getOne(String username);
    public List<User> getList();
    public int update(User user);
    public int dele(int id);
    public int updatePwd(User user);
}
