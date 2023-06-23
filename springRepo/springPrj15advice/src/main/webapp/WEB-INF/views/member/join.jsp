<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<img src="/app/resources/image/test.png" alt="사이트로고이미지">

	<h1>회원가입</h1>
	
	<form action="/app/member/join" method="POST">
		<input type="text" name="id" placeholder="아이디">
		<br>
		<input type="password" name="pwd" placeholder="비밀번호">
		<br>
		<input type="text" name="nick" placeholder="닉네임">
		<br>
		<input type="submit" value="회원가입">
	</form>

</body>
</html>






















