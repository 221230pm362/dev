<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전체 회원 조회</h1>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>가입일시</th>
			<th>상태</th>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.no}</td>
				<td>${vo.id}</td>
				<td>${vo.enrollDate}</td>
				<td>${vo.status}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>





