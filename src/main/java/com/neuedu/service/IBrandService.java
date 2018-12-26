package com.neuedu.service;

import com.neuedu.pojo.Brand;

import java.util.List;

public interface IBrandService {
    public List<Brand> getLists();
    public int add(Brand brand);
    public int update(Brand brand);
    public int dele(int id);
    public Brand getOne(int id);
}
