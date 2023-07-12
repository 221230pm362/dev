<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:set var="root" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/resources/css/header.css">
</head>
<body>
	<header>
        <div>빈칸</div>
        <div>로고</div>
        <form action="${root}/member/login" method="post">
            <div class="login-area">
            	<c:if test="${empty loginMember}">
            		<div>
	                    <input type="text" name="id" placeholder="아이디">
	                </div>
	                <div>
	                    <input type="password" name="pwd" placeholder="비밀번호">
	                </div>
	                <div>
	                    <input type="submit" value="로그인">
	                </div>
	                <div>
	                    <input type="button" value="회원가입" 
	                    onclick="location.href='${root}/member/join'">
	                </div>
            	</c:if>
            	<c:if test="${not empty loginMember}">
            		${loginMember.nick} 님 
            		<br>
            		환영합니다 ~ ^^
            	</c:if>
            </div>
        </form>
    </header>

</body>
</html>