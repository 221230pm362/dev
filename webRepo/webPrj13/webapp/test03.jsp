<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String x = request.getParameter("first");
		String y = request.getParameter("last");
	%>

	<h1><%= x %> <%= y %>님 반가워요</h1>
	
</body>
</html>




