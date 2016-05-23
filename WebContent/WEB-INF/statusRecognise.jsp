<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<font color="red">${requestScoper.error }</font>
	<form action="StatusRecogniseAction" method="post">
		<p>员工编号：<input type="text" name="id" value="{param.id}" /></p>
		<br/>
		<p>系统口令<input type="password" name="pwd" /></p>
		<p><input type="submit" value="提交" />
			<input type="reset" value="重置" /></p>
	</form>
</body>
</html>