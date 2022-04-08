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
<title>Insert title here</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#main {
	height: auto;
}

.tabs {
	width: 100%;
	text-align: center;
}

.tabs a {
	width: 24%;
}

</style>
</head>

<body>
<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<div class="container mt-5 mb-5">
	<div class="tabs">
		<a href="sse" id="sse" class="btn btn-outline-primary">서버이벤트</a>
		<a href="wstorage" id="wstorage" class="btn btn-outline-danger">웹 스토리지</a>
		<a href="wworker" id="wworker" class="btn btn-outline-info">워커 태스크</a>
		<a href="fconvert" id="fconvert" class="btn btn-outline-success">파일 컨버터</a>
	</div>
	<hr />
</div>

<div id="main" class="container mb-5">
</div>


<%@ include file="footer.jsp" %>
<script>
$('#sse').click(function(e) {
	e.preventDefault();
	
	$.ajax({
		url: 'sse',
		type: 'get',
		success: function(data) {
			$('#main').html(data);
		},
		error: function() {
			alert('서버이벤트 에러 발생');
		}
	})
});


$('#wstorage').click(function(e) {
	e.preventDefault();
	
	$.ajax({
		url: 'wstorage',
		type: 'get',
		success: function(data) {
			$('#main').html(data);
		},
		error: function() {
			alert('스토리지 에러 발생');
		}
	})
});

$('#wworker').click(function(e) {
	e.preventDefault();
	
	$.ajax({
		url: 'wworker',
		type: 'get',
		success: function(data) {
			$('#main').html(data);
		},
		error: function() {
			alert('워커 태스크 에러 발생');
		}
	})
});

$('#fconvert').click(function(e) {
	e.preventDefault();
	
	$.ajax({
		url: 'fconvert',
		type: 'get',
		success: function(data) {
			$('#main').html(data);
		},
		error: function() {
			alert('파일 변환 에러 발생');
		}
	})
});


</script>


</body>
</html>