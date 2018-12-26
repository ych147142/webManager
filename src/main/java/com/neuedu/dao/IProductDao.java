package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product>getList();
    public int add(Product product);
    public int update(Product product);
    public int dele(int id);
    public Product getOne(int id);
    public int brandDele(int brandId);

    public List<Product> getResults(String text);
    public List<Product> getLists(int pageNo, int pageSize);
    public List<Product> getLists(int pageNo, int pageSize,String text);
    public int getCount();
    public int getCount(String text);
}
