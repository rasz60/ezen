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

<!-- dashboard 용 script cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>
<title>DashBoard</title>

<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#main {
	height: auto;
}
</style>
</head>

<body>
<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<br /><br />

<div class="container">
	<a href="bar" id="bar" class="btn btn-primary"><i class="fa-solid fa-chart-column"></i></a>&nbsp;&nbsp;
	<a href="pie" id="pie" class="btn btn-danger"><i class="fa-solid fa-chart-pie"></i></a>&nbsp;&nbsp;
	<a href="line" id="line" class="btn btn-success"><i class="fa-solid fa-chart-line"></i></a>&nbsp;&nbsp;
</div>

<div id="main" class="container mt-5">
	<canvas id="canvas" style="min-height: 350px;"></canvas>
</div>

<%@ include file="footer.jsp" %>

<script>
$(document).ready(function() {
	var chartLabels = [];
	var chartData1 = [];
	var chartData2 = [];
	
	// 그래프를 그릴 수 있도록 가공해둔 변수
	var lineChartData = {
			// 그래프의 기본 x축 값
			labels : chartLabels,
			datasets : [	// 그래프에 표시 할 데이터 값 chartData1, chartData2를 수용
				{
					label : "월별 pc 판매량", //데이터 종류 이름
					fillColor : "rgba(220, 220, 220, 0.2)", //그래프 색
					strokeColor : "rgba(220, 220, 220, 1)", //선 색
					pointColor : "rgba(220, 220, 220, 1)",
					pointStrokeColor : "#fff",
					pointHightlightFill : "#fff",
					pointHightlightStroke : "rgba(220, 220, 220, 1)",
					data : chartData1
				},
				{
					label : "월별 모니터 판매량", //데이터 종류 이름
					fillColor : "rgba(151, 187, 205, 0.2)", //그래프 색
					strokeColor : "rgba(151, 187, 205, 1)", //선 색
					pointColor : "rgba(151, 187, 205, 1)",
					pointStrokeColor : "#fff",
					pointHightlightFill : "#fff",
					pointHightlightStroke : "rgba(151, 187, 205, 1)",
					data : chartData2
				}
			]
	};
	
	function createChart(){
		let ctx = document.getElementById("canvas").getContext("2d"); //그림그리기 객체
		// Chart.Line() 메서드는 Chartjs에서 제공한 막대그래프 그리기 메서드
		LineChartDemo = Chart.Line(ctx,{ //그림그리기 객체를 이용해서 
			data : lineChartData,  //사용할 데이터
			options : {
				scales : { // 눈금표시
					yAxes : [ // y축
						{
							ticks : {
								beginAtZero : true // 0에서부터 시작
							}	
						}
					]
				}
			}
		});
	}
	
	
	
	$.ajax({
		url : "dashView", //서버에서 그래프용 데이터 처리 요청
		type : "post",
		data : { //서버로 보내는 데이터(여러개 보낼 시 객체형으로 보냄)
			cmd : "chart", //getParameter로 처리
			subcmd : "line", // line 방식으로 
			${_csrf.parameterName}:"${_csrf.token}"
		},
		dataType : "json", //서버에서 오는 데이터형
	 	success : function(result){ // result는 서버에서 오는 json형태 값
	 		// .each함수는 자바의 enhanced for문
	 		// result.datas는 배열형 객체, index는 색인번호, obj는 현재 객체
	 		$.each(result.datas, function(index, obj){ 
	 			chartLabels.push(obj.month); //배열 마지막에 값 넣어 주는 메서드 push()
	 			chartData1.push(obj.pc);
	 			chartData2.push(obj.monitor);
	 		});
	 		createChart(); // 변수에 값 다 넣은 후 createChart() 메서드 실행
	 	},
	 	error : function(){
	 		alert("There is an error : method(group)에 에러가 있습니다.")
	 	}
		
	});
	
})

</script>


<script>
$('#bar').click(function(event) {
	event.preventDefault();
	
	$.ajax({
		url: 'bar',
		type: 'get',
		success: function(data) {
			$('#main').html(data);
		},
		error : function() {
			
		}
	});
});

$('#pie').click(function(event) {
	event.preventDefault();
	$.ajax({
		url: 'pie',
		type: 'get',
		success: function(data) {
			$('#main').html(data);
		},
		error : function() {
			
		}
	});
});

$('#line').click(function(event) {
	event.preventDefault();
	$.ajax({
		url: 'line',
		type: 'get',
		success: function(data) {
			$('#main').html(data);
		},
		error : function() {
			
		}
	});
});


</script>

</body>
</html>