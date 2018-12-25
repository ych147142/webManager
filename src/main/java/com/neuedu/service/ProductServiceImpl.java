package com.neuedu.service;

import com.neuedu.dao.IProductDao;
import com.neuedu.dao.ProductDaoImpl;
import com.neuedu.pojo.Product;
import com.neuedu.utilTest.JdbcUtil;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductDao dao = new ProductDaoImpl();
    @Override
    public List<Product> getList() {
        return dao.getList();
    }

    @Override
    public List<Product> getResults(String text) {
        return dao.listResluts(text);
    }

    @Override
    public int dele(int id) {
        return dao.dele(id);
    }

    @Override
    public int add(Product product) {
        return dao.add(product);
    }

    @Override
    public Product getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public int update(Product product) {
        return dao.update(product);
    }


}
