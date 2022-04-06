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
<script src="https://kit.fontawesome.com/b4e02812b5.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title></title>
</head>

<body>

<div class="container mt-5">
	<button type="button" id="wsbtn1" class="btn btn-primary" onclick="clickCounter1()" >문자열 저장</button>
	<button type="button" id="wsbtn2" class="btn btn-danger" onclick="clickCounter2()" >객체형 저장</button>
</div>

<div class="container mt-5">
	<h3 class="text-center display-4" style="font-size:40px;">문자열 저장 버튼 클릭시 값을 불러옴.</h3>
	<div id="ws1result" class="text-center" style="font-size:25px;">
	</div>
	<br />
	
	<h3 class="text-center display-4" style="font-size:40px;">객체형 저장 버튼 클릭시 값을 불러옴.</h3>
	<div id="ws2result" class="text-center" style="font-size:25px;"></div>
	<div id="ws2div1" class="text-center" style="font-size:25px;"></div>
	<div id="ws2div2" class="text-center" style="font-size:25px;"></div>
	<div id="ws2div3" class="text-center" style="font-size:25px;"></div>
</div>


<script>
// Local Storage는 서버로 전송하지 않고도 값을 저장할 수 있다. 삭제시키기 전까지 값을 유지하며, 최소 5MB의 저장공간을 제공한다.
// 브라우저별로 지원하지 않는 경우가 있으니 유의

function clickCounter1() {
	// browser의 webstorage 지원 여부 확인
	if ( typeof(Storage) !== 'undefined' ) {
		// localStorage에 clickcount 값이 있을 때 진입
		if ( localStorage.clickcount ) {
			localStorage.clickcount = Number(localStorage.clickcount)+1;
		} else {
			// 없으면 clickcount 속성을 만들고 값을 1로 설정
			localStorage.clickcount = 1;
		}
		
		document.getElementById('ws1result').innerHTML = 
			"You have clicked the button " + localStorage.clickcount + " time(s).";
		
	} else {
		document.getElementById('ws2result').innerHTML = 
			"Sorry, your browser does not support web storage...";
	}
	
}

function clickCounter2() {
	if ( typeof(Storage) !== 'undefined' ) {
		localStorage.setItem('lastname', 'Smith');
		$('#ws2result').html(localStorage.getItem('lastname'));
		
		// 객체 저장을 위한 메서드를 storage 객체에 추가(prototype 사용)
		Storage.prototype.setObject = function(key, value) {
			this.setItem(key, JSON.stringify(value));
		}
		
		// 객체 반환을 위한 메서드 get 추가
		Storage.prototype.getObject = function(key) {
			// key값의 value가 있으면 JSON 객체로 parse하여 반환
			return this.getItem(key) && JSON.parse((this.getItem(key)));
		}
		
		let objectA = {
				stringValue : new String('okTest'),
				arrayValue : new Array('A', 'B', 'C')
		};
		
		// localStorage에 objectA 저장
		localStorage.setObject('key1', objectA);
		
		// 저장된 objectA를 반환
		let item1 = localStorage.getObject('key1');		
		
		$('#ws2div1').html(item1.stringValue);
		$('#ws2div2').html(item1.arrayValue.join());

		// 현재 localStorage에 저장된 모든 값이 몇 개인지 알 수 있다.
		$('#ws2div3').html(localStorage.length);

		for( var i = 0; i < localStorage.length; i++ ) {
			console.log(localStorage.key(i));
		}
	} else {
		$('ws2result').html("Sorry, your browser does not support web storage...");
	}
}
</script>
</body>
</html>