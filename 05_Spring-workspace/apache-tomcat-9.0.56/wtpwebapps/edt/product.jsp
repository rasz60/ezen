<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/product.css" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
    <title>EDT_SHOP</title>
</head>

<body>
    <%@include file="header.jsp"%>
  	<section id="detail">
  	<%@include file="dbconn.jsp" %>
  	<%
  		PreparedStatement pstmt = null;
        ResultSet rs = null;
        String p_id= request.getParameter("p_id");
        String brand= null;
        
        String sql = "SELECT * FROM product3 WHERE p_id='"+p_id+"'";
        pstmt = conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
        brand = rs.getString("p_brand");	
        	
    %>
        	
        <div id="productImg">
            <div id="img">
                <img src="resources/img/p_img/<%=rs.getString("p_image")%>" alt="덩크 범고래"> <!--src="p_img"-->
            </div>
        </div>
        <div id="productDesc">
            <a href="products.jsp?brand='<%=brand %>'">
                <h3 id="p_brand"><%=rs.getString("p_brand")%></h3> <!--p_brand-->
            </a>

            <div id="p_name">
                <p><b><%=rs.getString("p_ename")%></b></p> <!--p_ename-->
                <p class="grayTxt"><%=rs.getString("p_kname")%></p> <!--p_kname-->
            </div>

            <div id="p_size">
                <div>
                    <p class="grayTxt">Size</p>
                </div>
                <div>
                    <p><b>Ur Size</b></p><span>+</span>
                </div>
            </div>
            <div id="size_detail">
                <table id="size_table">
                    <tr class="size">
                        <td>200</td>
                        <td>205</td>
                        <td>210</td>
                        <td>215</td>
                        <td>220</td>
                        <td>225</td>
                    </tr>
                    <tr class="size">
                        <td>230</td>
                        <td>235</td>
                        <td>240</td>
                        <td>245</td>
                        <td>250</td>
                        <td>255</td>
                    </tr>
                    <tr class="size">
                        <td>260</td>
                        <td>265</td>
                        <td>270</td>
                        <td>275</td>
                        <td>280</td>
                        <td>285</td>
                    </tr>
                    <tr class="size">
                        <td>290</td>
                        <td>295</td>
                        <td>300</td>
                        <td>305</td>
                        <td>310</td>
                        <td>315</td>
                    </tr>
                    <tr id="choose_size">
                        <td colspan="2">size</td>
                        <td colspan="3" id="check"></td>
                        <td id="cancel_size">
                            <span>x</span>
                        </td>
                    <tr id="size_btn">
                        <td colspan="3" id="submit">choose</td>
                        <td colspan="3" id="cancel">cancel</td>
                    </tr>
                </table>
            </div>

            <div id="p_selected">
                <div>
                    <p class="grayTxt">Price</p>
                </div>
                <div>
                    <p><b>￦<%=rs.getString("p_price").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")%></b></p> <!--p_price-->
                </div>
            </div>

            <div id="button">
                <a href="#">
                    <div id="purchase">
                        Purchase
                    </div>
                </a>
                <a href="#">
                    <div id="hit">
                        <span>♡</span> Like <small><%=rs.getString("p_hit")%></small> <!--p_hit-->
                    </div>
                </a>
                <a href="#">
                    <div id="cart">
                        Add to cart
                    </div>
                </a>
            </div>

            <h4>PRODUCT INFO</h4>
            <div id="p_info">
                <div class="info">
                    <p class="grayTxt">MODEL ID</p>
                    <p><%=rs.getString("p_id")%></p> <!--p_id-->
                </div> 
                <div class="info">
                    <p class="grayTxt">RELEASE DATE</p>
                    <p><%=rs.getString("p_date").substring(0, 10)%></p> <!--p_date-->
                </div>
                <div class="info">
                    <p class="grayTxt">COLLECTION</p>
                    <p><%=rs.getString("p_collection")%></p> <!--p_collection-->
                </div>
                <div class="info">
                    <p class="grayTxt">GENDER</p>
                    <p><%=rs.getString("p_gender")%></p> <!--p_gender-->
                </div>
            </div>

            <div id="edt_rules">
                <h3>PLEASE READ ME ! ! !</h3>
                <ul class="rule">
                    <li class="default">
                        <p>배송 기간 안내</p><span>^</span>
                    </li>
                    <li class="dropDown">
                        <p>
                            <b>edt#은 최대한 빠르게 모든 상품을 배송하기 위해 노력하고 있습니다.
                            배송 기간은 상품 혹은 배송 지역에 따라 차이가 있습니다.</b><br />
                            <br />
                            - 거래가 체결된 시점부터 48시간(일요일•공휴일 제외)내에 상품이 발송되며, 
                            통상적으로 발송 후 1-2일 내에 배송지에 도착합니다.
                            <br />
                            * 상품 종류 및 상태에 따라 배송 기간이 상이할 수 있으며, 
                            구매의사 확인에 해당할 경우 구매자와 상담 진행으로 인해 지연이 발생할 수 있습니다.
                            <br /><br />
                            - 매 영업일에 출고를 진행하고 있으며, 출고 마감시간은 오후 5시입니다. 
                            출고 마감시간 이후 구매건은 운송장번호는 입력되지만 다음 영업일에 출고됩니다.
                        </p>
                    </li>
                    <li class="default">
                        <p>구매 환불/취소/교환 안내</p><span>^</span>
                    </li>
                    <li class="dropDown">
                        <p>
                            - 배송 완료 7일 이내에 상품 결함시 교환/반품이 가능합니다. 
                            교환/반품으로 인한 배송비는 고객님이 선결재해주시면 결함 확인 후 입금해드립니다.
                            <br /><br />
                            - 단순 변심이나 실수에 의한 취소/교환/반품은 불가능합니다.
                            <br /><br />
                            - 상품 수령 후, 이상이 있는 경우 edt# 고객센터로 문의해주시기 바랍니다.
                        </p>
                    </li>
            </div>
        </div>
        <% }
       		 rs.close();
        	pstmt.close();
        	
        %>
    </section>

    <section id="recommand1">
        <div class="container">
            <div class="recTitle">
                <h3>추천 상품</h3><a href="#"><span>더보기 &gt;</span></a>
            </div>
            <div class="productBox">
                <ul>
                <%
			  		pstmt = null;
			        rs = null;
			        
			        
			        sql = "SELECT * FROM product3 ORDER BY p_hit";
			        pstmt = conn.prepareStatement(sql);
			        rs=pstmt.executeQuery();
			        for(int i = 0 ; i < 5; i++){
			        rs.next();
				%>
                    <li>
                        <a href="product.jsp?p_id=<%=rs.getString("p_id")%>">
                            <div class="p_img">
                                <img src="resources/img/p_img/<%=rs.getString("p_image")%>" alt="덩크 범고래">
                            </div>
                        </a>
                        <div class="p_info">
                            <a href="product.jsp?p_id=<%=rs.getString("p_id")%>">
                                <p class="p_brand"><b><%=rs.getString("p_brand")%></b></p>
                                <p class="p_ename"><%=rs.getString("p_ename")%></p>
                                <p class="p_kname"><%=rs.getString("p_kname")%></p>
                                <p class="price">￦<%=rs.getString("p_price").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")%></p>
                            </a>
                        </div>
                    </li>
                   <%	
             			}
			       		rs.close();
			        	pstmt.close();
					%>
                </ul>
            </div>
        </div>
    </section>

    <section id="recommand2">
        <div class="container">
            <div class="recTitle">
                <h3><%=brand%>의 다른 상품</h3><a href="products.jsp?brand='<%=brand %>'"><span>더보기 &gt;</span></a>
            </div>
            <div class="productBox">
                <ul>
                <%
			  		pstmt = null;
			        rs = null;
			        
			        
			        sql = "SELECT * FROM product3 WHERE p_brand='"+brand+"'";
			        pstmt = conn.prepareStatement(sql);
			        rs=pstmt.executeQuery();
			        for(int i = 0 ; i < 5; i++){
			        rs.next();
			        
        		%>
                    <li>
                        <a href="product.jsp?p_id=<%=rs.getString("p_id")%>">
                            <div class="p_img">
                                <img src="resources/img/p_img/<%=rs.getString("p_image")%>" alt="덩크 범고래">
                            </div>
                        </a>
                        <div class="p_info">
                            <a href="product.jsp?p_id=<%=rs.getString("p_id")%>">
                                <p class="p_brand"><b><%=rs.getString("p_brand")%></b></p>
                                <p class="p_ename"><%=rs.getString("p_ename")%></p>
                                <p class="p_kname"><%=rs.getString("p_kname")%></p>
                                <p class="price">￦<%=rs.getString("p_price").replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")%></p>
                            </a>
                        </div>
                    </li>
                    <%
                    }
                    rs.close();
		        	pstmt.close();
		        	conn.close();
		      		%>
                </ul>
            </div>
        </div>
    </section>
  
    <%@include file="footer.jsp"%>
</body>
</html>