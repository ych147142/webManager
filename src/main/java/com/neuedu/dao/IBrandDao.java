package com.neuedu.dao;

import com.neuedu.pojo.Brand;

import java.util.List;

public interface IBrandDao {
    public List<Brand> getLists();
    public int add(Brand brand);
    public int update(Brand brand);
    public int dele(int id);
    public Brand getOne(int id);
}
