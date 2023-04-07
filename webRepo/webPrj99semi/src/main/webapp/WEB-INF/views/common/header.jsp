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
        <a href="${pageContext.request.contextPath}/home">
            <img width="100%" height="150px" src="${pageContext.request.contextPath}/static/img/logo.jpg" alt="로고이미지">
        </a>
    </div>
    <div id="member-area">
    	<c:if test="${ empty loginMember }">
	    	<form action="${pageContext.request.contextPath}/member/login" method="POST">
	         <input type="text" name="memberId" placeholder="아이디">
	         <input type="password" name="memberPwd" placeholder="비밀번호">
	         <input type="submit" id="login-btn" value="로그인">
	    	</form>
	        <button id="join-btn" onclick="location.href='${pageContext.request.contextPath}/member/join'">회원가입</button>
    	</c:if>
    	<c:if test="${ not empty loginMember }">
    		${ loginMember.nick } 님 환영합니다.
    		<br>
    		<button onclick="location.href='${pageContext.request.contextPath}/member/logout'">로그아웃</button>
    	</c:if>
    </div>
</header>

<nav>
    <a href="${pageContext.request.contextPath}/notice/list">공지사항</a>
    <a href="${pageContext.request.contextPath}/board/list">자유게시판</a>
    <a href="${pageContext.request.contextPath}/gallery/list">갤러리</a>
    <a href="${pageContext.request.contextPath}/member/edit">마이페이지</a>
</nav>


