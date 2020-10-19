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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setAttribute("path",request.getContextPath());%>
<html>

<head>
    <title>Title</title>
    <script type="text/javascript">
        function aaa(){
            document.getElementsByTagName("span")[0].innerHTML="";
        }

        function sendAjax(){
            var unInput = document.getElementsByName("username")[0];
            var xmlhttp = new XMLHttpRequest();
            var url = "verifyUsername?"+unInput.name+"="+unInput.value;
            xmlhttp.open("GET",url,true);
            xmlhttp.send();
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    document.getElementsByTagName("span")[0].innerHTML=xmlhttp.responseText;
                }
            }

        }

    </script>
</head>
<body bgcolor="#ffe4c4">
<h1>登录页面</h1>
    <c:if test="${empty welcome}">
        <form action="LoginServlet" method="POST">
            用户姓名:<input name="username" value="${ cookie.username.value }" onchange="aaa()" onblur="sendAjax()">
            <span >${ error }</span><br>
            用户密码:<input name="password" type="password" value="${ cookie.password.value }"><br>
            <input value="提交" type="submit">
        </form>
    </c:if>
    <c:if test="${!empty welcome}">
        <h2 align="center"> 欢迎${welcome}</h2>
        <a href="${path}/LoginServlet?username=${cookie.username.value }&password=${ cookie.password.value}">显示所有员工</a>
    </c:if>
</body>
</html>