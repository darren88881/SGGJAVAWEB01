<%--
  Created by IntelliJ IDEA.
  User: darren
  Date: 2020/9/12
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.lang.String" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <script type="text/javascript">
        function aaa(){

            document.getElementsByTagName("span")[0].innerHTML="";

        }

    </script>
</head>
<body bgcolor="#ffe4c4">
<h1>登录页面</h1>
<form action="LoginServlet" method="get">
    用户姓名:<input name="username" value="${ username }" onchange="aaa()">
    <span >${ error }</span><br>
    用户密码:<input name="password" type="password" value="${ password }"><br>
    <input value="提交" type="submit">
</form>
</body>
</html>