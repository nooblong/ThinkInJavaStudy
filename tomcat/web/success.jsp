<%--
  Created by IntelliJ IDEA.
  User: lyl
  Date: 2020/6/27
  Time: 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1>
        <%=
          request.getSession().getAttribute("user")
        %>
       , welcome
    </h1>
</body>
</html>
