package com.neuedu.dao;


import com.neuedu.pojo.Product;
import com.neuedu.pojo.User;
import com.neuedu.utilTest.JdbcUtil;
import com.neuedu.utilTest.RowMap;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public int insert(User user) {
        return JdbcUtil.executeUpdate("insert into user(username,password,email,lv) values(?,?,?,?)",user.getUsername(),user.getPassword(),user.getEmail(),user.getLv());
    }

    @Override
    public User getOne(String username) {
        return JdbcUtil.queryOne("select * from user where username=?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) {
                User u = new User();
                try {
                    u.setUserId(resultSet.getInt("id"));
                    u.setUsername(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    u.setEmail(resultSet.getString("email"));
                    u.setLv(resultSet.getInt("lv"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

    @Override
    public List<User> getList() {
        return JdbcUtil.executeQuery("select * from user", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet rs) {
                User u = new User();
                try {
                    u.setUserId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setEmail(rs.getString("email"));
                    u.setLv(rs.getInt("lv"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return u;
            }
        }, null);
    }

    @Override
    public int update(User user) {
        return JdbcUtil.executeUpdate("update user set username =?, password=?,email=? ,lv = ? where id = ?",user.getUsername(),user.getPassword(),user.getEmail(),user.getLv(),user.getUserId());
    }

    @Override
    public int dele(int id) {
        return JdbcUtil.executeUpdate("delete from user where id = ?",id);
    }

    @Override
    public int updatePwd(User user) {
        return JdbcUtil.executeUpdate("update user set password = ? where username = ?",user.getPassword(),user.getUsername());
    }

    @Override
    public User getOne(int id) {
        return JdbcUtil.queryOne("select * from user where id = ?",new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) {
                User u = new User();
                try {
                    u.setUserId(resultSet.getInt("id"));
                    u.setUsername(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    u.setEmail(resultSet.getString("email"));
                    u.setLv(resultSet.getInt("lv"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, id);
    }


}
