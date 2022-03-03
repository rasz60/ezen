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

</head>

<body>

<div class="container-fluid p-2 border">
	<h4 class="text-danger text-center mt-2">게시판</h4>

	
	<table class="table table-hover mt-2 table-bordered" id="boardTable">
		<tr class="bg-dark text-white">
			<th class="col-1">번호</th>
			<th class="col-2">작성자</th>
			<th class="col-5">제목</th>
			<th class="col-3">날짜</a></th>
			<th class="col-1">히트수</a></th>
		</tr>
		
		<c:forEach var="post" items="${boardList}">
			<tr class="my-auto">
				<td class="col-1">${post.bId }</td>
				<td class="col-2">${post.bName }</td>
				<td class="col-5">
					<a href="#" class="text-dark">${post.bTitle }</a>
					<small class="text-warning">[${post.bIndent}]</small>
					<i></i>
				</td>
				<td class="col-3">
					<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${post.bDate }"/>
				</td>
				<td class="col-1">${post.bHit }</td>
			</tr>
		</c:forEach>
		<tr style="background-color:lightgrey">
			<td colspan="12">
				<button class="btn btn-primary btn-sm"> 글작성</button>
			</td>
		</tr>
	</table>
	
	<div class=" p-2">
	</div>
	
</div>
</body>
</html>