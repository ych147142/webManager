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
@WebServlet("/doBrandUpdate")
public class DoBrandUpdateServlet extends HttpServlet {
    IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Brand b= service.getOne(id);
        req.setAttribute("b",b);
        req.getRequestDispatcher("WEB-INF/pages/doBrandUpdate.jsp").forward(req,resp);
    }
}
