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
<title>Write View</title>
<style>
#content {
	resize: none;
}

</style>

</head>

<body>

<div class="container">
	<h3 class="display-4 font-italic">Reply</h3>
	<hr />
	<form action="reply" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"/>
		<input type="hidden" name="bGroup" value="${reply_view.bGroup }"/>
		<input type="hidden" name="bStep" value="${reply_view.bStep }" />
		<input type="hidden" name="bIndent" value="${reply_view.bIndent }" />

		<div class="form-group">
			<label for="uId">번호</label>
			<input type="text" class="form-control" id="uId" name="bId" value="${reply_view.bId }" readonly/>
		</div>
		
		<div class="form-group">
			<label for="hit">조회수</label>
			<input type="text" class="form-control" id="hit" name="bHit" value="${reply_view.bHit }" readonly/>
		</div>
		
		<div class="form-group">
			<label for="uName">이름</label>
			<input type="text" class="form-control" id="uName" name="bName" value="${username }" readonly/>
		</div>
		
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="title" name="bTitle" placeholder="댓글 제목" required/>
		</div>
		
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" id="content" name="bContent" rows="10" placeholder="댓글 내용" required></textarea>
		</div>
		
		<button type="submit" class="btn btn-success">댓글 작성</button>
		<a href="board" class="btn btn-primary">목록 보기</a>			
	</form>
</div>

</body>
</html>