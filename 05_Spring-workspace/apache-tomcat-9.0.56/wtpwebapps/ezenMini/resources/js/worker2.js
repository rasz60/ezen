onmessage = function(e) {
	let num = e.data;
	let result = 0;
	
	for( var i = 1; i <= num; i++ ) {
		result += i;
	}

	postMessage(result);
}