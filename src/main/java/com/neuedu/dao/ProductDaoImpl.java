package com.neuedu.dao;

import com.neuedu.pojo.Product;
import com.neuedu.utilTest.JdbcUtil;
import com.neuedu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public List<Product> getList() {
        return JdbcUtil.executeQuery("select * from product", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {

                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setUrl(rs.getString("url"));
                    p.setPrice(rs.getDouble("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, null);

    }


    @Override
    public int add(Product product) {
        return JdbcUtil.executeUpdate("insert into product(product_name,price,product_des,url) values(?,?,?,?)",product.getProductName(),product.getPrice(),product.getProductDes(),product.getUrl());
    }

    @Override
    public int update(Product product) {
        return JdbcUtil.executeUpdate("update product set product_name=?,product_des=?,url=?,price=? where product_id=?",product.getProductName(),product.getProductDes(),product.getUrl(),product.getPrice(),product.getProductId());
    }

    @Override
    public int dele(int id) {
        return JdbcUtil.executeUpdate("delete from product where product_id = ?",id);
    }

    @Override
    public List<Product> listResluts(String text) {
        return JdbcUtil.executeQuery("select * from product where product_name like concat('%',?,'%')", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setUrl(rs.getString("url"));
                    p.setPrice(rs.getDouble("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return p;
            }
        }, text);
    }

    @Override
    public Product getOne(int id) {
        return JdbcUtil.queryOne("select * from product where product_id=?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setUrl(rs.getString("url"));
                    p.setPrice(rs.getDouble("price"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, id);
    }
}
