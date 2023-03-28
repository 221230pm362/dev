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
		String x = request.getParameter("nick");
		System.out.println(x);
	%>

	<h1>hello</h1>
	
	<h3><% out.write(x); %> 님 환영합니다 ~ ^^</h3>

</body>
</html>




