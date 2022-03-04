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
<title>Ajax Upload</title>
</head>

<body>

<h3>Ajax upload</h3>
<hr />
<form action="file" method="POST" id="frm" enctype="multipart/form-data">
	<input type="file" multiple="multiple" id="images" name="images" />
</form>

<button id="btn1">file</button>
<div id="result"></div>

<script>
$(document).ready(function() {
	$('#btn1').click(function() {
		//form에서 입력한 데이터를 ajax로 전송 가능한 형태의 객체로 생성해주는 클래스 (주로 image)
		let form = new FormData($('#frm')[0]);
		
		$.ajax({
			url : "file" ,
			type : "POST" ,
			data : form,
			// contentType, processData는 upload시에 꼭 필요한 속성 값으로 false로 지정해준다.
			contentType : false,
			processData : false,
			success : function(data) {
				for ( var i = 0; i < data.length; i++ ) {
					$('#result').append(data[i] + '<br />');
				}
			} ,
			
			error : function() {
				alert("error")
			}
		})
	})
})
</script>
</body>
</html>