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
                    p.setBrandId(rs.getInt("brand_id"));
                    p.setCount(rs.getInt("count"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, null);

    }


    @Override
    public int add(Product product) {
        return JdbcUtil.executeUpdate("insert into product(product_name,price,product_des,url,brand_id,count) values(?,?,?,?,?,?)",product.getProductName(),product.getPrice(),product.getProductDes(),product.getUrl(),product.getBrandId(),product.getCount());
    }

    @Override
    public int update(Product product) {
        return JdbcUtil.executeUpdate("update product set brand_id=? ,product_name=?,price=?,product_des=?,count =?,url=? where product_id=?",product.getBrandId(),product.getProductName(),product.getPrice(),product.getProductDes(), product.getCount(), product.getUrl(), product.getProductId());
    }

    @Override
    public int dele(int id) {
        return JdbcUtil.executeUpdate("delete from product where product_id = ?",id);
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
                    p.setBrandId(rs.getInt("brand_id"));
                    p.setCount(rs.getInt("count"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, id);
    }

    @Override
    public int brandDele(int brandId) {
        return JdbcUtil.executeUpdate("delete from product where brand_id = ?",brandId);
    }


    @Override
    public List<Product> getResults(String text) {
        return JdbcUtil.executeQuery("select * from product where product_name like concat('%',?,'%') ", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductName(rs.getString("product_name"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                    p.setProductId(rs.getInt("product_id"));
                    p.setBrandId(rs.getInt("brand_id"));
                    p.setCount(rs.getInt("count"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, text);
    }

    @Override
    public List<Product> getLists(int pageNo, int pageSize) {
        return JdbcUtil.executeQuery("select * from product limit ?,?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setProductName(rs.getString("product_name"));
                    p.setUrl(rs.getString("url"));
                    p.setBrandId(rs.getInt("brand_id"));
                    p.setCount(rs.getInt("count"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        },(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public List<Product> getLists(int pageNo, int pageSize, String text) {
        return JdbcUtil.executeQuery("select * from product  where product_name like concat('%',?,'%') limit ?,?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setProductName(rs.getString("product_name"));
                    p.setUrl(rs.getString("url"));
                    p.setBrandId(rs.getInt("brand_id"));
                    p.setCount(rs.getInt("count"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        },text,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int getCount() {
        return JdbcUtil.executeCount("select count(*) from product",null);
    }

    @Override
    public int getCount(String text) {
        return JdbcUtil.executeCount("select count(*) from product where product_name like concat('%',?,'%') ",text);
    }

}
