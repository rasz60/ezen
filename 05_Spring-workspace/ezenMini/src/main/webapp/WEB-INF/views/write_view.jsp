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
<title>Write View</title>
<style>
#content {
	resize: none;
}

</style>

</head>

<body>

<div class="container">
	<h3 class="display-4 font-italic">Board Write</h3>
	<hr />
	
	<form action="write" method="post" class="mb-4">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<div class="form-group">
			<label for="uname">User ID</label>
			<input type="text" class="form-control" id="uname" name="bName" required value="${bName}" readonly/>
		</div>
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" id="title" name="bTitle" placeholder="Enter Title" required/>
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			<textarea class="form-control" id="content" name="bContent" rows="10" placeholder="Enter Content" required></textarea>
		</div>
		<a href="board" id="goback" class="btn btn-sm btn-secondary float-right">목록</a>	
		<input type="submit" id="complete" class="btn btn-sm btn-primary float-right mr-2" value="작성"/>
	</form>
</div>


</body>
</html>