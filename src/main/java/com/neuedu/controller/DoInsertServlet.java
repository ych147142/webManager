package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doInsert")
public class DoInsertServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        System.out.println(email);
        User u = new User();
        u.setUsername(username);
        u.setPassword(pwd);
        u.setEmail(email);
        int result = service.insert(u) ;
        if (result>0){
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }
}
