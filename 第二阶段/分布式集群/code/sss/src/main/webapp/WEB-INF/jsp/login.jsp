<%--
  Created by IntelliJ IDEA.
  User: Mr.Cheng
  Date: 2020/4/15
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>简历登录系统</title>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
            font-family: 'Open Sans Light';
            letter-spacing: .05em;
        }
        html {
            height: 100%;
        }

        body {
            height: 100%;
        }

        .container {
            height: 100%;
            background-image: linear-gradient(to right,#fbc2eb, #b5d0ee);
        }

        .login-wrapper {
            background-color: #fff;
            width: 250px;
            height: 500px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            border-radius: 15px;
            top:50%;
            transform: translate(-50%,-50%);
        }
        .login-wrapper .header {
            font-size:  30px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }

        .login-wrapper .form-wrapper .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: none;
            padding: 10px;
            border-bottom: 2px solid rgb(128,125,125);
            font-size: 15px;
            outline: none;
        }

        .login-wrapper .form-wrapper .input-item::placeholder {
            text-transform: uppercase;
        }

        .login-wrapper .form-wrapper .btn {
            text-align: center;
            padding: 5px;
            margin-top: 40px;
            background-image: linear-gradient(to right,#fbc2eb,#a6c1ee);;
            color: #fff;
        }

        .login-wrapper  .msg {
            text-align: center;
            line-height: 80px;
            font-size: small;
            color: #ee2a37;
        }

        .login-wrapper  .msg a  {
            text-decoration-line:  none;
            color: #a6c1ee;
        }

        .login-button-box{
            margin-top: 12px;
            width: 100%;
            height: 30px;
            margin-left: auto;
            margin-right: auto;
            display: inline-block;
            background-image: linear-gradient(to right,#fbc2eb,#a6c1ee);;
            color: #000000;
        }

        .login-button-box button{
            background-color: #ff7d0a;
            color: #ffffff;
            font-size: 16px;
            width: 386px;
            height: 40px;
            margin-left: 18px;
            border: 1px solid #ff7d0a;
            border-radius: 4px;
        }

        .login-button-box button:hover{
            background-color: #ee7204;
        }

        .login-button-box button:active{
            background-color: #ee7204;
        }
    </style>

</head>
<body>

<div class="container">
    <div class="login-wrapper">
        <div class="header">2简历登录系统</div>
        <div class="form-wrapper">
            <form action="/sss/login/handler" method="post">
                <input type="text" name="username" placeholder="username" class="input-item">
                <input type="password" name="password" placeholder="password" class="input-item">
                <input class="login-button-box" type="submit" value="登陆">
                <input class="login-button-box" type="reset" value="取消">
            </form>
        </div>
        <div id="mm" style="display: none"><%=request.getAttribute("message")%></div>
        <div id="mg" class="msg"></div>
    </div>
</div>

</body>
<script type="text/javascript">
    var value = document.getElementById('mm').innerText.valueOf();
    if (value == "您还没登录，请先登录！") {
        alert(value);
        document.getElementById('mg').innerText = value;
    }
</script>
</html>
