<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/main.css" type="text/css">
    <title>EDT</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
    <%@include file="header.jsp"%>

    <section class="box">
        <div id="container">
            <ul id="img_slide" onmouseover="stopSlide()" onmouseout="autoSlide()">
                <li class="slides">
                    <a href="#">
                        <img src="resources/img/slide1.jpg">
                    </a>
                </li>
                <li class="slides">
                    <a href="#">
                        <img src="resources/img/slide2.jpg">
                    </a>
                </li>
                <li class="slides">
                    <a href="#">
                        <img src="resources/img/slide3.jpg">
                    </a>
                </li>
                <li class="slides">
                    <a href="#">
                        <img src="resources/img/slide4.jpg">
                    </a>
                </li>
            </ul>
        </div>

        <span id="prev" onclick="prev_btn()" title="click!">&lt;</span>
        <span id="next" onclick="next_btn()" title="click!">&gt;</span>

        <button class="btn2" onclick="moveSlide(1);" title="img1"></button>
        <button class="btn2" onclick="moveSlide(2);" title="img2"></button>
        <button class="btn2" onclick="moveSlide(3);" title="img3"></button>
        <button class="btn2" onclick="moveSlide(4);" title="img4"></button>
        <script>
            /*이미지 슬라이드 이동 함수*/
            var slideBox = document.getElementById("img_slide");
            var slideIndex = 1;
            var slideCount = document.getElementsByClassName("slides").length;
            function moveSlide(num) {
                switch(num) {
                    case 1 :
                        slideBox.style.transform = 'translate(0%)';
                        slideIndex = 1;
                        break;
                    case 2 :
                        slideBox.style.transform = 'translate(-25%)';
                        slideIndex = 2;
                        break;
                    case 3 :
                        slideBox.style.transform = 'translate(-50%)';
                        slideIndex = 3;
                        break;
                    case 4 :
                        slideBox.style.transform = 'translate(-75%)';
                        slideIndex = 4;
                        break;                    
                    default : 
                        moveSlide(1);
                        break;
                }
                resetSlideTime();
            };

            /* prev & next btn 눌렀을 때 함수 */
            function prev_btn() {
                if ( slideIndex == 1 ) {
                    slideIndex = slideCount;
                } else {
                    slideIndex--;
                }
                moveSlide(slideIndex);
            };

            function next_btn() {
                if ( slideIndex == slideCount ) {
                    slideIndex = 1;
                } else {
                    slideIndex++;
                }
                moveSlide(slideIndex);
            };

            /* 3.5초에 한 장씩 자동으로 이동하는 함수 */
            var slideTime = 0;
            function autoSlide() {
                slideTime = setInterval(function slide() {
                                    if ( slideIndex < slideCount + 1 ) {
                                        moveSlide(++slideIndex);
                                    } else {
                                        slideIndex = 1;
                                        moveSlide(slideIndex);
                                    };                
                                    }, 3500);
            };

            /* 슬라이드가 정지하는 메서드 */
            function stopSlide() {
                clearInterval(slideTime);
            };

            /* 슬라이드를 정지했다가 다시 3.5초 후 자동 이동하는 함수 */
            function resetSlideTime() {
                stopSlide();
                autoSlide();
            };

            /* 페이지 접속하면 autoSlide() 실행 */
            autoSlide();
        </script>
    </section>
    
    <!-- ================================= tabmenu START ================================= -->

    <section class="box">
        <div class="tabmenu">
            <ul>    
                <li id="tab1" class="btnCon"> 
                    <input type="radio" checked name="tabmenu" id="tabmenu1">
                    <label for="tabmenu1">NEW</label>
                    <div class="tabCon" >
                        <div class="productbox">
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/DM7866-140.png" alt="menu1이미지" style="background:#FAFAD2"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">NIKE</p></a>
                                    <a href="#"><p class="ename">Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue</p></a>
                                    <p class="kname">조던 1 x 트래비스 스캇 x 프라그먼트 레트로 로우 OG SP 밀리터리 블루</p>
                                    <h3><a href="#">2,000,000원</a></h3>
                                </div>
                            </div>     
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/555088-010.png" alt="menu1이미지" style="background:#FAFAD2"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">NIKE</p></a>
                                    <a href="#"><p class="ename">Jordan 1 Retro High OG Black White 2014</p></a>
                                    <p class="kname">조던 1 레트로 하이 OG 블랙 화이트 2014</p>
                                    <h3><a href="#">2,000,000원</a></h3>
                                </div>
                            </div>     
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/M992WT.png" alt="menu1이미지"  style="background:#FFF0F0"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">NEW BALANCE</p></a>
                                    <a href="#"><p class="ename">New Balance x WTAPS 992 Made in USA Olive</p></a>
                                    <p class="kname">뉴발란스 x 더블탭스 992 메이드 인 USA 올리브</p>
                                    <h3><a href="#">2,000,000원</a></h3>
                                </div>
                            </div>       
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/BY9612.png" alt="menu1이미지" style="background:#F0FFF0"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">ADIDAS</p></a>
                                    <a href="#"><p class="ename">Adidas Yeezy Boost 350 V2 Core Black Red</p></a>
                                    <p class="kname">아디다스 이지 부스트 350 V2 코어 블랙 레드</p>
                                    <h3><a href="#">2,000,000원</a></h3>
                                </div>
                            </div>
                        </div>    
                    </div>           
                </li>
                <li id="tab2" class="btnCon">
                    <input type="radio" name="tabmenu" id="tabmenu2">
                    <label for="tabmenu2">BEST</label>
                    <div class="tabCon" >
                        <div class="productbox">
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/B35309.png" alt="menu1이미지" style="background:#F0FFF0"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">ADIDAS</p></a>
                                    <a href="#"><p class="ename">Adidas Yeezy Boost 750 OG Light Brown</p></a>
                                    <p class="kname">아디다스 이지 부스트 750 OG 라이트 브라운</p>
                                    <h3><a href="#">4,000,000원</a></h3>
                                </div>
                            </div>     
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/M992JJ.png" alt="menu1이미지" style="background:#FFF0F0"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">NEW BALANCE</p></a>
                                    <a href="#"><p class="ename">New Balance x JJJJound 992 Made in USA Mossy Green</p></a>
                                    <p class="kname">뉴발란스 x JJJ자운드 992 메이드 인 USA 모시 그린</p>
                                    <h3><a href="#">1,700,000원</a></h3>
                                </div>
                            </div>     
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/DD1503-100.png" alt="menu1이미지"  style="background:#FAFAD2"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">NIKE</p></a>
                                    <a href="#"><p class="ename">(W) Nike Dunk Low Coast</p></a>
                                    <p class="kname">(W) 나이키 덩크 로우 코스트</p>
                                    <h3><a href="#">500,000원</a></h3>
                                </div>
                            </div>       
                            <div class="product">
                                <a href="#"><img src="resources/img/p_img/DD1503-101.png" alt="menu1이미지" style="background:#FAFAD2"></a>
                                <div class="product_info">
                                    <a href="#"><p class="brand">NIKE</p></a>
                                    <a href="#"><p class="ename">(W) Nike Dunk Low Black</p></a>
                                    <p class="kname">(W) 나이키 덩크 로우 블랙</p>
                                    <h3><a href="#">350,000원</a></h3>
                                </div>
                            </div>
                        </div>    
                    </div>        
                </li>    
                <li id="tab3" class="btnCon">
                    <input type="radio" name="tabmenu" id="tabmenu3">
                    <label for="tabmenu3">BRAND</label>
                    <div class="tabCon" >내용3</div>        
                </li>
                <li id="tab4" class="btnCon">
                    <input type="radio" name="tabmenu" id="tabmenu4">
                    <label for="tabmenu4">menu4</label>
                    <div class="tabCon" >내용4</div>        
                </li>
            </ul>
        </div>
    </section>

    <!-- ================================= tabmenu END ================================= -->
    <section class="box">
        <div id="video_box">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/3KObylIFm-c?rel=0&amp;autoplay=1&amp;mute=1&amp;vq=hd720&amp;playlist=3KObylIFm-c&loop=1&modestbranding=1;" frameborder="0" allowfullscreen></iframe>
        </div>
    </section>
	
	<!-- ================================= draw START ================================= -->
	
	<section class="box2">
	    <div class="drawbox">
	        <h3>DRAW</h3>
	        <div class="d_box">
	            <a href="draw.html"><img src="resources/img/p_img/CW5379-600.png" alt="menu1이미지" style="background:#FAFAD2"></a>
	            <div class="text">1월 25일<br/><span>am 10:00</span></div>
	            <div class="timer">
	                <div class="js-clock">
	                <h3 class="timer1"></h3>
	                </div>
	            </div> 
	            <div class="draw_info">
	                <p class="brand">NIKE</p>
	                <p class="ename">(W) Jordan 1 Mid Digital Pink</p>
	                <p class="kname">(W) 조던 1 미드 디지털 핑크</p>
	                <p class="text2">COMING SOON</p>
	            </div>
	        </div>    
	        <div class="d_box">
	            <a href="draw.html"><img src="resources/img/p_img/BY9612.png" alt="menu1이미지" style="background:#F0FFF0"></a>
	            <div class="text">1월 26일<br/><span>am 10:00</span></div>
	            <div class="timer">
	                <div class="js-clock2">
	                <h3 class="timer2"></h3>
	                </div>
	            </div>
	            <div class="draw_info">
	                <p class="brand">ADIDAS</p>
	                <p class="ename">Adidas Yeezy Boost 350 V2 Core Black Red</p>
	                <p class="kname">아디다스 이지 부스트 350 V2 코어 블랙 레드</p>
	                <p class="text2">COMING SOON</p>
	            </div>
	        </div>    
	        <div class="d_box">
	            <a href="draw.html"><img src="resources/img/p_img/M992WT.png" alt="menu1이미지"  style="background:#FFF0F0"></a>
	            <div class="text">1월 27일<br/><span>am 10:00</span></div>
	            <div class="timer">
	                <div class="js-clock3">
	                <h3 class="timer3"></h3>
	                </div>
	            </div> 
	            <div class="draw_info">
	                <p class="brand">NEW BALANCE</p>
	                <p class="ename">New Balance x WTAPS 992 Made in USA Olive</p>
	                <p class="kname">뉴발란스 x 더블탭스 992 메이드 인 USA 올리브</p>
	                <p class="text2">COMING SOON</p>
	            </div>
	        </div>
	        <script src="resources/js/timer.js"></script>
	    </div>        
	</section>
	
	<!-- ================================= draw END ================================= -->
	
	<!-- ================================= sale START ================================= -->
	
	<section class="box2">
	    <div class="salebox">
	        <div class="s_box">
	            <a href="#"><img src="resources/img/p_img/CW5379-600.png" alt="menu1이미지" style="background:#FAFAD2"></a>
	            <div class="sale_info">
	                <a href="#"><p class="brand">NIKE</p></a>
	                <a href="#"><p class="ename">(W) Jordan 1 Mid Digital Pink</p></a>
	                <p class="kname">(W) 조던 1 미드 디지털 핑크</p>
	                <p class="bef_price">269,000원</p>
	                <a href="#"><p class="aft_price">188,300원</a><span>-30%</span></p>
	            </div>
	        </div>    
	        <div class="s_box">
	            <a href="#"><img src="resources/img/p_img/BY9612.png" alt="menu1이미지" style="background:#F0FFF0"></a>
	            <div class="sale_info">
	                <a href="#"><p class="brand">ADIDAS</p></a>
	                <a href="#"><p class="ename">Adidas Yeezy Boost 350 V2 Core Black Red</p></a>
	                <p class="kname">아디다스 이지 부스트 350 V2 코어 블랙 레드</p>
	                <p class="bef_price">269,000원</p>
	                <a href="#"><p class="aft_price">188,300원</a><span>-30%</span></p>
	            </div>
	        </div>    
	        <div class="s_box">
	            <a href="#"><img src="resources/img/p_img/M992WT.png" alt="menu1이미지"  style="background:#FFF0F0"></a>
	            <div class="sale_info">
	                <a href="#"><p class="brand">NEW BALANCE</p></a>
	                <a href="#"><p class="ename">New Balance x WTAPS 992 Made in USA Olive</p></a>
	                <p class="kname">뉴발란스 x 더블탭스 992 메이드 인 USA 올리브</p>
	                <p class="bef_price">269,000원</p>
	                <a href="#"><p class="aft_price">188,300원</a><span>-30%</span></p>
	            </div>
	        </div>
	        <h3>SALE</h3>
	    </div>        
	</section>
	
	<!-- ================================= sale END ================================= -->

    <section class="box">
        <div id="img_box">
            <a href="#">
                <img src="resources/img/aboutedt.png" alt="">
            </a>

    </section>




    <%@include file="footer.jsp"%>
</body>
</html>