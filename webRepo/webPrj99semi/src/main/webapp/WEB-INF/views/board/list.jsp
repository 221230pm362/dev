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

            <h1 align="center">자유게시판 목록 조회</h1>

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
            
            <div id="page-area">
            	<c:if test="${pv.currentPage > 1}">
	            	<a class="btn btn-primary btn-sm" href="${root}/board/list?page=${pv.currentPage - 1}">이전</a>
            	</c:if>
	            	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" step="1" var="i">
	            		<c:if test="${pv.currentPage != i}">
			            	<a class="btn btn-primary btn-sm" href="${root}/board/list?page=${i}">${i}</a>
	            		</c:if>
	            		<c:if test="${pv.currentPage == i}">
			            	<a class="btn btn-primary btn-sm">${i}</a>
	            		</c:if>
	            	</c:forEach>
	            <c:if test="${pv.currentPage < pv.maxPage}">
	            	<a class="btn btn-primary btn-sm" href="${root}/board/list?page=${pv.currentPage + 1}">다음</a>
	            </c:if>
            </div>

        </main>

    </div>

</body>
</html>











