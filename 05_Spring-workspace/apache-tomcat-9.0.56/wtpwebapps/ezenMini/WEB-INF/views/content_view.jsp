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
#frm input, #content {
	background-color: #F6FAFF;
}

#frm input[readonly], #content[readonly] {
	background-color: transparent;
}

</style>

</head>

<body>

<div class="container">
	<h3 class="display-4 font-italic">Content View</h3>
	<hr />
	
	<form action="modify" method="post" class="mb-4" id="frm">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		
		<div class="form-group">
			<label for="uId">content#</label>
			<input type="text" class="form-control" id="uId" name="bId" value="${content_view.bId}" readonly/>
		</div>
		
		<div class="form-group">
			<label for="hit">hits</label>
			<input type="text" class="form-control" id="hit" name="bHit" value="${content_view.bHit}" readonly/>
		</div>
		
		<div class="form-group">
			<label for="uname">User ID</label>
			<input type="text" class="form-control" id="uname" name="bName" value="${content_view.bName}" readonly/>
		</div>
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" id="title" name="bTitle" value="${content_view.bTitle }"/>
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			<textarea class="form-control" id="content" name="bContent" rows="10">${content_view.bContent }</textarea>
		</div>
		<a href="board" id="goback" class="btn btn-sm btn-secondary float-right">목록</a>	
		<a href="delete?bId=${content_view.bId}" id="delBtn" class="btn btn-sm btn-danger float-right mr-2">삭제</a>
		<button type="submit" id="modBtn" class="btn btn-sm btn-success float-right mr-2">수정</button>
		<a href="reply_view?bId=${content_view.bId}" id="rv" class="btn btn-sm btn-primary float-right mr-2">댓글</a>
	</form>
</div>

<script>
$(document).ready(function() {
	 
	let username = "<c:out value='${username}'/>";
	let bName = $('#uname').val();
	
	
	if ( username == "" || username != bName ) {
		$('#title').attr('readonly',true);
		$('#content').attr('readonly',true);
		
		$('#modBtn').css('display','none');
		$('#delBtn').css('display','none');
	}
	
	
	$('#modBtn').click(function(e) {
		e.preventDefault();
		
		if ( confirm('게시글을 수정할까요?') == true ) {
			$('#frm').submit();
		} else {
			return false;
		}
	});

	$('#delBtn').click(function(e) {
		e.preventDefault();
		
		if ( confirm('게시글을 삭제할까요?') == true ) {
			location.href = $(this).attr('href');			
			
		} else {
			return false;
		}
	});
	

	$('#rv').click(function(e) {
		e.preventDefault();
		
		$.ajax({
			url: $(this).attr('href'),
			type: 'get',
			success: function(data) {
				$('#main').html(data);
				
			},
			error: function(data) {
				console.log(data);
			}
		});
	});
	
	
});
</script>

</body>
</html>