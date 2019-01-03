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

@WebServlet("/doEdit")
public class DoEditServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newpwd = req.getParameter("newpwd");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        User u = new User();
        u.setUsername(username);
        u.setPassword(newpwd);
        int result = service.updatePwd(u) ;
        if (result>0){
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }

    }
}
