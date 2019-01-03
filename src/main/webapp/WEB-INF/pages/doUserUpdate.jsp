<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/1
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style_list.css">
    <link rel="stylesheet" href="css/style.css">
    <style>
        select{
            border: 1px solid rgba(255, 255, 255, 0.4);
            background-color: rgba(255, 255, 255, 0.2);
            width: 250px;
            border-radius: 3px;
            padding: 10px 15px;
            margin: 0 auto 10px auto;
            display: block;
            text-align: center;
            font-size: 18px;
            color: white;
            transition-duration: 0.25s;
            font-weight: 300;
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
                            <li><a href="userUpdate">修改/删除</a></li>
                            <li><a href="userList">查询用户信息</a></li>

                        </ul>
                    </li>
                    <li>

                    </li>
                </ul>
            </li>

        </ol>

    </nav>
    <div class="main" style="left: 500px">
        <form action="userUpdateOver">
            <input type="text" readonly="readonly" name="userId" value="${u.userId}">
            <input type="text" name="username" value="${u.username}">
            <input type="text" name="password" value="${u.password}">
            <input type="text" name="email" value="${u.email}">
            <select name="lv">
                <option value="2" >管理员</option>
                <option value="3" >用户</option>
            </select>
            <input type="submit" value="修改">

        </form>
    </div>

</div>
</body>


</html>

