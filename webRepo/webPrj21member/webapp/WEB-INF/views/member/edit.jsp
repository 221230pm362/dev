<%@page import="com.kh.app.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 정보 수정</h1>
	
	<%
		MemberVo mvo = (MemberVo)request.getAttribute("loginMember");
	%>
	

	<form action="/app21/member/edit" method="post">
	
		아이디 <input type="text" name="memberId" value="<%= mvo.getMemberId() %>" readonly>
		<br>
		패스워드 <input type="password" name="memberPwd">
		<br>
		닉네임 <input type="text" name="memberNick" value="<%= mvo.getMemberNick() %>">
		<br>
		<input type="submit" value="수정하기">
	
	</form>	

</body>
</html>








