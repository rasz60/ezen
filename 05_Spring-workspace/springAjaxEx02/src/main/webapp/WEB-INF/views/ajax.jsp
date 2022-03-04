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
<title>Insert title here</title>
</head>

<body>
<h3>ajax.jsp</h3>
<hr />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a href="#" class="navbar-brand">Logo</a>
	
	<ul class="navbar-nav">
		<li class="nav-item">
			<a id="a1" href="#" class="nav-link">Link1</a>
		</li>
		
		<li class="nav-item">
			<a id="a2" href="#" class="nav-link">Link2</a>
		</li>
		
		<li class="nav-item dropdown">
			<a href="#" class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">
				Dropdonw link
			</a>
			<div class="dropdown-menu">
				<a href="#" class="dropdown-item">dropLink 1</a>
				<a href="#" class="dropdown-item">dropLink 2</a>
				<a href="#" class="dropdown-item">dropLink 3</a>
			</div>
		</li>
	</ul>
</nav>
<br /><br />
<hr />

<div id="content">서버에서 온 내용 표시할 위치</div>


<script>
$(document).ready(function() {
	$("#a1").click(function(e) {
		e.preventDefault();
		
		$.ajax({
			url : "data" ,
			type : "POST" ,
			data : "" , 
			dataType : "html" ,
			success : function(data) {
				$("#content").html(data);
			},
			error : function() {
				alert("error");
			},
			complete : function() {
				console.log("always");
			}
		})
	})
	
});
</script>
</body>
</html>