<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/29
  Time: 15:04
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
    <style>
        .pagebean li:nth-child(1),
        .pagebean li:nth-child(2),
        .pagebean li:nth-last-child(1),
        .pagebean li:nth-last-child(2)
        {
            width: 60px;
        }

    </style>

</head>

<body>
<div class="body">
    <nav class="menu">
        <header>欢迎${user.username}
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
                        <a href="list">查询</a>
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
                        <a href="brandAdd">添加</a>
                    </li>
                    <li>
                        <a href="brandUpdate">修改</a>
                    </li>
                    <li>
                        <a href="brandList">查询</a>
                    </li>
                    <li>
                        <a href="brandDelet">删除</a>
                    </li>

                </ul>
            </li>
            <li class="menu-item">
                <a href="userList">用户管理</a>
                <ul class="menu_hide">
                    <li>
                        <a href="#">用户操作</a>
                        <ul class="second_menu_hide">
                            <li><a href="userAdd">添加用户</a></li>
                            <li><a href="userUpdate">修改用户信息</a></li>
                            <li><a href="useList">查询用户信息</a></li>
                            <li><a href="userDelet">删除用户</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">角色管理</a>
                    </li>
                </ul>
            </li>

        </ol>

    </nav>
    <div class="main">
        <form id="fm">
            <input type="text" name="text" class="search" value="${text}">
            <input type="submit" class="search_button" value="搜索">
        </form>
        <section>
            <!--for demo wrap-->
            <h1>员 工 信 息 查 询 列 表</h1>
            <div class="tbl-header">
                <table cellpadding="0" cellspacing="0" border="0">
                    <thead>
                    <tr>
                        <th>员工编号</th>
                        <th>员工名称</th>
                        <th>密码</th>
                        <th>邮箱</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                    <c:forEach items="${userLists}" var="u">
                        <tr>
                            <td>${u.userId}</td>
                            <td>${u.username}</td>
                            <td>${u.password}</td>
                            <td>${u.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <ul class="pagebean">
                ${data.pageView}
            </ul>

        </section>

    </div>
</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>

<script src="js/index.js"></script>

</body>

</html>