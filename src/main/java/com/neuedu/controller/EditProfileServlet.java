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
@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String oldpwd = req.getParameter("oldpwd");
        String newpwd = req.getParameter("newpwd");
        String cnewpwd = req.getParameter("cnewpwd");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        String uname = user.getUsername();
        String pwd = user.getPassword();

        if (oldpwd.equals(pwd)){
            resp.getWriter().write("1");//密码正确
            if (newpwd.equals(cnewpwd)){
                resp.getWriter().write("2");//密码一致
            }else {
                resp.getWriter().write("3");//密码不一致
            }
        }else {
            resp.getWriter().write("4");//密码不正确
        }



    }
}
