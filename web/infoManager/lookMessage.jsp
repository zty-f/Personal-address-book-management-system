<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<table cellspacing="20">
    <tr>
        <td>
            <a>查看个人信息</a>
        </td>
        <td>
            <a href="ModifyMessageServlet">修改个人信息</a>
        </td>
        <td>
            <a href="ModifyPasswordServlet">修改密码</a>
        </td>
    </tr>
</table>
<hr>
<jsp:useBean id="user" scope="request" class="com.wei.pims.bean.User"/>
<table border="1" bgcolor="#7fffd4" align="center">
    <tr>
        <td>用户姓名</td>
        <td>
            <jsp:getProperty name="user" property="name"/>
        </td>
    </tr>
    <tr>
        <td>用户性别</td>
        <td>
            <jsp:getProperty name="user" property="sex"/>
        </td>
    </tr>
    </tr>
    <tr>
        <td>出生日期</td>
        <td>
            <jsp:getProperty name="user" property="birth"/>
        </td>
    </tr>
    <tr>
        <td>用户民族</td>
        <td>
            <jsp:getProperty name="user" property="nation"/>
        </td>
    </tr>
    <tr>
        <td>用户学历</td>
        <td>
            <jsp:getProperty name="user" property="edu"/>
        </td>
    </tr>
    <tr>
        <td>用户职称</td>
        <td>
            <jsp:getProperty name="user" property="work"/>
        </td>
    </tr>
    <tr>
        <td>用户电话</td>
        <td>
            <jsp:getProperty name="user" property="phone"/>
        </td>
    </tr>
    <tr>
        <td>家庭住址</td>
        <td>
            <jsp:getProperty name="user" property="place"/>
        </td>
    </tr>
    <tr>
        <td>邮件地址</td>
        <td>
            <jsp:getProperty name="user" property="email"/>
        </td>
    </tr>
</table>
</body>
</html>
