<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>에러페이지</h1>
	
	<%
		String x = (String)request.getAttribute("errorMsg");
	%>
	
	<h3>
		<%= x %>
	</h3>
	
	<a href="/app22">메인으로</a>

</body>
</html>


