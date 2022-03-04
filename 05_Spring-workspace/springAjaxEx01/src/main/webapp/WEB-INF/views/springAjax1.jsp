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
<title>Spring + Ajax</title>
</head>

<body>

<button id="btn1">json 객체 값을 만들어서 서버로 보내기</button>
<div id="result">서버로 온 결과 출력</div>
<hr />

<h4>form에서 서버로 submit하기 위한 form</h4>
<form action="formAct" id="frm1" name="frm1" method="post">
	name : <input type="text" name="name" />
	age : <input type="text" name="age" />
	<input type="submit" value="call" />
</form>


<script>
$(document).ready(function() {
	$('#btn1').click(function() {
		let form = { name : "jamong", age : 23 };
				
		$.ajax({
			url : "requestObject" ,
			type : "post" ,
			data : form ,
			success : function(data) {
				$("#result").text(data);
			} ,
			
			error : function(data) {
				alert("request object ajax method throw error.");
			}		
		});
	})
	
	$("#frm1").submit(function(e) {
		// form에서 서버로 submit되는 것을 차단하고 script에서 parameter를 가져옴
		e.preventDefault();
		
		$.ajax({
			url : $("#frm1").attr("action") ,
			type : $("#frm1").attr("method") ,
			data : $("#frm1").serialize(), // form의 입력값을 직렬화한 문자열로 변환		
			success : function(data) {
				$("#result").text(data);
			},
			
			error : function(data) {
				alert("formAct ajax method throw error.");
			}
		})
	})
})
</script>

</body>
</html>