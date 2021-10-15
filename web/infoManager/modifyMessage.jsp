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
            <a>修改个人信息</a>
        </td>
        <td>
            <a href="ModifyPasswordServlet">修改密码</a>
        </td>
    </tr>
</table>
<hr>
<jsp:useBean id="user" class="com.wei.pims.bean.User" scope="request"/>
<form action="UpdateMessageServlet" method="post">
    <table border="1" bgcolor="#7fffd4" align="center">
        <tr>
            <td>用户姓名</td>
            <td>
                <input type="text" value="<jsp:getProperty name="user" property="name"/>" name="name">
            </td>
        </tr>
        <tr>
            <td>用户性别</td>
            <td>
               <input type="text" value="<jsp:getProperty name="user" property="sex"/>" name="sex">
            </td>
        </tr>
        </tr>
        <tr>
            <td>出生日期</td>
            <td>
                <input type="text" value="<jsp:getProperty name="user" property="birth"/>" name="birth">
            </td>
        </tr>
        <tr>
            <td>用户民族</td>
            <td>
                <input type="text" value="<jsp:getProperty name="user" property="nation"/>" name="nation">
            </td>
        </tr>
        <tr>
            <td>用户学历</td>
            <td>
                <input type="text" value="<jsp:getProperty name="user" property="edu"/>" name="edu">
            </td>
        </tr>
        <tr>
            <td>用户职称</td>
            <td>
               <input type="text" value="<jsp:getProperty name="user" property="work"/>" name="work">
            </td>
        </tr>
        <tr>
            <td>用户电话</td>
            <td>
               <input type="text" value="<jsp:getProperty name="user" property="phone"/>" name="phone">
            </td>
        </tr>
        <tr>
            <td>家庭住址</td>
            <td>
               <input type="text" value="<jsp:getProperty name="user" property="place"/>" name="place">
            </td>
        </tr>
        <tr>
            <td>邮件地址</td>
            <td>
               <input type="text" value="<jsp:getProperty name="user" property="email"/>" name="email">
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2"> <input type="submit" value="提交"></td>
        </tr>
    </table>

</form>
</body>
</html>
