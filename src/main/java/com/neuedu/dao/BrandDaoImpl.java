package com.neuedu.dao;

import com.neuedu.pojo.Brand;
import com.neuedu.pojo.Product;
import com.neuedu.utilTest.JdbcUtil;
import com.neuedu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BrandDaoImpl implements IBrandDao {
    @Override
    public List<Brand> getLists() {
        return JdbcUtil.executeQuery("select * from brand" , new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet rs) {
                Brand b = new Brand();
                try {
                    b.setId(rs.getInt("id"));
                    b.setBrandName(rs.getString("brand_name"));
                    b.setBrandDes(rs.getString("brand_des"));
                    b.setBrandTime(rs.getString("brand_time"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return b;
            }
        }, null);
    }

    @Override
    public int add(Brand brand) {
        return JdbcUtil.executeUpdate("insert into brand (brand_name,brand_des,brand_time) values(?,?,?)",brand.getBrandName(),brand.getBrandDes(),brand.getBrandTime());
    }

    @Override
    public int update(Brand brand) {
        return JdbcUtil.executeUpdate("update product set brand_name=?,brand_des=?,brand_time where id=?",brand.getBrandName(),brand.getBrandDes(),brand.getBrandTime(),brand.getId());
    }

    @Override
    public int dele(int id) {
        return JdbcUtil.executeUpdate("delete from brand where id = ?",id);
    }

    @Override
    public Brand getOne(int id) {
        return JdbcUtil.queryOne("select * from brand where id = ?", new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet rs) {
                Brand b = new Brand();
                try {
                    b.setId(rs.getInt("id"));
                    b.setBrandName(rs.getString("brand_name"));
                    b.setBrandDes(rs.getString("brand_des"));
                    b.setBrandTime(rs.getString("brand_time"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return b;
            }
        }, id);
    }
}
