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
<title>jsonAjax</title>
</head>

<body>

<h3>Json으로 ajax 주고 받기</h3>
<hr />

<button id="btn1">Stringify</button>

<div id="result"></div>

<script>
$(document).ready(function() {
	$("#btn1").click(function(e) {
		let form = {
				name : "jamong",
				age : 23
		};
		
		$.ajax({
			url : "stringify" ,
			type : "POST" ,
			data : JSON.stringify(form) ,
			// 보내는 데이터의 타입 설정
			contentType : "application/json; charset=UTF-8",
			// 반환되는 데이터의 타입 설정(생략가능)
			dataType : "json" ,
			success : function(data) {
				$("#result").text(JSON.stringify(data));
			},
			
			error : function() {
				alert("ajax post 실패.")
			}
		})
	})
})
</script>
</body>
</html>