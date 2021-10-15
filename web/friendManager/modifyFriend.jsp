<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<String> friendNames = (List<String>) request.getAttribute("friendNames");
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
            <a href="LookFriend">查看朋友</a>
            <a href="ModifyFriend">修改朋友</a>
            <a>删除朋友</a>
        </td>
    </tr>
</table>
<hr>
<form action="ModifyFriendServlet" method="post">
    <table border="1" bgcolor="#7fffd4" align="center">
        <tr>
            <td>选择朋友</td>
            <td>
                <select name="name" id="">
                    <%
                        for (int i = 0; i < friendNames.size(); i++) {
                    %>
                    <option value="<%=friendNames.get(i)%>"><%=friendNames.get(i)%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
