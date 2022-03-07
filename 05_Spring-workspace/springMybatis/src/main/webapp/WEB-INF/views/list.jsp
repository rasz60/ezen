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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	  integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	  crossorigin="anonymous"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>List.jsp</title>
</head>

<body>

<div class="container mt-3">
	<div class="d-flex justify-content-between">
		<h3>List</h3>
		<a href="/mybatis01"><button type="button" class="btn btn-sm btn-primary">글 작성</button></a>
	</div>
	<hr />
	<div class="d-flex row bg-light text-center font-weight-bold my-2 justify-content-around">
		<div class="border rounded col-1 p-2 mx-1 shadow-sm">번호</div>
		<div class="border rounded col-2 p-2 mx-1 shadow-sm">작성자</div>
		<div class="border rounded col-6 p-2 mx-1 shadow-sm">내용</div>
		<div class="border rounded col-1 p-2 mx-1 shadow-sm">수정</div>	
		<div class="border rounded col-1 p-2 mx-1 shadow-sm">삭제</div>	
	</div>
	
	<c:forEach items="${list}" var="content">
	<div class="d-flex row text-center my-2 justify-content-around ">
		<div class="border rounded col-1 p-2 mx-1 shadow-sm"><a href="view?mId=${content.mId }" class="text-primary">${content.mId }</a></div>
		<div class="border rounded col-2 p-2 mx-1 shadow-sm">${content.mWriter }</div>
		<div class="border rounded col-6 p-2 mx-1 shadow-sm">${content.mContent }</div>
		<div class="border rounded col-1 p-2 mx-1 shadow-sm"><a href="modify?mId=${content.mId }" class="text-success">o</a></div>
		<div class="border rounded col-1 p-2 mx-1 shadow-sm"><a href="delete?mId=${content.mId }" class="text-danger">&times;</a></div>
	</div>
	</c:forEach>
</div>

</body>
</html>