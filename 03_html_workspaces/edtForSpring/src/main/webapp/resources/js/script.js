/*=====================================Product Detail.html=====================================*/
/* size + 버튼 눌렀을 때 사이즈 선택 박스가 보이고 다시 누르면 사라지는 function */
$(function() {
    $("#p_size span").on("click", function() {
        if($("#size_detail").is(":visible") == false) {
            $("#size_detail").css({"display":"block"});
        } else {
            $("#size_detail").css({"display":"none"});
        };
    });
});


/* 
사이즈 선택 박스에서 사이즈를 골랐을 때
1) #check에 선택한 사이즈 text 가져오기
2) 선택된 사이즈 칸의 배경색(black), 글씨색(white) 변경
3) 선택된 사이즈가 아닌 칸의 나머지는 원래 색으로 변경
*/
$(function() {
    $(".size td").on("click", function() {
        var size = $(this).text();
        $("#check").text(size).css({"color":"blue"});
        $(this).css({"background-color":"black", "color":"white"});
        $(".size td").not(this).css({"background-color":"transparent", "color":"black"});
    });
});


/* 사이즈 선택 박스에서 x 버튼을 눌렀을 때, #check에 표시한 text와 사이즈 박스 선택도 초기화 */
$(function() {
    $("#cancel_size").on("click", function() {
        $("#check").text("");
        $(".size td").css({"background-color":"transparent", "color":"black"});
    });
});


/* 
사이즈 선택 박스에서 choose 버튼을 눌렀을 때
1) #size_detail 박스 사라지게 하기
2) #check에 text 가져와서 #p_size에 표시
3) Size text와 size + 버튼 사이 margin-right 조정 (5% -> 23%)
*/
$(function() {
    $("#size_btn #submit").on("click", function() {
        var size = $("#check").text();
        if ( size == "" ) {
            $("#p_size div:nth-child(2)>p>b").text("Ur Size");
            $("#p_size div:nth-child(2)>p").css({"margin-right":"5%"});
            $("#size_detail").css({"display":"none"});
        } else {
            $("#p_size div:nth-child(2)>p>b").text(size);
            $("#p_size div:nth-child(2)>p").css({"margin-right":"25%"});
            $("#size_detail").css({"display":"none"});
        }
    });
});


/* 
사이즈 선택 박스에서 cancel 버튼을 눌렀을 때
1) #size_detail 박스 사라지게 하기
2) #p_size에 text와 margin-right(23% -> 5%) 원상 복귀
3) #check에 표시되어있던 size와 size 박스 선택 풀기 
*/
$(function() {
    $("#size_btn #cancel").on("click", function() {
            $("#size_detail").css({"display":"none"});
            $("#p_size div:nth-child(2)>p>b").text("Ur Size");
            $("#p_size div:nth-child(2)>p").css({"margin-right":"5%"});
            $("#check").text("");
            $(".size td").css({"background-color":"transparent", "color":"black"});

    });
});


/* #rules 박스에 드롭단추 누르면 세부내용 나오게 하기 */
$(function dropRule() {
    $(".default span").on("click", function() {
        if( $(this).parent().next().is(":visible") == false) {
            $(this).css({"transform":"rotate(0deg)"});
            $(this).parent().next().css({"display":"block"});                            
        } else {
            $(this).css({"transform":"rotate(180deg)"});
            $(this).parent().next().css({"display":"none"});
        };
    });
});

/* #hit 버튼 누르면 카운트++, 배경색 바뀜 */
var count = 0;
$(function hit_click() {
    var hitCount = parseInt($("#hit small").text());
    $("#hit").on("click", function() {
        count++;
        if( count % 2 == 1 ) {
            $(this).css({"background-color":"#ec6810"});
            $("#hit span").text("♥");
            $("#hit small").text(++hitCount);
        } else {
            $(this).css({"background-color":"#ED853F"});
            $("#hit span").text("♡");
            $("#hit small").text(--hitCount);
        }
    });
});

