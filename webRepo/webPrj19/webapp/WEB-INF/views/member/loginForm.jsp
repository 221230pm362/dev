<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 화면</h1>
	
	<form action="/app19/member/login" method="POST" >
	
		<input type="text" name="memberId" placeholder="아이디를 입력하세요">
		<br>
		<input type="password" name="memberPwd" placeholder="비밀번호를 입력하세요">
		<br>
		<input type="submit" value="로그인">
		
	</form>

</body>
</html>