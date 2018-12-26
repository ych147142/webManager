package com.neuedu.controller;

import com.neuedu.pojo.Brand;
import com.neuedu.service.BrandServiceImpl;
import com.neuedu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brandDelet")
public class BrandDeletServlet extends HttpServlet {
    IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brandLists = service.getLists();
        req.setAttribute("brandLists", brandLists);
        req.getRequestDispatcher("WEB-INF/pages/brandDelet.jsp").forward(req,resp);
    }
}
