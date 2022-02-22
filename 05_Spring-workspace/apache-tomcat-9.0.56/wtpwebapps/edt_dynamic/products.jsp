<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/products.css" type="text/css">
    <title>EDT_SHOP</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
    <script type="text/javascript" src="resources/js/fetch/fetch.js"></script>
</head>

<body>
    <%@include file="header.jsp"%>
    
    <nav id="gender_menu">
		<ul>
			<li class="chck_gender" data-value="'M'">MAN</li>
			<li class="chck_gender" data-value="'W'">WOMAN</li>
			<li class="chck_gender" data-value="'KIDS'">KIDS</li>
		</ul>
    </nav>    
    <section id="products">
        <div class="kind_menu">
            <h1>BRAND</h1>
            <ul>
           		<li class="brand_menu"><a href="?">ALL BRAND</a></li>
                <li class="brand_menu"><a href="?brand='JORDAN'">JORDAN</a></li>
                <li class="brand_menu"><a href="?brand='NIKE'">NIKE</a></li>
                <li class="brand_menu"><a href="?brand='ADIDAS'">ADIDAS</a></li>
                <li class="brand_menu"><a href="?brand='NEW BALANCE'">NEW BALANCE</a></li>
            </ul>
        </div>
        
        <div id="prod">
	        <div id="filter_box">
				<span class="filter" data-value="p_date" >최신순</span>
				<span class="filter" data-value="p_hit DESC" >인기순</span>
				<span class="filter" data-value="p_price" >낮은 가격순</span>
				<span class="filter" data-value="p_price DESC" >높은 가격순</span>
	        </div>
			<c:forEach var="products" items="${pList}">
				<div class="product">	        
				    <div class="wrap">      
				        <a href="product.jsp?p_id=${products.pId}"><img src="resources/img/p_img/${products.pImage}" alt="no"></a>
				    </div>
				    <div class="product_info">
				      	<p class="brand"><a href="products.jsp?brand='${products.pBrand}'">${products.pBrand}</a></p>
				        <p class="ename"><a href="#">${products.pEname}</a></p>
				        <p class="kname">${products.pKname}</p>
				        <h3><a href="#"><fmt:formatNumber value="${products.pPrice}" pattern="#,###" />원</a></h3>
				    </div>
				</div>
		</c:forEach>
		</div>
    </section>
    
	<%@include file="footer.jsp"%>
</body>
</html>