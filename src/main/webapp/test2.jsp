<%@page import="com.ganhuo.app.common.utils.HttpUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body>
	<form action="/test4" method="post">
		name:<input name="name" type="text"/>
		<input type="text" name="request_token" value="<%=HttpUtil.getToken(session)%>" />
		<input type="submit" value="提交"/>
	</form>
</body>
</html>