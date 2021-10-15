<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 18-8-24
  Time: 下午5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellspacing="20">
    <tr>
        <td>
            <a href="LookMessageServlet">查看个人信息</a>
        </td>
        <td>
            <a href="ModifyMessageServlet">修改个人信息</a>
        </td>
        <td>
            <a>修改密码</a>
        </td>
    </tr>
</table>
<hr>
<jsp:useBean id="user" class="com.wei.pims.bean.User" scope="request"/>
<form action="UpdatePasswordMessageServlet" method="post">
    <table border="1" bgcolor="#7fffd4" align="center">
        <tr>
            <td>用户密码</td>
            <td>
                <input type="text" value=" <jsp:getProperty name="user" property="password"/>" name="password">
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
