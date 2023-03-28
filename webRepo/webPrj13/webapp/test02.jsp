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
		String x = request.getParameter("a");
		String y = request.getParameter("b");
		
		int c = Integer.parseInt(x) + Integer.parseInt(y);
	%>

	<h1><%= x %> 와 <%= y %> 의 합은 <%= c %> 입니다.</h1>
	
</body>
</html>




