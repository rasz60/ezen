<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
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
<meta id="_csrf" name="_csrf" content="${_csrf.token }">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/b4e02812b5.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/jquery.twbsPagination.js"></script>
</head>

<body>

<div class="d-flex justify-content-between">
	<h3 class="display-4 font-italic">Board</h3>
	<a href="write_view" id="write" class="btn btn-sm btn-dark float-right mt-4">글작성</a>
</div>
<hr />

<table id="searchTable" class="table table-hover text-center">
<thead>
	<tr class="row mx-0">
		<th class="col-1">번호</th>
		<th class="col-2">작성자</th>
		<th class="col-4">제목</th>
		<th class="col-3">날짜</th>
		<th class="col-2">히트수</th>
	</tr>
</thead>

<tbody>
	<c:forEach items="${listContent}" var="dto">
		<tr class="row mx-0">
			<td id="bid" class="col-1">${dto.bId}</td>
			<td class="col-2">${dto.bName}</td>
			<td class="col-4">
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view?bId=${dto.bId}" class="content_view text-dark">${dto.bTitle}</a>
			</td>
			<td class="col-3">${dto.bDate}</td>
			<td class="col-2">${dto.bHit}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>