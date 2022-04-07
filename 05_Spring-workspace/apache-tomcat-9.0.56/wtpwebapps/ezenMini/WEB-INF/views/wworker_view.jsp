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

<h3 class="text-center">간단한 web worker</h3>
<p class="text-center" style="font-size: 25px;">Count numbers : <output id="result"></output></p>

<button class="btn btn-info" onclick="startWorker()">Start Worker</button>
<button class="btn btn-warning" onclick="stopWorker()">Stop Worker</button>
<br /><br />

<h3 class="text-center">응용 web worker</h3>
<div class="form-group">
	<label for="ucal">계산</label>
	<input type="number" class="form-control" name="ucal" placeholder="숫자 입력" id="ucal" />
</div>

<p class="text-center" id="sum" style="font-size:25px;">Sum : </p>
<button class="btn btn-info" onclick="calculate()">Calculate</button>
<button class="btn btn-warning" onclick="stopCalculate()">Stop Calculate</button>


<script>
let w; // worker 객체 변수

function startWorker() {
	if( typeof(Worker) != 'undefined' ) {
		if ( typeof(w) == 'undefined' ) {
			// workTask는 내 프로젝트 내에 js파일로 존재하여야 함
			w = new Worker('js/worker1.js');
		}
		
		w.onmessage = function(e) {
			// event는 MessageEvent이고 data는 MessageEvent의 속성
			$('#result').html(e.data);
		};
		
	} else {
		$('#result').html("Sorry, your browser does not support Web Workers...");
	}
}

function stopWorker() {
	w.terminate(); // worker 종료
	w = undefined; // worker 초기화
	
}

</script>

<script>
let worker;

function calculate() {
	if( worker ) {
		worker.terminate();
	}
	
	let num = $('#ucal').val();
	
	worker = new Worker('js/worker2.js');
	worker.onmessage = function(e) {
		$('#sum').html('Sum : ' + e.data);
	}
	
	worker.onerror = function(e) {
		alert('Error : ' + e.message + ' (' + e.filename + ' : ' + e.lineno + ')');
	}
	
	//백그라운드 태스크에 값을 전달함
	worker.postMessage(num);
}

function stopCalculate() {
	if( worker ) {
		worker.terminate();
	}
	alert('Worker is Stopped.');
}
</script>

</body>
</html>