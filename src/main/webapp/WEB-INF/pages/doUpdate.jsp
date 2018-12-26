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

        </ol>

    </nav>
    <div class="main" style="left: 500px">
        <form action="updateOver"  enctype="multipart/form-data">
            <input type="text" readonly="readonly" name="productId" value="${p.productId}">
            <input type="text" name="brandId" value="${p.brandId}">
            <input type="text" name="name" value="${p.productName}">
            <input type="text" name="price"  value="${p.price}">
            <input type="text" name="des" value="${p.productDes}">
            <input type="text" name="count" value="${p.count}">
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
</div>
</body>


</html>

