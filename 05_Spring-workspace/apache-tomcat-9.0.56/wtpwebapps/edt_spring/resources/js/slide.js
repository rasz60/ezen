
            var slideBox = document.getElementById('img_slide');
            var slideIndex = 1;
            var slideCount = document.querySelectorAll('.slides').length;

            /*이미지 슬라이드 이동 함수*/
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
            }

            /* 슬라이드를 정지했다가 다시 3.5초 후 자동 이동하는 함수 */
            function resetSlideTime() {
                stopSlide();
                autoSlide();
            };

            /* 페이지 접속하면 autoSlide() 실행 */
            autoSlide();
