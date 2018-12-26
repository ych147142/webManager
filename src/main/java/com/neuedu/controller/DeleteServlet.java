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

@WebServlet("/delet")
public class DeleteServlet extends HttpServlet {
    IProductService pservice = new ProductServiceImpl();
    IUserService uService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset = UTF-8");
        /*第一次访问时 分页情况*/
        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize=4;

        Cookie [] cookies =req.getCookies();
        Map<String,Cookie> maps = CookieUtil.getCookie(cookies);
        Cookie coo = maps.get("username");
        String uname =coo.getValue();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        List<Product> lists =pservice.getList();
        req.setAttribute("lists",lists);//添加lists 属性


        /*模糊查询*/
        String text = req.getParameter("text");
        if(text==""||text==null){
            /*list 分页条*/
            ResultData data  = pservice.getLists(pageNo,pageSize);
            data.setUrl("delet","");
            req.setAttribute("data",data);
            if (u == null){
                User user = uService.getOne(uname);
                session.setAttribute("user",user);
                req.getRequestDispatcher("WEB-INF/pages/delet.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("WEB-INF/pages/delet.jsp").forward(req,resp);
            }
        }else{
            ResultData data  = pservice.getLists(pageNo,pageSize,text);
            String params="&text="+text;
            data.setUrl("delet",params);

            req.setAttribute("text",text);
            req.setAttribute("data",data);
            req.getRequestDispatcher("WEB-INF/pages/delet.jsp").forward(req,resp);
        }
    }
}
