<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
           		<li class="brand_menu"><a href="products.jsp">ALL BRAND</a></li>
                <li class="brand_menu"><a href="?brand='JORDAN'">JORDAN</a></li>
                <li class="brand_menu"><a href="?brand='NIKE'">NIKE</a></li>
                <li class="brand_menu"><a href="?brand='ADIDAS'">ADIDAS</a></li>
                <li class="brand_menu"><a href="?brand='NEW BALANCE'">NEW BALANCE</a></li>
            </ul>
        </div>
        <%@include file="dbconn.jsp" %>
        <div id="prod">
	        <div id="filter_box">
				<span class="filter" data-value="p_date" >최신순</span>
				<span class="filter" data-value="p_hit DESC" >인기순</span>
				<span class="filter" data-value="p_price" >낮은 가격순</span>
				<span class="filter" data-value="p_price DESC" >높은 가격순</span>
	        </div>
		<%	
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String brand = request.getParameter("brand");
			String gender = request.getParameter("gender");
			String filter = request.getParameter("filter");
			String sql = "SELECT * FROM product3";
			
			if( brand != null || gender != null ) {
				sql += " WHERE";
			}
			
			if ( brand != null && gender != null ) {
				sql += " p_brand = " + brand + " AND p_gender = " + gender;
			} else if ( brand == null && gender != null ) {
				sql += " p_gender = " + gender;
			} else if ( brand != null && gender == null ) {
				sql += " p_brand = " + brand;
			} 
			
			if( filter != null) {
				sql += " ORDER BY " + filter;
			}
			
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			while(rs.next()){
		%>
		<div class="product">	        
		    <div class="wrap">      
		        <a href="product.jsp?p_id=<%=rs.getString("p_id")%>"><img src="resources/img/p_img/<%=rs.getString("p_image")%>" alt="no"></a>
		    </div>
		    <div class="product_info">
		      	<p class="brand"><a href="products.jsp?brand='<%=rs.getString("p_brand")%>'"><%=rs.getString("p_brand")%></a></p>
		        <p class="ename"><a href="#"><%=rs.getString("p_ename")%></a></p>
		        <p class="kname"><%=rs.getString("p_kname")%></p>
		        <h3><a href="#"><%=rs.getString("p_price").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")%>원</a></h3>
		    </div>
		</div>
		<% }
			rs.close();
			pstmt.close();
			conn.close();
		%>
		</div>
    </section>
    
	<%@include file="footer.jsp"%>
</body>
</html>