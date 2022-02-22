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
	<title>Home</title>
</head>
<body>
<div class="container bg-light p-2 border">
	<h1>Use Parameters Part-2</h1>
	<hr />
	<h3>@ModelAttribute</h3>
	<br />
	1. Use Object Parameter 
	<a href="studentView1?name=kim&age=23&gradeNum=2&classNum=3">
		<button type="button" class="btn btn-secondary btn-sm">Student Info1 Page</button>
	</a>
	<br/><br/>
	2. Set Object Parameter Attribute Name 
	<a href="studentView2?name=keem&age=32&gradeNum=3&classNum=2">
		<button type="button" class="btn btn-secondary btn-sm">Student Info2 Page</button>
	</a>
	<br/>
	<hr />
	
	<h3>Redirect</h3>
	<br />
	3. Redirect Confirm page > 'id' not equals 'abc'
	<a href="studentConfirm?id=abcd)">
		<button type="button" class="btn btn-warning btn-sm text-white">Student Confirm(N) Page</button>
	</a>
	<br/><br/>
	4. Redirect Confirm page > 'id' equals 'abc'
	<a href="studentConfirm?id=abc">
		<button type="button" class="btn btn-warning btn-sm text-white">Student Confirm(Y) Page</button>
	</a>
	<br/><br/>
	5. Redirect Another Root Path Page
	<a href="studentURL1">
		<button type="button" class="btn btn-warning btn-sm text-white">Student Confirm(Y) Page</button>
	</a>
	<br />
	<hr />
	
</div>
</body>
</html>
