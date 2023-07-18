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
        	<h1>홈페이지</h1>
        	
        	<hr />
        	
        	<h3>날씨정보</h3>
        	
        	<table border="1">
        		<thead>
        			<tr>
        				<th>날짜</th>
        				<th>시간</th>
        				<th>카테고리</th>
        				<th>지역</th>
        				<th>값</th>
        			</tr>
        		</thead>
        		<tbody>
        			<c:forEach items="${data}" var="x">
	        			<tr>
	        				<td>${x.baseDate}</td>
	        				<td>${x.baseTime}</td>
	        				<td>${x.category}</td>
	        				<td>${x.nx} . ${x.ny}</td>
	        				<td>${x.obsrValue}</td>
	        			</tr>
        			</c:forEach>
        		</tbody>
        	</table>
        	
        	
        </main>
        
    </div>


</body>
</html>








