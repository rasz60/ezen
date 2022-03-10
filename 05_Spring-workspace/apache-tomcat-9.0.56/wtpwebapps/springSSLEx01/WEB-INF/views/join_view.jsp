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
<meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	  integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	  crossorigin="anonymous"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>회원가입창</title>
<style>
textarea {
	resize : none;
}
</style>
</head>

<body>

<div id="main" class="container mt-2 py-5 border rounded">
	<h3 class="text-center text-danger">회원가입</h3>
	<hr />
	
	<form action="join" method="post" id="frm1" name="frm1">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		<div class="form-group">
			<label for="user_id">아이디</label>
			<input type="email" class="form-control" name="pid" id="user_id" placeholder="이메일 주소 입력" required/>
		</div>
		
		<div class="form-group">
			<label for="user_pwd">아이디</label>
			<input type="password" class="form-control" name="ppw" id="user_pwd" placeholder="비밀번호 입력" required/>
		</div>
		
		<div class="form-group">
			<label for="user_address">주소</label>
			<input type="text" class="form-control" name="paddress" id="user_address" placeholder="주소 입력" required/>
		</div>
		
		<div class="form-group">
			<label for="user_hobby">취미</label>
			<input type="text" class="form-control" name="phobby" id="user_hobby" placeholder="취미 입력" required/>
		</div>
		
		<div class="form-group">
			<label for="user_profile">취미</label>
			<textarea class="form-control" name="pprofile" id="user_profile" placeholder="자기소개 입력" rows="10" required></textarea>
		</div>
		<div class="d-flex justify-content-end">
			<input type="submit" value="완료" class="btn btn-sm btn-primary"/>&nbsp;&nbsp;
			<input type="reset" value="취소" class="btn btn-sm btn-danger" />
		</div>
	</form>
</div>

<script>
$(document).ready(function() {
	var frm = $('#frm1');
	
	frm.submit(function(e) {
		e.preventDefault();
		
		$.ajax({
			url : frm.attr('action') ,
			type : frm.attr('method') ,
			data : frm.serialize() ,
									//search('str') : 문자열로된 객체에서 str이 있는지 찾고, boolean으로 반환
			success : function(data) {
				if ( data.search("join-success") > -1 ) {
					$('.modal-body').text('회원가입을 축하합니다.');
					
					// trigger(event) : 자동으로 이벤트가 일어나도록 한다.
					$('#modalBtn').trigger('click');
					$('#closeBtn').click(function(e) {
						e.preventDefault();
						location.href = "login_view";
					});
				} else {
					$('.modal-body').text('동일한 아이디가 존재합니다.');
					$('#modalBtn').trigger('click');
				}
				
			},
			error : function(data) {
				$('.modal-body').text('동일한 아이디가 존재합니다.');
				$('#modalBtn').trigger('click');
			}
		})
	})
})
</script>


</body>
</html>