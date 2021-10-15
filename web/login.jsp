<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        function singUp() {
            window.location = "SignUp";
        }
    </script>
</head>
<body bgcolor="#f0f8ff">
<form action="LoginServlet" method="post">
    <table border="1" bgcolor="#adff2f" align="center">
        <tr>
            <td>username</td>
            <td colspan="2"><input type="text" name="username" placeholder="enter username"></td>
        </tr>
        <tr>
            <td>password</td>
            <td colspan="2"><input type="text" name="password" placeholder="enter password"></td>
        </tr>
        <tr>
            <td><input type="button" value="sign up" onclick="singUp();"></td>
            <td align="center"><input type="submit" value="sign in"></td>
            <td align="center"><input type="reset" value="reset"></td>
        </tr>
    </table>

</form>
</body>
</html>
