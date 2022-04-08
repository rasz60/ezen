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
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- file convert -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.2.11/jspdf.plugin.autotable.min.js"></script>
<script src="js/tableHTMLExport.js"></script>
<title></title>
</head>

<body>

<!-- 테이블을 PDF, CSV 파일로 변환 -->
<h3 class="text-center">JQuery TableHTMLExport Plugin Examples</h3>
<table class="table table-bordered table-hover" id="example">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">First</th>
			<th scope="col">Last</th>
			<th scope="col">Handle</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">1</th>
			<td>Jamie</td>
			<td>Otto</td>
			<td>@mdo</td>
		</tr>
		
		<tr>
			<th scope="row">2</th>
			<td>Jacob</td>
			<td>Thornton</td>
			<td>@fat</td>
		</tr>
	</tbody>
</table>

<!-- bootstrap .lead : p의 글자 크기와 라인 간격을 증가시킴 -->
<p class="lead">
	<button id="json" class="btn btn-primary">To JSON</button>
	<button id="csv" class="btn btn-info">To CSV</button>
	<button id="pdf" class="btn btn-danger">To PDF</button>
	<button id="print" class="btn btn-success" onclick="window.print()">전체 화면 인쇄</button>
</p>

<script>
$(document).ready(function() {
	$('#json').on('click', function() {
		$('#example').tableHTMLExport({
			type: 'json',
			filename: 'sample.json'
		});
	});

	$('#csv').on('click', function() {
		$('#example').tableHTMLExport({
			type: 'csv',
			filename: 'sample.csv'
		});
	});
	
	/*
	// 한글 지원 안됨
	$('#pdf').on('click', function() {
		$('#example').tableHTMLExport({
			type: 'pdf',
			filename: 'sample.pdf'
		});
	});
	*/
	
	
	$('#pdf').on('click', function() {
		html2canvas(document.getElementById('example'), {
			onrendered : function(canvas) {
				var imgData = canvas.toDataURL('images/png');
				
				var doc = new jsPDF('p', 'mm', [297, 210]);
				doc.addImage(imgData, 'PNG', 5,5,55,20);
				doc.save('sample.pdf');
			}
		})
	})
	
	
})

</script>

</body>
</html>