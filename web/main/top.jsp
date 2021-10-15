<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = (String) session.getAttribute("userName");
%>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="aqua">
<h2 color="red">个人信息管理平台</h2>
<h3 align="left">欢迎您!<%=userName%>
</h3>
<table>
    <tr>
        <td>
            <a href="http://localhost:8080/LookMessageServlet" target="main">用户个人信息管理</a>
        </td>
        <td>
            <a href="http://localhost:8080/AddFriend" target="main">个人通讯录管理</a>
        </td>
    </tr>
</table>
</body>
</html>
