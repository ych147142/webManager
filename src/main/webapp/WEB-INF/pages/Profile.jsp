<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style1.css">
    <link rel="stylesheet" href="css/style.css">
    <style>

    </style>
</head>

<body>
<nav class="menu">
    <header>欢迎${user.username} <span>×</span></header>
    <ol>
        <li class="menu-item">
            <a href="list">Home</a>
        </li>
        <li class="menu-item">
            <a href="add">insert</a>
        </li>
        <li class="menu-item">
            <a href="delet">delete</a>
        </li>
        <li class="menu-item">
            <a href="update">update</a>
        </li>
        <li class="menu-item">
            <a href="#0">select</a>
        </li>
        <li class="menu-item">
            <a href="exit">Exit</a>
        </li>
    </ol>
    <footer><button aria-label="Toggle Menu">Toggle</button></footer>

</nav>
<div class="main">
    <form action="editProfile" method="post" >
        <input type="text" name="oldpwd" id="oldpwd" class="a" placeholder="请输入原密码"><span id="p1"></span>
        <input type="text" name="newpwd" id="newpwd" placeholder="请输入新密码">
        <input type="text" name="cnewpwd" id="cnewpwd" class="a" placeholder="再次输入密码"><span id="p2"></span>
        <button type="button" id="S_button" disabled="disabled">修改密码</button>
    </form>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {

    })
</script>


</body>
</html>
