<%@ page import="com.wei.pims.bean.Friend" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Friend friend = (Friend) request.getAttribute("friend");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>
            <a href="AddFriend">添加朋友</a>
            <a href="LookFriend">查看朋友</a>
            <a>修改朋友</a>
            <a>删除朋友</a>
        </td>
    </tr>
</table>
<form action="UpdateFriendServlet" method="post">
    <input type="hidden" value="<%=friend.getId()%>" name="id">
    <table border="1" bgcolor="#7fffd4" align="center">
        <tr>
            <td>朋友姓名</td>
            <td><input type="text" value="<%=friend.getName()%>" name="name"></td>
        </tr>
        <tr>
            <td>朋友电话</td>
            <td><input type="text" value="<%=friend.getPhone()%>" name="phone"></td>
        </tr>
        <tr>
            <td>邮件地址</td>
            <td><input type="text" value="<%=friend.getEmail()%>" name="email"></td>
        </tr>
        <tr>
            <td>工作地址</td>
            <td><input type="text" value="<%=friend.getWorkplace()%>" name="workplace"></td>
        </tr>
        <tr>
            <td>家庭地址</td>
            <td><input type="text" value="<%=friend.getPlace()%>" name="place"></td>
        </tr>
        <tr>
            <td>朋友QQ</td>
            <td><input type="text" value="<%=friend.getQq()%>" name="qq"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
