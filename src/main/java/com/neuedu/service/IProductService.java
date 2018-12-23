package com.neuedu.service;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getList();
    public List<Product> getResults(String text);
    public int dele(int id);
    public int add(Product product);
}
