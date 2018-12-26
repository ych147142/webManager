package com.neuedu.dao;


import com.neuedu.pojo.User;
import com.neuedu.utilTest.JdbcUtil;
import com.neuedu.utilTest.RowMap;


import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public int insert(User user) {
        return JdbcUtil.executeUpdate("insert into user(username,password,email) values(?,?,?)",user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User getOne(String username) {
        return JdbcUtil.queryOne("select * from user where username=?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) {
                User u = new User();
                try {
                    u.setUsername(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    u.setEmail(resultSet.getString("email"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

    @Override
    public int updatePwd(User user) {
        return JdbcUtil.executeUpdate("update user set password = where username = ?",user.getPassword(),user.getUsername());
    }


}
