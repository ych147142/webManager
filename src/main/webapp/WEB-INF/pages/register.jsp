<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper2">
    <div class="container">
        <h1>Please register your account</h1>

        <form class="form" action="/doRegister">
            <input type="text" placeholder="Username" name="username" id="username" class="ac"><span id="message"></span>
            <input type="password" placeholder="Password" name="pwd" id="pwd">
            <input type="password" placeholder="Confirm Password" name="cpwd" id="cpwd" class="ac"><span id="pms"></span>
            <input type="email" placeholder="email" name="email" id="email">
            <button type="button" id="login-button" disabled="disabled" >sign up</button>
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
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script>
    $(function () {
        var uname;
        var pwd;
        var cpwd;
        var email;
        var lv;
        $(".ac").blur(function () {
            uname =$("#username").val();
            pwd = $("#pwd").val();
            cpwd = $("#cpwd").val();
            email = $("#email").val();
            $.ajax({
                url:"doRegister",
                type:"get",
                data:{"username":uname,"pwd":pwd,"cpwd":cpwd,"email":email ,"lv":lv},
                success:function (result) {
                    if (result == 1){
                        $("#message").text("用户名已存在");
                    }
                    if (result == 4){
                        $("#message").text("用户名可用");
                    }

                    if (result == 42){
                        $("#pms").text("两次密码不一致");

                    }
                    if (result == 43){
                        $("#message").text("用户名可用");
                        $("#pms").text("密码可用");
                        $("#login-button").attr("disabled",false);
                    }

                }

            });


        })

        $("#login-button").click(function () {
            $.ajax({
                url:"doInsert",
                type:"post",
                data:{"username":uname,"pwd":pwd,"cpwd":cpwd,"email":email ,"lv":lv},
                success:function (data) {
                    console.log(data)
                    if (data > 0){
                        alert("注册成功")
                        window.location.href="http://localhost:8080/webManager/login"
                    }
                }
            });
        });


    });
</script>
</body>
</html>
