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
<title>Buy Ticket</title>
</head>

<body>

<div class="container bg-light border p-3">
	<h3>buyTicket 카드 결제</h3>
	<hr />
	<form action="buyTicketCard" method="post" id="frm">
		<div class="form-group">
		<label for="id">고객 아이디 : </label> 
		<input type="text" name="consumerId" id="id" class="form-control" />
		</div>
		<div class="form-group">
		<label for="amount">티켓 수량 : </label> 
		<input type="text" name="amount" id="amount" class="form-control"/>
		</div>
		<input type="submit" value="구  매" class="btn btn-sm btn-primary"/>
		<input type="reset" value="초기화" class="btn btn-sm btn-danger"/>
	</form>
</div>

<script>
$(document).ready(function() {
	$(".btn-primary").click(function(e) {
		e.preventDefault();
		
		let amount = $("#amount").val();
		
		if ( amount > 2 ) {
			alert("2장 이상 구매할 수 없습니다.");
			$("#amount").focus();
			return;
		} else if ( isNaN(amount) ) {
			alert("수량을 숫자로 입력해주세요.");
			$("#amount").focus();
			return;
		}
			
		if (confirm("티켓을 구매하시겠습니까?")) {
			$("#frm").submit();
		} else {
			return;
		}

	});
});
</script>

</body>
</html>