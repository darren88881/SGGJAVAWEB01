<%--
  Created by IntelliJ IDEA.
  User: darren
  Date: 2020/10/15
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>班级同学表</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>LASTNAME</td>
            <td>GENDER</td>
            <td>EMAIL</td>
        </tr>
        <c:forEach items="${emps}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.lastName}</td>
                <td>${e.gender}</td>
                <td>${e.email}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
