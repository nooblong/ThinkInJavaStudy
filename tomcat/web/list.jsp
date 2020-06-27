<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h3>用户信息表</h3>
<table border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>籍贯</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a href="">操作</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
