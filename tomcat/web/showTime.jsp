<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("not first");
        boolean flag = false;

//        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                if ("lastTime".equals(name)){
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    out.write("<h1>welcome back last time is " + value + "</h1>");


                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = simpleDateFormat.format(date);
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    cookie.setMaxAge(60*60*24*30);
                    cookie.setValue(str_date);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies == null){
            System.out.println("first");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = simpleDateFormat.format(date);
            str_date = URLEncoder.encode(str_date, "utf-8");
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60*60*24*30);
            cookie.setValue(str_date);
            response.addCookie(cookie);
            out.write("<h1>首次访问,现在是 </h1>" + URLDecoder.decode(str_date, "utf-8"));
        }
    %>


</body>
</html>
