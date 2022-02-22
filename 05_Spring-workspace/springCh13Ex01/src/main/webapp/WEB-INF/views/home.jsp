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
<div class="container bg-light p-2">
	<h1>Use Parameters Part-1</h1>
	<hr />
	<h3>Get Parameters</h3><br />
	1. request.getParameter(name) <a href="confirmId?id=woong&pwd=12345"><button type="button" class="btn btn-dark btn-sm">Confirm ID Page</button></a><br/><br/>
	2. @RequestParam(name) <a href="checkId?id=jinwoong&pwd=67890"><button type="button" class="btn btn-dark btn-sm">Check ID Page</button></a><br/>
	<hr />
	<h3>Object Type Parameter</h3><br />
	3. Set in Method new Object Type <a href="join1?name=kim&id=bdoolgi&pwd=99999&email=ras@ras.com"><button type="button" class="btn btn-success btn-sm">Join1 Info Page</button></a><br/><br/>
	4. Object in Method Parameter Type <a href="join2?name=kim&id=bdoolgi&pwd=99999&email=ras@ras.com"><button type="button" class="btn btn-success btn-sm">Join2 Info Page</button></a><br/>
	<hr />
	<h3>Object Type Parameter</h3><br />
	5. PathVariable <a href="student/30"><button type="button" class="btn btn-primary btn-sm">PathVariable Page</button></a><br/>
</div>
</body>
</html>
