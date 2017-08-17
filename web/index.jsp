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
        IT题库，面试不再手足无措！
    </title>
</head>

<body style="background-color: #ecf0f1">
<%@include file="top.jsp" %>
<div class="text-center">
    <h2 class="hidden-xs"><span style="color:#00ADEF">I</span><span style="color:#E70012">T</span>题库</h2>
    <img src="http://qiniu.marvel.ac.cn/img/language/c.png" alt="C语言" width="76" height="76"
         style="background: #337ab7;border-radius: 5px;margin: 5px">
    <img src="http://qiniu.marvel.ac.cn/img/language/android_black.png" alt="ANDROID语言" width="76" height="76"
         style="background: #5cb85c;border-radius: 5px;margin: 5px">
    <img src="http://qiniu.marvel.ac.cn/img/language/php_black.png" alt="PHP语言" width="76" height="76"
         style="background: #5bc0de;border-radius: 5px;margin: 5px">
    <img src="http://qiniu.marvel.ac.cn/img/language/java.png" alt="JAVA语言" width="76" height="76"
         style="background: #f0ad4e;border-radius: 5px;margin: 5px">
    <img src="http://qiniu.marvel.ac.cn/img/language/mysql_black.png" alt="MYSQL" width="76" height="76"
         style="background: #d9534f;border-radius: 5px;margin: 5px">
    <img src="http://qiniu.marvel.ac.cn/img/language/apple.png" alt="MYSQL" width="76" height="76"
         style="background: #26a69a;border-radius: 5px;margin: 5px">
    <h3>现已开放下载！</h3>
    <img src="http://qiniu.marvel.ac.cn/img/logo/untitled.png" width="150" height="150" alt="二维码" class="img-thumbnail"><h6>扫描二维码立即下载</h6>
</div>

<footer class="bottom">
    <div class="container text-center">
        <hr/>
        <div class="row footer">
            </div>
        <a href="about.jsp">关于我们</a><b style="margin: 10px">|</b><a href="admin_login.jsp">后台管理</a><b style="margin: 10px">|</b><a href="http://www.miitbeian.gov.cn/" target="_blank">赣ICP备16004902号-1</a>
        <hr/>
        </div>
    </footer>

<%@include file="linkScript.jsp" %>
</body>
</html>