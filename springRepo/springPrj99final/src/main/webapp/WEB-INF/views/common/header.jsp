<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:set var="root" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FINAL</title>
<link rel="stylesheet" href="${root}/resources/css/header.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
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
    <nav>
    	<a href="${root}/board/list?p=1">자유게시판</a>
    	<a>메뉴01</a>
    	<a>메뉴02</a>
    	<a>메뉴03</a>
    </nav>

</body>
</html>










