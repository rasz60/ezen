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

<h3>jQuery .get과 .post 메서드</h3>
<hr />

<button id="btn1">Send an HTTP GET request</button>
<button id="btn2">Send an HTTP POST request</button>

<script>
$(document).ready(function() {
	$('#btn1').click(function() {
		
		let data = "get Method";
		
			// 'action', callback()
		$.get('ajaxGet', data, function(data, status) {
			// 파라미터 data는 서버에서 전달된 데이터, status는 상세정보
			alert("Data : " + data + "\nStatus : " + status);
		});
	});
	
	$('#btn2').click(function() {
		$.post("ajaxPost", {
			name : 'Donald Duck',
			city : 'Duckburg'
		} ,
		function(data, status) {
			alert("Data : " + data + "\nStatus : " + status );
		});
	});
})
</script>
</body>
</html>