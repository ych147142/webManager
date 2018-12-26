package com.neuedu.service;

import com.neuedu.dao.BrandDaoImpl;
import com.neuedu.dao.IBrandDao;
import com.neuedu.pojo.Brand;

import java.util.List;

public class BrandServiceImpl implements IBrandService {
    IBrandDao dao = new BrandDaoImpl();
    @Override
    public List<Brand> getLists() {
        return dao.getLists();
    }

    @Override
    public int add(Brand brand) {
        return dao.add(brand);
    }

    @Override
    public int update(Brand brand) {
        return dao.update(brand);
    }

    @Override
    public int dele(int id) {
        return dao.dele(id);
    }

    @Override
    public Brand getOne(int id) {
        return dao.getOne(id);
    }
}
