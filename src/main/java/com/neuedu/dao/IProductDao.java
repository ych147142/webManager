package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product>getList();
    public int add(Product product);
    public int update(Product product);
    public int dele(int id);
    public List<Product> listResluts(String text);
}
