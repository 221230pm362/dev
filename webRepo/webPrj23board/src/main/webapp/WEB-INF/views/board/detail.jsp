<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    #wrap{
        border: 1px solid black;
        box-sizing: border-box;
        width: 400px;
        height: 500px;
        display: grid;
        grid-template-columns: 1fr 3fr;
        grid-template-rows: 1fr 5fr 1fr;
    }

    #wrap > div {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    textarea[name='content'] {
        width: 250px;
        height: 300px;
        resize: none;
    }

    input[name='title'] {
        width: 250px;
    }

    #wrap > div:last-child {
        grid-column: span 2;
    }

</style>
</head>
<body>

	<%--
		BoardVo vo = (BoardVo)request.getAttribute("boardVo");
	--%>

    <h1>게시글 상세 조회</h1>

        <div id="wrap">

            <div>제목</div>
            <div><input type="text" name="title" value="${10 le 10}"></div>
            
            <div>내용</div>
            <div><textarea name="content">${boardVo.content}</textarea></div>
    
    		<div></div>
    
        </div>

</body>
</html>