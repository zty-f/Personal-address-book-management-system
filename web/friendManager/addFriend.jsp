<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userName = (String) session.getAttribute("userName");
%>
<table border="0">
    <tr>
        <td>
            <a>添加朋友</a>
            <a href="LookFriend">查看朋友</a>
            <a href="ModifyFriend">修改朋友</a>
            <a href="RemoveFriend">删除朋友</a>
        </td>
    </tr>
</table>
<hr>
<form action="AddFriendServlet" method="post">
    <table bgcolor="#7fffd4" align="center" border="1">
        <tr>
            <td>用户姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>用户电话</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>邮箱地址</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>工作单位</td>
            <td><input type="text" name="workplace"></td>
        </tr>
        <tr>
            <td>家庭住址</td>
            <td><input type="text" name="place"></td>
        </tr>
        <tr>
            <td>用户QQ</td>
            <td><input type="text" name="qq"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
    <input type="hidden" name="userName" value="<%=userName%>">

</form>
</body>
</html>
