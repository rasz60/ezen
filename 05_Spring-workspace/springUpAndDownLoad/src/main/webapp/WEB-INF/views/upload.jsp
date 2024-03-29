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

<h3>Single File Upload</h3>
<hr />

<form action="uploadSingle" method="post" enctype="multipart/form-data" name="fileSingle">
	<input type="file" name="s_file" />
	<input type="text" name="src" placeholder="UPLOADER NAME" />
	<input type="submit" value="single"/>
	<input type="reset" value="reset" /> 
</form>

<h3 class="mt-5">Multi File Upload</h3>
<hr />

<form action="uploadMulti" method="post" enctype="multipart/form-data" name="fileMulti">
	<input type="file" name="m_file" multiple="multiple"/>
	<input type="text" name="src" placeholder="UPLOADER NAME" />
	<input type="submit" value="multiple"/>
	<input type="reset" value="reset" /> 
</form>

</body>
</html>