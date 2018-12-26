package com.neuedu.service;

import com.neuedu.dao.IProductDao;
import com.neuedu.dao.ProductDaoImpl;
import com.neuedu.pojo.Product;
import com.neuedu.pojo.ResultData;


import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductDao dao = new ProductDaoImpl();
    @Override
    public List<Product> getList() {
        return dao.getList();
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

    @Override
    public int brandDele(int brandId) {
        return dao.brandDele(brandId);
    }


    @Override
    public ResultData getLists(int pageNo, int pageSize) {
        ResultData data = new ResultData(pageNo,pageSize,dao.getCount());
        data.setLists(dao.getLists(pageNo,pageSize));
        return data;
    }

    @Override
    public List<Product> getResults(String text) {
        if(text==null){
            return dao.getList();
        }else{
            return dao.getResults(text);
        }

    }
    @Override
    public ResultData getLists(int pageNo, int pageSize, String text) {
        ResultData data = new ResultData(pageNo,pageSize,dao.getCount(text));
        data.setLists(dao.getLists(pageNo,pageSize,text));
        return data;
    }


}
