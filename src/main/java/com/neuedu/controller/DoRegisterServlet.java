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

@WebServlet("/doRegister")
public class DoRegisterServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String cpwd = req.getParameter("cpwd");
        String email = req.getParameter("email");

        if (username!=""){
            User user = service.getOne(username);
            if (user == null){
                resp.getWriter().write("4");
                if (pwd!="" && cpwd!=""){
                    if (pwd.equals(cpwd)){
                        resp.getWriter().write("3");
                    }else {
                        resp.getWriter().write("2");
                    }
                }
            }else {
                resp.getWriter().write("1");
            }
        }


    }
}

