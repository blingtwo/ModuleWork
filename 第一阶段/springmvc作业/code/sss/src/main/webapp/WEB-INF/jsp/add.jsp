<%--
  Created by IntelliJ IDEA.
  User: Mr.Cheng
  Date: 2020/4/16
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>新增</title>
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

            width: 280px;
            height: 500px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            border-radius: 15px;
            top:50%;
            transform: translate(-50%,-50%);
        }
        #hor-minimalist-a
        {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 12px;
            width: 280px;
            border-collapse: collapse;
            text-align: left;
        }
        #hor-minimalist-a th
        {
            font-size: 14px;
            font-weight: normal;
            color: #039;
            padding: 10px 8px;
            border-bottom: 2px solid #6678b1;
        }
        #hor-minimalist-a td
        {
            color: #669;
            padding: 9px 8px 0px 8px;
        }
        #hor-minimalist-a tbody tr:hover td
        {
            color: #009;
        }

        .login-button-box{
            margin-top: 12px;
            width: 100%;
            margin-left: auto;
            margin-right: auto;
            display: inline-block;
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
        .is {
            width: 100%;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="login-wrapper">
        <form method="post" action="${pageContext.request.contextPath}/resume/addResume">
            <table id="hor-minimalist-a">
                <tr>
                    <td><input type="hidden" name="id"  value="${theResume.id}"/></td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input class="is" name="name" value="${theResume.name}"/></td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td><input class="is" name="address" value="${theResume.address}" /></td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td><input class="is" name="phone" value="${theResume.phone}"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input class="login-button-box" type="submit" value="确定" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
