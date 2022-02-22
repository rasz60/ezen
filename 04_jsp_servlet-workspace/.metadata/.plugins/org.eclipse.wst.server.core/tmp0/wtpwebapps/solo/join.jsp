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
<script type="text/javascript" src="joinScript.js"></script>
<title>Join Us</title>
</head>

<body>

<div class="container border">
	<h3 class="mt-3">JOIN US</h3>
	<hr />
	<form action="joinCheck.jsp" method="post" class="p-2">
		<div class="form-inline row p-2 mt-1 mb-1 border">
			<label for="id" class="col-2 justify-content-start">ID</label>
			<input type="text" class="form-control col-5" id="id" name="id" placeholder="영소문자/숫자 조합 15자 이하"/>
			<input type="submit" value="중복확인" class="btn btn-sm btn-success ml-2" />
			<small class="mt-3 ml-2">※ 아이디 : 영소문자/숫자 조합 15자 이하</small>
		</div>

		<div class="form-inline row p-2 mt-1 mb-1 border">
			<label for="pwd" class="col-2 justify-content-start">PASSWORD</label>
			<input type="password" class="form-control col-5" id="pwd" name="pwd" placeholder="영소문자/숫자/특수문자 조합 15자 이하"/>
			<small class="mt-3 ml-2">※ 비밀번호 : 영소문자/숫자/특수문자 조합 15자 이하</small>
		</div>
		
		<div class="form-inline row p-2 mt-1 mb-1 border">
			<label for="pwdCheck" class="col-2 justify-content-start">PASSWORD CHECK</label>
			<input type="password" class="form-control col-5" id="pwdCheck" name="pwdCheck" placeholder="영소문자/숫자/특수문자 조합 15자 이하"/>
			<small class="mt-3 ml-2" id="pwdCheckStatus"></small>
		</div>
		
		<div class="form-inline row p-2 mt-1 mb-1 border">
			<label for="name" class="col-2 justify-content-start">NAME</label>
			<input type="password" class="form-control col-5" id="name" name="name" placeholder="이름"/>
		</div>
	
		<div class="form-inline row p-2 mt-1 mb-1 border">
			<label for="email" class="col-2 justify-content-start">E-MAIL</label>
			<input type="text" class="form-control col-3" id="email" name="email" placeholder="email ID"/>
			<select name="domain" id="emailDomain" class="col-2 p-1 ml-1">
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="gmail.com">gmail.com</option>
			</select>
		</div>
		
		<div class="form-inline row p-2 mt-1 mb-1 border">
			<label for="phoneNumber" class="col-2 justify-content-start">PHONE</label>
			<input type="text" class="form-control col-1 mr-1" id="phoneNumber1" name="phoneNumber" value="010" disabled/>&nbsp;-&nbsp;
			<input type="text" class="form-control col-1 mr-1" id="phoneNumber2" name="phoneNumber"/>&nbsp;-&nbsp;
			<input type="text" class="form-control col-1 mr-1" id="phoneNumber3" name="phoneNumber"/>
		</div>
		
		<hr />
		<input type="submit" value="가입" class="btn btn-primary mb-2" />
	</form>
</div>
</body>
</html>