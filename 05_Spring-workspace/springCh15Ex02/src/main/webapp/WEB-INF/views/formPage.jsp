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
<title>Form</title>
</head>

<body>

<div class="container bg-light p-2 border">
	<h3>입력 폼 페이지</h3>
	<hr />
	<form action="create" method="post">
		<h4></h4>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text" style="width:80px">Name</span>
			</div>
			<input type="text" name="name" class="form-control" />
		</div>
		<br/>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text" style="width:80px">ID</span>
			</div>
			<input type="text" name="id" class="form-control" />
		</div>
		<hr />
		<div class="d-flex justify-content-center mb-2">
			<input type="submit" value="완료" class="btn btn-sm btn-primary mr-2" style="width:120px"/>
			<input type="reset" value="다시입력" class="btn btn-sm btn-danger mr-2" style="width:120px"/>
			<a href="/ch15ex02"><input type="button" class="btn btn-sm btn-secondary mr-2" value="MainPage로" style="width:120px" /></a>
		</div>
	</form>
</div>
</body>
</html>