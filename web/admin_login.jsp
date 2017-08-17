<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <%@include file="linkCss.jsp" %>
    <title>
        后台登陆
    </title>
</head>

<body style="background-color: #ecf0f1">
<%@include file="top.jsp" %>

<h3 class="text-center">后台登陆</h3>

<form action="/JspLoginServlet" style="margin: 0 auto; width: 100%; height: 100%; max-width: 400px;max-height: 300px;">
    <div class="login-form" style="background-color: #a6e1ec">
        <div class="form-group">
            <input name="userName" type="text" class="form-control login-field" value="" placeholder="用户名" id="login-name">
            <label class="login-field-icon fui-user" for="login-name"></label>
        </div>

        <div class="form-group">
            <input name="userPassword" type="password" class="form-control login-field" value="" placeholder="密码" id="login-pass">
            <label class="login-field-icon fui-lock" for="login-pass"></label>
        </div>

        <button type="submit" class="btn btn-primary btn-lg btn-block"><font><font>登录</font></font></button>
        <a class="login-link" href="#"><font><font>修改密码</font></font></a>
    </div>
</form>

<%@include file="linkScript.jsp" %>
</body>
</html>