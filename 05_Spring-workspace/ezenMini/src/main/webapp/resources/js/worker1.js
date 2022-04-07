let i = 0;

function timedCount() {
	i += 1;
	//window의 postMessage method로 worker객체에 메세지를 전달해서 messageEvent를 발생시킴
	postMessage(i);
	
	// timedCount() 함수를 0.5초 후에 실행
	setTimeout('timedCount()', 500);
}

// 0.5초마다 반복되도록 실행
timedCount();