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
</head>

<body>

<canvas id="canvas" class="container" style="min-height: 350px;"></canvas>

<script>
$(document).ready(function() {
	var chartLabels = [];
	var chartData1 = [];
	var chartData2 = [];

	var barChartData = {
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
				data : chartData1,
				backgroundColor: [
					'#FF6384',
					'#4BC0C0',
					'#FFCE56',
					'#E7E9ED',
					'#36A2EB'
				]
			},
			{
				label : "월별 모니터 판매량", //데이터 종류 이름
				fillColor : "rgba(151, 187, 205, 0.2)", //그래프 색
				strokeColor : "rgba(151, 187, 205, 1)", //선 색
				pointColor : "rgba(151, 187, 205, 1)",
				pointStrokeColor : "#fff",
				pointHightlightFill : "#fff",
				pointHightlightStroke : "rgba(151, 187, 205, 1)",
				data : chartData2,
				backgroundColor: [
					'#FF6384',
					'#4BC0C0',
					'#FFCE56',
					'#E7E9ED',
					'#36A2EB'
				]
			}
		]
	};
	
	function createChart() {
		var ctx = document.getElementById('canvas').getContext('2d');
		new Chart(ctx, {
			type: 'horizontalBar',
			data: barChartData,
			options: {
				scales: {
					xAxes: [
						{
							ticks: {
								beginAtZero : true
							}
						}
					]
				}
			}
		})
	};
	
	$.ajax({
		url: 'dashView',
		type: 'post',
		data: {
			cmd: 'chart',
			subcmd: 'line',
			${_csrf.parameterName}:"${_csrf.token}"
		}, 
		dataType: 'json',
		success: function(result) {
			$.each(result.datas, function(index, obj) {
				chartLabels.push(obj.month);
				chartData1.push(obj.pc);
				chartData2.push(obj.monitor);
			});
			createChart();
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert('There is an error : method(group)에 에러가 있습니다.')
		}
		
	});
});
</script>

</body>
</html>