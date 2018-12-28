package com.neuedu.controller;

import com.neuedu.pojo.Brand;
import com.neuedu.pojo.Product;
import com.neuedu.service.BrandServiceImpl;
import com.neuedu.service.IBrandService;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet("/doUpdate")
public class DoUpdate extends HttpServlet {
    IProductService service = new ProductServiceImpl();
    IBrandService bservice = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        Product p = service.getOne(id);

        req.setAttribute("p",p);

        List<Brand> brandLists = bservice.getLists();
        req.setAttribute("brandLists", brandLists);

        req.getRequestDispatcher("WEB-INF/pages/doUpdate.jsp").forward(req,resp);
    }
}
