package com.neuedu.pojo;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private String productDes;
    private String url;
    private double price;
    private int brandId;
    private int count;

    public Product() {
    }


    public Product(int productId, String productName, String productDes, String url, double price, int brandId, int count) {
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.url = url;
        this.price = price;
        this.brandId = brandId;
        this.count = count;
    }
}
