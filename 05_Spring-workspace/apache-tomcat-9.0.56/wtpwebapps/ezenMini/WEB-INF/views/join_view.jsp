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
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	  integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	  crossorigin="anonymous"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#main {
	height: auto;
}

.h4 {
	font-style: italic;
	color: #373839;
}

#uProfile {
	resize: none;
}
</style>


</head>

<body>
<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<div id="main" class="container mt-5">

	<input type="hidden" id="modalBtn" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" value="modal"/>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-dialog-centered modal-sm text-center">
			<div class="modal-content">
				<div class="modal-header bg-light">
					<h4 class="modal-title display-4 text-italic">회원가입</h4>
				</div>
				<div class="modal-body bg-light">
					<p class="h5">회원 가입을 축하합니다.</p>					
				</div>
				<div class="modal-footer bg-light">
					<button type="button" id="closeBtn" class="btn btn-default btn-success" data-dismiss="modal" >Close</button>				
				</div>
			</div>
		</div>
	</div>

	<h4 class="modal-title display-4">회원가입</h4>
	<hr />		
	<form action="join" method="post" id="frm1" name="frm1">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		
		<div class="form-group">
			<label for="uId">아이디</label>
			<input type="email" class="form-control" name="pid" placeholder="e-mail주소 입력" id="uId" required />
		</div>
		
		<div class="form-group">
			<label for="uPw">비밀번호</label>
			<input type="password" class="form-control" name="ppw" placeholder="비밀번호 입력" id="uPw" required />
		</div>
		
		<div class="form-group">
			<label for="uAddress">주소</label>
			<input type="text" class="form-control" name="paddress" placeholder="주소 입력" id="uAddress" required />
		</div>
		
		<div class="form-group">
			<label for="uHobby">취미</label>
			<input type="text" class="form-control" name="phobby" placeholder="취미 입력" id="uHobby" required />
		</div>
		
		<div class="form-group">
			<label for="uProfile">자기소개</label>
			<textarea name="pprofile" id="uProfile" rows="20" class="form-control" placeholder="자기소개를 입력하세요" required></textarea>
		</div>
		
		<div class="buttons d-flex justify-content-end">
			<button type="submit" class="btn btn-success mr-2">가입</button>
			<button type="reset" class="btn btn-danger mr-2">취소</button>
		</div>
	</form>
	
</div>
<%@ include file="footer.jsp" %>

<script>
$(document).ready(function() {
	$('#frm1').submit(function(e) {
		e.preventDefault();
		
		$.ajax({
			type: $('#frm1').attr('method'),
			url: $('#frm1').attr('action'),
			data: $('#frm1').serialize(),
			success: function(data) {
				if ( data. search("join-success") > -1 ) {
					$('.modal-body p').text('회원가입을 축하합니다');
					$('#modalBtn').trigger('click');
					
					$('#closeBtn').click(function(e) {
						e.preventDefault();
						location.href = "login_view";
					})
				} else {
					$('.modal-body p').text('동일한 아이디가 존재합니다.');
					$('#modalBtn').trigger('click');
				}
			},
			error: function(data) {
				$('.modal-body p').text('동일한 아이디가 존재하거나 입력한 값에 오류가 있습니다.');
				$('#modalBtn').trigger('click');
			}
		})
		
		
	})
})



</script>

</body>
</html>