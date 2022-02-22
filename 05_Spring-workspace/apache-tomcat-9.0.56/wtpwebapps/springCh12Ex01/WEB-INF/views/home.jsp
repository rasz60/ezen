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
<div class="container border bg-light p-3">
	<h1>Hello world!</h1>
	<hr />
	
	<P class="bg-success text-white m-2 p-2">The time on the server is ${serverTime}.</P>
	<P class="bg-primary text-white m-2 p-2">The time on the server is ${serverTime}.</P>
	<P class="bg-danger text-white m-2 p-2">The time on the server is ${serverTime}.</P>
	<P class="bg-secondary text-white m-2 p-2">The time on the server is ${serverTime}.</P>
	<P class="bg-dark text-white m-2 p-2">The time on the server is ${serverTime}.</P>
	<hr />
	
	<h3>다른 페이지로 이동</h3>
	<a href="board/view"><i class="fa fa-solid fa-list btn btn-sm btn-dark py-2" ></i></a>
	<a href="board/content"><i class="btn btn-sm btn-dark py-2" >Content</i></a>
	<a href="board/reply"><i class="btn btn-sm btn-dark py-2" >Reply</i></a>
</div>
</html>