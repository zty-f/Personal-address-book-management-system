<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<frameset rows="*" cols="400,*">
    <frame src="left.jsp" name="left" scrolling="no" noresize="yes">
    <frameset rows="140,*" cols="*">
        <frame src="top.jsp" name="top" scrolling="no" noresize="yes">
        <frame src="bottom.jsp" name="main" noresize="yes">
    </frameset>
</frameset>
</html>
