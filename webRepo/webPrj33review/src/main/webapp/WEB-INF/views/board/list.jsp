<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 목록</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${data}" var="vo">
				<tr>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>






















