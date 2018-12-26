package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/updateOver")
public class UpdateOverServlet extends HttpServlet {
    IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("productId"));
        System.out.println(id);
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String des = req.getParameter("des");
        String url = req.getParameter("url");
        int bId = Integer.parseInt(req.getParameter("brandId"));
        int count = Integer.parseInt(req.getParameter("count"));
        Product p = new Product();
        p.setPrice(price);
        p.setProductDes(des);
        p.setProductName(name);
        p.setUrl("img/"+url);
        p.setProductId(id);
        p.setCount(count);
        p.setBrandId(bId);
        service.update(p);
        resp.sendRedirect("list");
    }
}