/*=====================================Products.html=====================================*/
/*
1) 전부 다 anchor tag로 바꾸고, data-value에 parameter를 넣어둔다.
2) 클릭 이벤트가 일어나면, data-value를 조합하여 href를 동적으로 부여한다.
3) 기준은 1_brand 2_gender 3_filter

fetch("products").then(function(response) {
	response.text().then(function(text) {
		$("#prod").innerHTML = text;
	});
});
*/



/* filter, gender 누르면 정렬 바뀌기 */

/*
	1) .chck_gender와 .filter class 객체를 배열로 저장하여 각 인덱스의 addEventListener("click") 생성
	2) 사용자 지정 속성인 data-value에 있는 값을 가져와서 url에 parameter 로 추가한 후 해당 url로 window 새로 열기
*/

$(function() {
	$(".chck_gender").click(function() {
		var url = new URL(location);
		url.searchParams.set("gender", this.getAttribute("data-value"));
	});
	
	$(".filter").click(function() {
		var url = new URL(location);
		url.searchParams.set("filter", this.getAttribute("data-value"));
	});
	
	$.ajax({ type: "POST", url: "/products.jsp"});

});

/* filter, brand 값에 맞는 버튼의 글씨색/두께 바꾸기 */

/*
	1) document가 load되면 현재 url을 읽어와서 url객체로 저장
	2) url객체의 searchParams.has("parameter") 메서드를 이용하여 입력한 parameter가 존재하는지를 변수 check에 저장
	3) 해당 parameter가 존재하는 경우, searchParams.get("parameter") 메서드로 해당 parameter의 value를 value변수에 저장
	4) switch문으로 value값에 따른 css 속성을 변경해주는 값을 넣어줌
*/
$(function setPage() {
    var url = new URL(window.location);
	var check1 = url.searchParams.has("filter");
	var check2 = url.searchParams.has("brand");
	let value1, value2;
	
	if ( check1 == true ) {
		value1 = url.searchParams.get("filter");
	}

	if ( check2 == true ) {
		value2 = url.searchParams.get("brand");
	}
	
	switch(value1) {
		case "p_date" :
			$(".filter:nth-of-type(1)").css({"color":"black" , "font-weight":"700", "text-decoration":"underline"});
			break;
		case "p_hit DESC" :
			$(".filter:nth-of-type(2)").css({"color":"black" , "font-weight":"700", "text-decoration":"underline"});
			break;
		case "p_price" :
			$(".filter:nth-of-type(3)").css({"color":"black" , "font-weight":"700", "text-decoration":"underline"});
			break;
		case "p_price DESC" :
			$(".filter:nth-of-type(4)").css({"color":"black" , "font-weight":"700", "text-decoration":"underline"});
			break;
	}

	switch(value2) {
		case "'JORDAN'" :
			$(".brand_menu:nth-of-type(2)").css("background-color","black").animate({opacity:"0.6"}, 800);
			$(".brand_menu:nth-child(2)>a").css({"color":"white", "fontSize":"+=0.1em"}).animate({fontSize:"-=0.1em"}, 800);
			break;
		case "'NIKE'" :
			$(".brand_menu:nth-of-type(3)").css("background-color","black").animate({opacity:"0.6"}, 800);
			$(".brand_menu:nth-child(3)>a").css({"color":"white", "fontSize":"+=0.1em"}).animate({fontSize:"-=0.1em"}, 800);
			break;
		case "'ADIDAS'" :
			$(".brand_menu:nth-of-type(4)").css("background-color","black").animate({opacity:"0.6"}, 800);
			$(".brand_menu:nth-child(4)>a").css({"color":"white", "fontSize":"+=0.1em"}).animate({fontSize:"-=0.1em"}, 800);
			break;
		case "'NEW BALANCE'" :
			$(".brand_menu:nth-of-type(5)").css("background-color","black").animate({opacity:"0.6"}, 800);
			$(".brand_menu:nth-child(5)>a").css({"color":"white", "fontSize":"+=0.1em"}).animate({fontSize:"-=0.1em"}, 800);
			break;
		default :
			$(".brand_menu:nth-of-type(1)").css("background-color","black").animate({opacity:"0.6"}, 800);
			$(".brand_menu:nth-child(1)>a").css({"color":"white", "fontSize":"+=0.1em"}).animate({fontSize:"-=0.1em"}, 800);
			break;
	}
});