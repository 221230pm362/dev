<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    main table {
        width: 600px;
        margin: auto;
        font-size: 24px;
        text-align: center;
    }

    main table th , 
    main table td {
        border: 1px solid black;
    }

</style>
</head>
<body>

	<div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

        <main>

            <h1 align="center">자유게시판 게시글 조회</h1>

            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>카테고리</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${voList}" var="vo"> 
	                    <tr>
	                        <td>${vo.no}</td>
	                        <td>${vo.title}</td>
	                        <td>${vo.writerName}</td>
	                        <td>${vo.categoryName}</td>
	                        <td>${vo.hit}</td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>

        </main>

    </div>

</body>
</html>