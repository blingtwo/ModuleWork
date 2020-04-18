<%--
  Created by IntelliJ IDEA.
  User: Mr.Cheng
  Date: 2020/4/15
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>简历主页</title>
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

            width: 480px;
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
            width: 480px;
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

    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div>
            在线用户：<span>${sessionScope.LOGIN_USER}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <a href="${pageContext.request.contextPath}/login/logoutHandler">退出</a>
        </div>
        <hr width="480px" align="left">
        <br>
        <div>
            <table id="hor-minimalist-a">
                <thead>
                <tr>
                    <th scope="col">简历列表</th>
                    <th colspan="4" scope="col" align="right"><a href="addPage">>>新增<<</a></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">姓名</th>
                    <th scope="col">地址</th>
                    <th scope="col">电话</th>
                    <th scope="col">操作</th>
                </tr>
                <c:forEach var="resume" items="${resumes}">
                    <tr>
                        <td>${resume.id}</td>
                        <td>${resume.name}</td>
                        <td>${resume.address}</td>
                        <td>${resume.phone}</td>
                        <td><a href="editPage/${resume.id}">编辑</a>&nbsp&nbsp&nbsp<a href="delete/${resume.id}">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
