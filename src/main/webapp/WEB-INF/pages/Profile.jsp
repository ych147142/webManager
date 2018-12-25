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
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="css/style_list.css">
    <link rel="stylesheet" href="css/style_input.css" />

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
    <div class="main" style="left: 500px;">
        <form>
            <h1 style="text-align: center;">修 改 密 码</h1>

            <div class="question">
                <input type="text" required/>
                <label>请输入原密码</label>
            </div>
            <div class="question">
                <input type="text" required/>
                <label>请输入新密码</label>
            </div>
            <div class="question">
                <input type="text" required/>
                <label>再次确认密码</label>
            </div>
            <button>修改</button>
        </form>
    </div>
</div>
<script>
    function imgChange(obj) {

        /*文件读取器*/
        var reader = new FileReader();
        console.log(reader);
        reader.onload = function(ev) {
            var img = document.getElementById("img")
            img.src = ev.target.result;
        }
        reader.readAsDataURL(obj.files[0]);
    }
</script>


</body>
</html>
