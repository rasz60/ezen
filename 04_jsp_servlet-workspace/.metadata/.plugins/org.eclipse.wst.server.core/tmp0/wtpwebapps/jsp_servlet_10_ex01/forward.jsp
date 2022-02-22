<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>파라메터값 forward</title>
</head>

<body>

<h3>파라메터값을 전달해주는 forward 액션태그</h3>
<!-- jsp:param : forward로 이동할 때, 이동할 페이지에 전달할 값을 정의할 때 사용 (속성에 지정한 name/value 한 쌍) -->
<jsp:forward page="forward_params.jsp">	
	<jsp:param name="id" value="abcdef"></jsp:param>
	<jsp:param name="pwd" value="1234"></jsp:param>
</jsp:forward>
</body>
</html>