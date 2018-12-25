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

    <link rel="stylesheet" href="css/style_list.css">
    <link rel="stylesheet" href="css/style_table.css" />

</head>

<body>
<div class="body">
    <nav class="menu">
        <header>欢迎
            <a href="exit"><img src="img/退出.png" width="30px" /></a>
        </header>
        <ol>
            <li class="menu-item">
                <a href="list">主页</a>
            </li>
            <li class="menu-item">
                <a href="profile">修改密码</a>
            </li>
            <li class="menu-item">
                <a href="#">商品管理</a>
                <ul class="menu_hide">
                    <li>
                        <a href="add">添加</a>
                    </li>
                    <li>
                        <a href="update">修改</a>
                    </li>
                    <li>
                        <a href="">查询</a>
                    </li>
                    <li>
                        <a href="delet">删除</a>
                    </li>

                </ul>
            </li>
            <li class="menu-item">
                <a href="">品牌管理</a>
                <ul class="menu_hide">
                    <li>
                        <a href="add">添加</a>
                    </li>
                    <li>
                        <a href="update">修改</a>
                    </li>
                    <li>
                        <a href="">查询</a>
                    </li>
                    <li>
                        <a href="delet">删除</a>
                    </li>

                </ul>
            </li>

        </ol>

    </nav>
    <div class="main">

        <section>
            <!--for demo wrap-->
            <h1>商 品 查 询 列 表</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                    <tr>
                        <th>商品编号</th>
                        <th>品牌编号</th>
                        <th>商品图片</th>
                        <th>商品价格</th>
                        <th>商品价格</th>
                        <th>商品库存</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                    <c:forEach items="${lists}" var="p">
                        <tr>
                            <td>${p.productId}</td>
                            <td>${p.productName}</td>
                            <td>${p.price}</td>
                            <td><img src="${p.url} " height="50"></td>
                            <td>${p.productDes}</td>
                            <td><a href="doUpdate?productId=${p.productId}">修改</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </section>

    </div>
</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>

<script src="js/index.js"></script>

</body>

</html>



