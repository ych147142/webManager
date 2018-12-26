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
@WebServlet("/doBrandAdd")
public class DoBrandAddServlet extends HttpServlet {
    IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset = UTF-8");
        String bname = req.getParameter("bname");
        String bdes = req.getParameter("bdes");
        String btime = req.getParameter("btime");

        Brand b = new Brand();
        b.setBrandName(bname);
        b.setBrandDes(bdes);
        b.setBrandTime(btime);
        service.add(b);
        resp.sendRedirect("brandList");
    }
}
