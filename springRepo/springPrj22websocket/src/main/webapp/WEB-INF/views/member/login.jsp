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
	
	<h3>로그인 하고나면 채팅페이지로 넘어감</h3>
	
	<form action="/warPrj/member/login" method="post">
		<input type="text" name="nick">
		<br />
		<input type="submit" value="로그인">
	</form>

</body>
</html>