package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.pojo.ResultData;
import com.neuedu.pojo.User;
import com.neuedu.service.IProductService;
import com.neuedu.service.IUserService;
import com.neuedu.service.ProductServiceImpl;
import com.neuedu.service.UserServiceImpl;
import com.neuedu.utilTest.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/update")
public class updateServlet extends HttpServlet {
    IProductService service = new ProductServiceImpl();
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset = UTF-8");
        /*第一次访问时 分页情况*/
        int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = 4;

        Cookie[] cookies = req.getCookies();
        Map<String, Cookie> maps = CookieUtil.getCookie(cookies);
        Cookie coo = maps.get("username");
        String uname = coo.getValue();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        List<Product> lists = service.getList();
        req.setAttribute("lists", lists);//添加lists 属性


        /*模糊查询*/
        String text = req.getParameter("text");
        if (text == "" || text == null) {
            /*list 分页条*/
            ResultData data = service.getLists(pageNo, pageSize);
            data.setUrl("update", "");
            req.setAttribute("data", data);
            if (u == null) {
                User user = userService.getOne(uname);
                session.setAttribute("user", user);
                req.getRequestDispatcher("WEB-INF/pages/update.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("WEB-INF/pages/update.jsp").forward(req, resp);
            }
        } else {
            ResultData data = service.getLists(pageNo, pageSize, text);
            String params = "&text=" + text;
            data.setUrl("update", params);

            req.setAttribute("text", text);
            req.setAttribute("data", data);
            req.getRequestDispatcher("WEB-INF/pages/update.jsp").forward(req, resp);
        }

    }
}
