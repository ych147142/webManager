<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/2
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style_list.css">
    <link rel="stylesheet" href="css/style_input.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

    <style>
        #o ,#cn{
            color: #53e3a6;
            font-size: 12px;
            float:right;
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
                <a href="selectList">主页</a>
            </li>
            <li class="menu-item">
                <a href="edit">修改密码</a>
            </li>

        </ol>

    </nav>
    <div class="main" style="left: 500px;">
        <form  method="post">
            <h1 style="text-align: center;">修 改 密 码</h1>

            <div class="question">
                <input type="password" name="oldpwd" class="bl" id="oldpwd" required/><span id="o"></span>
                <label>请输入原密码</label>
            </div>
            <div class="question">
                <input type="password" name="newpwd" class="bl" id="newpwd" required/>
                <label>请输入新密码</label>
            </div>
            <div class="question">
                <input type="password" name="cnewpwd" class="bl" id="cnewpwd" required/><span id="cn"></span>
                <label>再次确认密码</label>
            </div>
            <button id="up_button" disabled="disabled">修改</button>
        </form>
    </div>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        var oldpwd;
        var newpwd;
        var cnewpwd;
        $(".bl").blur(function () {
            oldpwd = $("#oldpwd").val();
            newpwd = $("#newpwd").val();
            cnewpwd = $("#cnewpwd").val();
            $.ajax({
                url: "editProfile",
                type:"post",
                data:{"oldpwd":oldpwd,"newpwd":newpwd,"cnewpwd":cnewpwd},
                success:function (result) {
                    console.log(result)
                    if (result == "4") {
                        $("#o").text("密码不正确")
                    }
                    if(result == "13"){
                        $("#o").text("")
                        $("#cn").text("两次密码不一致")
                    }
                    if (result == "12") {
                        $("#o").text("")
                        $("#cn").text("")
                        $("#up_button").attr("disabled",false)
                    }

                }
            });
        });

        $("#up_button").click(function () {
            $.ajax({
                url:"doEdit",
                type:"post",
                data:{"oldpwd":oldpwd,"newpwd":newpwd,"cnewpwd":cnewpwd},
                success:function (data) {
                    console.log(data)
                    if (data > 0){
                        alert("修改成功")
                        window.location.href="http://localhost:8080/webManager/exit"
                    }
                }
            });
        });


    });
</script>


</body>
</html>
