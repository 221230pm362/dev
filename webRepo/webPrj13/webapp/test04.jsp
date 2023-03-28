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
		String x = request.getParameter("limit");
		int r = (int)(Math.random() * 6 + 1);
	%>

	<h1><%= r %></h1>
	
</body>
</html>




