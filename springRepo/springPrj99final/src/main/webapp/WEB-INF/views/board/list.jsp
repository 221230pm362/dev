<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FINAL</title>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>게시글 목록</h1>
			
			<form action="${root}/board/list" method="get">
				<select name="searchType">
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="search" name="searchValue" placeholder="검색할값">
				<input type="submit" value="검색">
			</form>
			
			
			<hr>
			
			<c:forEach items="${voList}" var="vo">
				<h3>${vo.no} / ${vo.title} / ${vo.content}</h3>
			</c:forEach>
			
		</main>
		
	</div>
	
	<script>
		const searchValueTag = document.querySelector("input[name=searchValue]");
		searchValueTag.value = '${paramMap.searchValue}';
		
		const searchTypeTagArr = document.querySelectorAll("select[name=searchType] > option");

		const x = '${paramMap.searchType}';
		
		if(x == 'title'){
			searchTypeTagArr[0].selected = true;
		}else if(x == 'content'){
			searchTypeTagArr[1].selected = true;
		}
		
		
		
		
		
		
		
	</script>

</body>
</html>










