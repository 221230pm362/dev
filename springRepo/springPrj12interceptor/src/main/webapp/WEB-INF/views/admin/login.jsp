<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>관리자 로그인</h1>
	
	<form action="/app/admin/login" method="POST">
		아이디 : <input type="text" name="id">
		<br>
		비번 : <input type="password" name="pwd">
		<br>
		<input type="submit" value="로그인">
	</form>

</body>
</html>