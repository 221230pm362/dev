<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인</h1>
	
	<form action="/app/member/login" method="post">
		<input type="text" name="id" value="${ cookie.rememberId.value }">
		<br />
		<input type="password" name="pwd">
		<br />
		<input type="submit" value="로그인">
	</form>

</body>
</html>










