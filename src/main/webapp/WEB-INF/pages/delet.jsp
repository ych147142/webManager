<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="css/style1.css">
    <style>
        table tbody tr:nth-child(odd) {
            background: #859ef2;
        }
        .select{
            margin-top: 10px;

            display: none;
        }
        .text {
            width: 219px;
        }
        .s_button{
            margin-left: 162px;
            border-radius: 15px;
            background-color: #cccccc;
        }

        .menu-item:hover .select{
            display: block;
        }

        table tbody td a {
            text-decoration: none;
            color: #fff;
        }
    </style>
</head>

<body>
<div class="body">
    <nav class="menu">
        <header>欢迎${user.username} <span>×</span></header>
        <ol>
            <li class="menu-item">
                <a href="list">Home</a>
            </li>
            <li class="menu-item">
                <a href="#add">insert</a>
            </li>
            <li class="menu-item">
                <a href="delet">delete</a>
            </li>
            <li class="menu-item">
                <a href="update">update</a>
            </li>
            <li class="menu-item">
                <a href="#0">select</a>
                <form method="post" class="select">
                    <input type="text" class="text" placeholder="请输入要查询的产品名" name="text" value="${text}" >
                    <input type="submit" value="搜索" class="s_button">
                </form>

            </li>
            <li class="menu-item">
                <a href="exit">Exit</a>
            </li>
        </ol>
        <footer><button aria-label="Toggle Menu">Toggle</button></footer>

    </nav>

    <div class="main">

        <table>
            <thead>
            <tr>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品图片</th>
                <th>商品详情</th>
                <th>操作</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lists}" var="p">
                <tr>
                    <td>${p.productId}</td>
                    <td>${p.productName}</td>
                    <td>${p.price}</td>
                    <td><img src="${p.url} " height="50"></td>
                    <td>${p.productDes}</td>
                    <td><a href="doDelet?productId=${p.productId}">删除</a></td>
                </tr>
                </tr>
            </c:forEach>
            </tbody>


        </table>
    </div>
</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>

<script src="js/index.js"></script>

</body>

</html>



