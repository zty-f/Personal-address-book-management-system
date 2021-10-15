<%@ page import="com.wei.pims.bean.Friend" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Friend> friends = (List<Friend>) request.getAttribute("friends");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table >
    <tr>
        <td>
            <a href="AddFriend">添加朋友</a>
            <a>查看朋友</a>
            <a href="ModifyFriend">修改朋友</a>
            <a href="RemoveFriend">删除朋友</a>
        </td>
    </tr>
</table>
<hr>
<table border="1" bgcolor="#7fffd4" align="center">
    <tr>
        <td>用户姓名</td>
        <td>用户电话</td>
        <td>邮件地址</td>
        <td>工作地址</td>
        <td>家庭地址</td>
        <td>qq</td>
    </tr>
    <%
        for (int i = 0; i < friends.size(); i++) {
    %>
    <tr>
        <td><%=friends.get(i).getName()%>
        </td>
        <td><%=friends.get(i).getPhone()%>
        </td>
        <td><%=friends.get(i).getEmail()%>
        </td>
        <td><%=friends.get(i).getWorkplace()%>
        </td>
        <td><%=friends.get(i).getPlace()%>
        </td>
        <td><%=friends.get(i).getQq()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
