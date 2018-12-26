package com.neuedu.controller;

import com.neuedu.pojo.Brand;
import com.neuedu.pojo.Product;
import com.neuedu.service.BrandServiceImpl;
import com.neuedu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brandUpdateOver")
public class BrandUpdateOverServlet extends HttpServlet {
    IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("bId"));

        String name = req.getParameter("name");

        String des = req.getParameter("des");
        String time = req.getParameter("time");

       Brand b = new Brand();
       b.setId(id);
       b.setBrandName(name);
       b.setBrandDes(des);
       b.setBrandTime(time);
       service.update(b);
        resp.sendRedirect("list");
    }
}
