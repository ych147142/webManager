package com.neuedu.controller;


import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dologin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = service.getOne(username);

        if (user == null){
            resp.getWriter().write("2");

        }else {
            if (user.getPassword().equals(password)){
               if (username.equals("ych")){
                   resp.getWriter().write("1");

               }else {
                   resp.getWriter().write("4");

               }

                /*添加cookie*/
                Cookie cookn =new Cookie("username",username);
                Cookie cookp = new Cookie("password",password);
                /*设置cookie最大存活时间*/
                cookn.setMaxAge(60*60*24*7);
                cookp.setMaxAge(60*60*24*7);
                resp.addCookie(cookn);
                resp.addCookie(cookp);

                /*Session*/
                HttpSession session = req.getSession();
                session.setAttribute("user",user);


        }else {

                resp.getWriter().write("3");
            }
        }

    }
}
