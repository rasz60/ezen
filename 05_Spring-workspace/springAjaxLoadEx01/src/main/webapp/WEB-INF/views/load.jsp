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
<title>LOAD PAGE</title>
</head>

<body>

<div id="div1">
	<h2>Let jQeury AJAX change this text.</h2>
</div>
<hr />
<button id="btn1">Get External Content</button>
<button id="btn2">Get External Content(id로 지정)</button>
<button id="btn3">Callback 처리</button>

<script>
$(document).ready(function() {
	$('#btn1').click(function() {
		// 지정한 엘리먼트에 내용을 해당 경로의 파일 내용으로 바꾸는 메서드
		$('#div1').load("txt/demo_test.txt");
	})
	
	$('#btn2').click(function() {
		$('#div1').load("txt/demo_test.txt #p1");
	})
	
	$('#btn3').click(function() {
		$('#div1').load("txt/demo_text.txt", function(responseTxt, statusTxt, xhr) {
			if (statusTxt == 'success') {
				alert("External content load success.");
			} else {
				alert("error : " + statusTxt +" - " + xhr);
			}
		}) 
	})
});
</script>
</body>
</html>