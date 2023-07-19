<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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

			<input type="text" id="boardLimit" placeholder="조회할 행 수">
			<input type="text" id="currentPage" placeholder="조회할 페이지">
			<input type="text" id="year" placeholder="관측연도">
			<input type="text" id="type" placeholder="구분(PM10,PM25,공백)">
			<h3>미세먼지 정보 확인</h3>
			<button onclick="checkMicroDustInfo();">정보확인!</button>

			<br />
			<br />
			<br />
			<br />
			<br />
        	
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

<script>
	
	// 날씨 정보를 받아오기
	/* $.ajax({
		url : "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=6IPXodaWeJeJISbBFmD1zT3h4u91nQ75HnufakYGnvgsIiwT%2FUgS79FOvKU6KLuimQiq6pSANLNYpo0tFn%2Fl0g%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20230719&base_time=0600&nx=55&ny=127" ,
		method : "GET" ,
		data : {} ,
		dataType : "json" ,
		crossDomain : true, 
		success : function(x){
			alert("good");
			console.log(x);
			
			// 받아온 정보로 table 채우기
			const tbody = document.querySelector("tbody");
			let str = "";
			
			for(let i = 0; i < x.length; i++){
				str +=		  "<tr>"
							+ "<td>" + x[i].baseDate + "</td>"
							+ "<td>" + x[i].baseTime + "</td>"
							+ "<td>" + x[i].category + "</td>"
							+ "<td>" + x[i].nx + "," + x[i].ny + "</td>"
							+ "<td>" + x[i].obsrValue + "</td>"
							+ "</tr>";
			}
			
						
								
			tbody.innerHTML = str;
			
		} ,
		error : function(x){
			alert("bad");
			console.log(x);
		} ,
		
	}); */
	
	
	
	//미세먼지 관련 ====================================
		
	function checkMicroDustInfo(){
		
		//검색값 준비
		const v1 = document.querySelector("#boardLimit").value;
		const v2 = document.querySelector("#currentPage").value;
		const v3 = document.querySelector("#year").value;
		const v4 = document.querySelector("#type").value;
		
		$.ajax({
			url : "/app/api/dust" ,
			type : "get" ,
			data : {
				boardLimit : v1 ,
				currentPage : v2 ,
				year : v3 ,
				type : v4 ,
			} ,
			dataType : "json" ,
			success : function(data){
				alert("미세먼지 조회 성공 !!!");
				console.log(data);
			} ,
			error : function(){
				alert("미세먼지 조회 실패 ...");
			} ,
		});
	}
		
	
</script>








