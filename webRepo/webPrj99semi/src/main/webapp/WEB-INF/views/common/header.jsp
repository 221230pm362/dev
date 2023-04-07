<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common/header.css">

<c:if test="${ not empty alertMsg }">
	<script>
	    alert('${alertMsg}');
	</script>
</c:if>
<c:remove var="alertMsg" scope="session"/>

<header>
    <div></div>
    <div id="logo-area">
        <img width="100%" height="150px" src="${pageContext.request.contextPath}/static/img/logo.jpg" alt="로고이미지">
    </div>
    <div id="member-area">
    	<form action="${pageContext.request.contextPath}/member/login" method="POST">
         <input type="text" name="memberId" placeholder="아이디">
         <input type="password" name="memberPwd" placeholder="비밀번호">
         <input type="submit" id="login-btn" value="로그인">
    	</form>
        <button id="join-btn" onclick="location.href='${pageContext.request.contextPath}/member/join'">회원가입</button>
    </div>
</header>

<nav>
    <a href="${pageContext.request.contextPath}/notice/list">공지사항</a>
    <a href="${pageContext.request.contextPath}/board/list">자유게시판</a>
    <a href="${pageContext.request.contextPath}/gallery/list">갤러리</a>
    <a href="${pageContext.request.contextPath}/member/edit">마이페이지</a>
</nav>


