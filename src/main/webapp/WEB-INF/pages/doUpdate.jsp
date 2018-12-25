<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 8:15
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
    <form action="updateOver"  enctype="multipart/form-data">
        <input type="text" readonly="readonly" name="productId" value="${p.productId}">
        <input type="text" name="name" value="${p.productName}">
        <input type="text" name="price"  value="${p.price}">
        <input type="text" name="des" value="${p.productDes}">
        <input type="file" name="url" id="url" onchange="imgChange(this)">
        <img id="img" width="100">

        <input type="submit" value="修改">
    </form>
</div>

<script>
    function imgChange(obj) {

        /*文件读取器*/
        var reader = new FileReader();
        console.log(reader);
        reader.onload = function (ev) {
            var img = document.getElementById("img")
            img.src = ev.target.result;
        }
        reader.readAsDataURL(obj.files[0]);
    }
</script>
</body>


</html>
