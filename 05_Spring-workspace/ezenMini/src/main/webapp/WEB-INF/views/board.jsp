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
<script src="/js/jquery.twbsPagination.js"></script>
<title>Board</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#main {
	height: auto;
}

thead tr {
	background-color: #A2A9B2;
}

#write {
	height: 40%;
}
</style>

</head>

<body>
<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<div id="main" class="container mt-5">
	<h3 class="display-4 font-italic">Board</h3>

	<hr />

	<a href="write_view" id="write" class="btn btn-sm btn-dark float-right mb-3">글작성</a>	
	<table id="searchTable" class="table table-hover text-center">
		<thead>
			<tr class="row mx-0 text-white">
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
</div>

<div class="container" id="boardOnly">
	<nav aria-label="page navigation">
		<ul class="pagination justify-content-center" id="pagination" style="margin: 20px 0;">
		
		</ul>
		
	</nav>

</div>

<%@ include file="footer.jsp" %>

<script>
$(document).ready(function() {
	$('#searchForm').css("visibility", "visible");
	
	$('#write').click(function(e) {
		$('#searchForm').css("visibility", "hidden");
		// a tag의 페이지 이동 기능을 막음, ajax로 현재페이지에 입력 form 페이지를 띄우기 위함
		e.preventDefault();
		
		$.ajax({
			url : "write_view",
			type : "get",
			success : function(data) {
				$('#main').html(data);
				$('#boardOnly').css('display','none');
			},
			error : function(data) {
				console.log(data);
			}
		});
	});
});

</script>

</body>
</html>