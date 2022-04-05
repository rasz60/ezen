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
<meta id="_csrf" name="_csrf" content="${_csrf.token }">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/b4e02812b5.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>

<body>

<div class="container mt-5">
	<h3 class="text-center">서버 센트 이벤트</h3>
	<button type="button" id="sebtn" class="btn btn-primary">싱글버튼</button>
	<button type="button" id="mebtn" class="btn btn-success">멀티버튼</button>
	<br /><br />
	<div id="sseDisp1"></div>
	<div id="sseDisp2"></div>
	<div id="sseDisp3"></div>
</div>

<script>
$(document).ready(function() {
	$('#sebtn').click(function() {
		let eventSource = new EventSource('seventEx');
		eventSource.onmessage = function(e) {
			$('#sseDisp1').text(e.data);
		}
	});
	
	
	$('#mebtn').click(function() {
		let eventSource = new EventSource("meventEx");

		// addEventListener : (이벤트, 처리함수, false는 버블링/true 캡처 방식)
		eventSource.addEventListener("up_vote", function(e) {
			$('#sseDisp2').text(e.data);
		}, false);

		
		eventSource.addEventListener("down_vote", function(e) {
			$('#sseDisp3').text(e.data);
		}, false);
		
		
	});

	
	
});

</script>

</body>
</html>