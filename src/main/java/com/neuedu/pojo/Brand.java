package com.neuedu.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class Brand {
    private int id;
    private String brandName;
    private String brandDes;
    private String brandTime;
    private Set<Product> sets;

    public Brand(int id, String brandName, String brandDes, String brandTime, Set<Product> sets) {
        this.id = id;
        this.brandName = brandName;
        this.brandDes = brandDes;
        this.brandTime = brandTime;
        this.sets = sets;
    }
    public Brand(){

    }
}