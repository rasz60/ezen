<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	  integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	  crossorigin="anonymous"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="script/board.js"></script>
<title>BoardList</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400&display=swap');;
* {
	font-family: 'Noto Sans KR', sans-serif;
}
#boardTable {
	border-bottom: 1px solid #dee2e6;
}
.container-fluid {
	height: 800px;
}
</style>
</head>

<body>

<div class="container-fluid mt-4 p-2 border text-center bg-light">
	<h1 class="p-3">Spring-MVC-BOARD</h1>
	<hr />
	<div class="p-2 d-flex justify-content-between">
		<span class="mt-auto" id="postCount"></span>
		<a href="writeForm"><input type="button" value="게시글 작성" class="btn btn-primary btn-sm" /></a>
	</div>
	
	<table class="table table-hover mt-2" id="boardTable">
		<tr class="bg-secondary text-white">
			<th class="col-1">번호</th>
			<th class="col-4"><a href="#" class="text-white">제목</a></th>
			<th class="col-3"><a href="#" class="text-white">작성일자</a></th>
			<th class="col-1">작성자</th>
			<th class="col-1"><a href="#" class="text-white">조회수</a></th>
			<th class="col-1">수정</th>
			<th class="col-1">삭제</th>
		</tr>
		
		<c:forEach var="post" items="${list}">
			<tr class="my-auto">
				<td class="col-1">${post.bId }</td>
				<td class="col-4">
					<a href="#" class="text-dark">${post.bTitle }</a>
					<small class="text-warning">[${post.bIndent}]</small>
					<i></i>
				</td>
				<td class="col-3"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${post.bDate }" ></fmt:formatDate></td>
				<td class="col-1"><a href="#" class="text-dark">${post.bName }</a></td>
				<td class="col-1">${post.bHit }</td>
				<td class="col-1"><a href="#"><input type="button" value="수정" class="btn btn-outline-success btn-sm" /></a></td>
				<td class="col-1"><a href="#"><input type="button" value="삭제" class="btn btn-outline-danger btn-sm" /></a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>