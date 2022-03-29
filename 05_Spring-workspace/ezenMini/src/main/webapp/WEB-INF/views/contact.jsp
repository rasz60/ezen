<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix ="sec" uri = "http://www.springframework.org/security/tags" %>

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

#search-panel {
	width: 65%;
	position: relative;
	top: 60px;
	z-index: 5;
	background-color: #FFF;
	padding: 5px;
	margin: auto;
}

#address {
	padding: 10px;
}

#google-map {
	width: 100%;
	height: 600px;
	margin: 0;
	padding: 0;
}
</style>
</head>

<body>
<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<div id="main" class="container mt-5">
	<h3 class="display-4 font-italic">Contact</h3>
	<div id="search-panel"><%-- 주소로 위치 찾기 --%>	
		<input type="text" id="address" placeholder="주소를 입력하세요" size="70px" class="border" autofocus="autofocus"/>
		<button type="button" id="submit" class="btn btn-primary" value="Geocode">지도 검색</button>
	</div>
	
	<%-- 구글 맵 박스 --%>
	<div id="google-map" class="mx-auto mb-5"></div>
	
	<%-- 연락처 정보 --%>
	<div class="row">
		<div class="d-flex col-4 flex-column">
			
			<div class="d-flex flex-row">
				<div>
					<i class="fa fa-home" aria-hidden="true"></i>
				</div>
				<div>
					<h5>Binghamton, New York</h5>
					<p>
						4343 Hinkle Deegan Lake Road
					</p>
				</div>
			</div>
	
			<div class="d-flex flex-row">
				<div>
					<i class="fa fa-headphones" aria-hidden="true"></i>
				</div>
				<div>
					<h5>00 (958) 9865 562</h5>
					<p>Mon to Fri 9am to 6 pm</p>
				</div>
			</div>
			
			<div class="d-flex flex-row">
				<div>
					<i class="fa fa-envelope" aria-hidden="true"></i>
				</div>
				<div>
					<h5>support@colorlib.com</h5>
					<p>Send us your query anytime!</p>
				</div>
			</div>
		</div>

		<div class="col-8">
			<form class="text-right" id="myForm" action="" method="post">
				<div class="row">
					<div class="col-6 form-group">
						<input name="name" placeholder="Enter your name" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Enter your name'" class="mb-20 form-control" type="text">
						<input name="email" placeholder="Enter email address" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$"
							 onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" class="mb-20 form-control"
							 type="email">
						<input name="subject" placeholder="Enter subject" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter subject'"
							 class="mb-20 form-control" type="text">
					</div>
					<div class="col-6 form-group">
						<textarea class="form-control" name="message" placeholder="Enter Messege" onfocus="this.placeholder = ''"
							 onblur="this.placeholder = 'Enter Messege'" rows="5"></textarea>
					</div>
					<div class="col-12">
						<div style="text-align: left;"></div>
						<button class="btn btn-primary" style="float: right;">Send Message</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="footer.jsp" %>

<script>
// Google Map API 주소의 callback 함수
function initMap() {
	console.log('Map is initialized.');
	
	let map;
	
	getLocation();
	
	function getLocation() {
		if( navigator.geolocation ) {
			navigator.geolocation.watchPosition(showPosition);
		} else {
			map = $('#google-map');
			map.text('Geolocation is not supported by this browser');
		}
		
		function showPosition(position) {
			lati = position.coords.latitude;
			longi = position.coords.longitude;
			
			map = new google.maps.Map(document.getElementById('google-map'), {
				zoom: 16,
				center: new google.maps.LatLng(lati, longi)
			});
			
			var marker = new google.maps.Marker({
				position: new google.maps.LatLng(lati, longi),
				map: map,
				title: 'hello, world'
			});
		};
		
		
		var geocoder = new google.maps.Geocoder();
		
		document.getElementById('submit').addEventListener('click', function() {
			console.log('submit 버튼 클릭 이벤트 실행');
			geocodeAddress(geocoder, map);
		});
		
		function geocodeAddress(geocoder, resultMap) {
			console.log('geocodeAddress 함수 실행');
			let address = document.getElementById('address').value;

			//입력받은 주소로 좌표에 맵 마커를 생성
			geocoder.geocode({'address' : address}, function(result, status) {
														console.log('result : ' + result + " / " + "status : " + status);
														
														if ( status === 'OK' ) {
																													
															resultMap.setCenter(result[0].geometry.location);
															resultMap.setZoom(18);
															
															var marker = new google.maps.Marker({
																map: resultMap,
																position: result[0].geometry.location
															});
															
															console.log('위도(latitude) : ' + marker.postion.lat());
															console.log('위도(longitude) : ' + marker.postion.lng());
														} else {
															alert('검색 결과가 없습니다.');
														}
														
													 });
		};
	}
}

</script>


<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCl3troictldoLX7-RsH7NiFiGVzUWGgv8&callback=initMap&v=weekly&channel=2">

/* 
 * async와 defer는 백그라운드에서 다운로드를 하여 html 파싱을 방해하지 않으나 defer는 외부 script만 제한
 * defer는 파싱 종료시까지 실행을 멈추나 async는 실행시에는 html 파싱이 멈춤
 * 두개를 동시에 사용하여 트 실행을 멈춤
 */

</script>
</body>
</html>