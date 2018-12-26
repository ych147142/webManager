package com.neuedu.service;

import com.neuedu.pojo.Product;
import com.neuedu.pojo.ResultData;

import java.util.List;

public interface IProductService {
    public List<Product> getList();
    public int dele(int id);
    public int add(Product product);
    public Product getOne(int id);
    public int update(Product product);
    public int brandDele(int brandId);

    public ResultData getLists(int pageNo, int pageSize);
    public List<Product> getResults(String text);
    public ResultData getLists(int pageNo,int pageSize,String text);
}
