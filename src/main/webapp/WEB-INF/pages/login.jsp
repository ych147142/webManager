<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <link rel="stylesheet" href="css/style.css">


</head>

<body>

<div class="wrapper">
    <div class="container">
        <h1>Welcome</h1>

        <form class="form" id="fm" method="post" >
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <button type="button" id="login-button">Login</button><br><br>
            <a href="register">如果没有账号，请注册</a>

        </form>

    </div>

    <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<script src='js/jquery-3.3.1.min.js'></script>
<script>
    $(function () {


        $("#login-button").click(function () {

            var fm = $("#fm").serialize();
            console.log(fm)

            $.ajax({
                url:"dologin",
                type:"post",
                data:fm,
                success:function (data) {

                    if (data == "1"){
                        alert("登录成功");
                        window.location.href="http://localhost:8080/webManager/list"
                    }
                    if (data == "2"){
                        alert("账号不存在")
                    }
                    if (data == "3"){
                        alert("密码错误");
                    }

                }

            });
        })
    });
    
</script>





</body>

</html>
