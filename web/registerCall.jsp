<%@ page import="java.util.*" %>
<%@ page pageEncoding="utf-8" %>

<html>
    <body>
        <h1 align="center">注册成功！</h1>
        <p align="center">
        <%
            String call=(String)request.getAttribute("call");
            Date date=new Date();
            out.println(date+" Hello "+call+"\n");
        %>
        </p>
    </body>
</html>
