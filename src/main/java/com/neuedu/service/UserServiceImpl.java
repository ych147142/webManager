package com.neuedu.service;


import com.neuedu.dao.IUserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.pojo.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public int insert(User user) {
        return dao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }

    @Override
    public List<User> getList() {
        return dao.getList();
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public int dele(int id) {
        return dao.dele(id);
    }

    @Override
    public User getOne(int id) {
        return dao.getOne(id);
    }
}
