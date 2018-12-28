package com.neuedu.controller;

import com.neuedu.pojo.Brand;
import com.neuedu.pojo.User;
import com.neuedu.service.BrandServiceImpl;
import com.neuedu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        List<Brand> brandLists = service.getLists();
        req.setAttribute("brandLists", brandLists);
        req.getRequestDispatcher("WEB-INF/pages/add.jsp").forward(req,resp);
    }
}
