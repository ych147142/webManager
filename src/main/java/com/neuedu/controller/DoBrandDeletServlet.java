package com.neuedu.controller;

import com.neuedu.service.BrandServiceImpl;
import com.neuedu.service.IBrandService;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doBrandDelet")
public class DoBrandDeletServlet extends HttpServlet {
    IBrandService bservice = new BrandServiceImpl();
    IProductService pservice = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        bservice.dele(id);
        pservice.brandDele(id);
        resp.sendRedirect("brandDelet");
    }
}
