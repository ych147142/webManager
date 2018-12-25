package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
@MultipartConfig
@WebServlet("/doAdd")
public class DoAddServlet extends HttpServlet {
    IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset = UTF-8");
        String name = req.getParameter("name");
        Double price =Double.parseDouble(req.getParameter("price"));
        int bId = Integer.parseInt(req.getParameter("bId"));
        int count = Integer.parseInt(req.getParameter("count"));

        /*
         * 图片上传
         */
        Part part = req.getPart("url");
        /*文件上传后的路径和名称*/
        String str = "C:\\Users\\Administrator\\IdeaProjects\\webManager\\src\\main\\webapp\\img\\"+part.getSubmittedFileName();
        File file = new File(str);
        String url = str.substring(str.indexOf("img"));
        /*输出流 向指定位置写数据*/
        OutputStream os = new FileOutputStream(file);
        /*文件接收*/
        InputStream is = part.getInputStream();
        byte [] b = new byte[is.available()];
        int a = is.read(b);
        while (a != -1){
            os.write(b);
            a = is.read(b);
        }

        String des = req.getParameter("des");

        Product p = new Product();
        p.setProductName(name);
        p.setPrice(price);
        p.setUrl(url);
        p.setProductDes(des);
        p.setBrandId(bId);
        p.setCount(count);

        service.add(p);
        resp.sendRedirect("list");
    }
}
