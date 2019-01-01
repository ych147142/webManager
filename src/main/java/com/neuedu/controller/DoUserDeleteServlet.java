package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doUserDelet")
public class DoUserDeleteServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUserId();
        System.out.println(uid);
        if (id != uid){
            service.dele(id);
            resp.sendRedirect("userList");
        }else {
            resp.sendRedirect("userUpdate");
        }

    }
}
