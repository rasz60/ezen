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
<title>response 객체 메서드</title>
</head>

<body>

<%!
	int age;
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
%>

<%
	String str = request.getParameter("age");
	boolean check = isInteger(str);

	if ( check ) {
		age = Integer.parseInt(str);
		if ( age > 19 ) {
			response.sendRedirect("pass.jsp?age=" + age);
			//sendRedirect("경로") : 지정한 경로로 이동하게 함
		} else {
			response.sendRedirect("ng.jsp?age=" + age);
		}	
	} else {
%>	
	<script>
		alert("나이(숫자만)를 입력하세요.");
		history.go(-1);
	</script>
<%}%>
	
	
</body>
</html>