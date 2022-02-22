<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="script/board.js"></script>
<title>게시판 입력 Form</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400&display=swap');;
* {
	font-family: 'Noto Sans KR', sans-serif;
}

textarea {
	resize: none;
}
</style>
</head>

<body>

<div class="container-fluid p-3 border bg-light mt-5">
	<h4>WRITE FORM</h4>
	<hr />

	<form action="write.do" method="post" name="form">
		<div class="form-group row">
			<label for="bName" class="col-1 text-right ml-5 mr-2 my-auto" >작성자</label>
			<input type="text" name="bName" id="bName" class="form-control col-9" autofocus placeholder="작성자명"/>
			<small class="d-flex col-1 mt-auto" id="bNameCount">(0 / 20)</small>
		</div>
		<hr />		
		<div class="form-group row">
			<label for="bTitle" class="col-1 text-right ml-5 mr-2 my-auto">제목</label>
			<input type="text" name="bTitle" id="bTitle" class="form-control col-9" placeholder="게시글 제목 (최대 100자)"/>
			<small class="d-flex col-1 mt-auto" id="bTitleCount">(0 / 100)</small>
		</div>
		<hr />
		<div class="form-group text-center">
			<textarea name="bContent" id="bContent" cols="100" rows="20" class="form-control" placeholder="게시글 내용을 작성해주세요. (최대 300자)"></textarea>
		</div>
		<span class="d-flex justify-content-end" id="bContentCount">(0 / 300)</span>
		<hr />
		<div class="d-flex justify-content-end">
			<input type="submit" value="작성" class="btn btn-success btn-lg mr-3" onclick="return checkWrite()" />
			<a href="list.do"><input type="button" value="목록" class="btn btn-danger btn-lg" ></a>
		</div>
	</form>
</div>
</body>
</html>

