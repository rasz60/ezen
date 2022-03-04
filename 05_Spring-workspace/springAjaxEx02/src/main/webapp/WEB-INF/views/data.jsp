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
<title>ajax가 받은 jsp 처리</title>
</head>

<body>

<h3>data.jsp입니다.</h3>
<hr />

<div id="tours">
	<h1>Guided Tours</h1>
	<hr />
	<ul>
		<li class="usa tour">
			<h2>New York, USA</h2>
			<span class="details">$1,899 for 7 nights</span>
			<button class="book">Book Now</button>
		</li>
		
		<li class="europe tour">
			<h2>Paris, France</h2>
			<span class="details">$1,899 for 7 nights</span>
			<button class="book">Book Now</button>
		</li>
		
		<li class="asia tour">
			<h2>Seoul, Korea</h2>
			<span class="details">$1,899 for 7 nights</span>
			<button class="book">Book Now</button>
		</li>
	</ul>
</div>
</body>
</html>