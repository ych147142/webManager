<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/26
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style_list.css">
    <link rel="stylesheet" href="css/style.css">
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
        <form action="brandUpdateOver">
            <input type="text" readonly="readonly" name="bId" value="${b.id}">
            <input type="text" name="name" value="${b.brandName}">
            <input type="text" name="des" value="${b.brandDes}">
            <input type="text" name="time" value="${b.brandTime}">

            <input type="submit" value="修改">

        </form>
    </div>

</div>
</body>


</html>

