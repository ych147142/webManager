<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/23
  Time: 17:59
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

        </ol>

    </nav>
    <div class="main" style="left: 500px">
        <form action="doAdd" method="post" enctype="multipart/form-data">
            <input type="text" name="name" placeholder="商品名称">
            <select name="bId">
                <option >商品品牌</option>
                <c:forEach items="${brandLists}" var="b">
                    <option  value="${b.id}">${b.brandName}</option>


                </c:forEach>
            </select>

            <input type="text" name="price" placeholder="商品价格">
            <input type="text" name="des" placeholder="商品描述">
            <input type="text" name="count" placeholder="库存">
            <input type="file" name="url" placeholder="商品图片" onchange="imgChange(this)">
            <img id="img" width="100">

            <input type="submit" value="添加">
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
