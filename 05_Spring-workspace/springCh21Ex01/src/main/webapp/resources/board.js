
// writeForm.jsp : input value count method
$(document).ready(function() {
	$("#bName").keyup(function(e) {
		var content1 = $(this).val();
		$('#bNameCount').text("(" + content1.length + " / 20)");	
		if (content1.length > 20) {
			alert("최대 20자까지 입력 가능합니다.");
			$(this).val(content1.substring(0, 20));
		}
	})
	
	$("#bTitle").keyup(function(e) {
		var content2 = $(this).val();
		$('#bTitleCount').text("(" + content2.length + " / 100)");
		if (content2.length > 100) {
			alert("최대 100자까지 입력 가능합니다.");
			$(this).val(content2.substring(0, 100));
		}
	})
		
	$("#bContent").keyup(function(e) {
		var content3 = $(this).val();
		$('#bContentCount').text("(" + content3.length + " / 300)");
		if (content3.length > 300) {
			alert("최대 300자까지 입력 가능합니다.");
			$(this).val(content3.substring(0, 300));
		}	
	})
});



//writeForm.jsp : submit check method
function checkWrite() {
	if(document.form.bName.value.length == 0 || document.form.bName.value.length > 20) {
		alert("작성자명을 20자내로 입력하세요.");
		document.form.bName.focus();
		return false;
	} 

	if(document.form.bTitle.value.length == 0 || document.form.bTitle.value.length > 100) {
		alert("제목을 100자내로 입력하세요.");
		document.form.bTitle.focus();
		return false;
	}
	
	if(document.form.bContent.value.length == 0 || document.form.bContent.value.length > 300) {
		alert("내용을 300자내로 입력하세요.");
		document.form.bContent.focus();
		return false;
	}
	return true;
};




// list.jps : post count method
$(document).ready(function() {
	let count = $('#boardTable tr:nth-child(2) td:nth-child(1)').text();
	$('#postCount').text("총 "+count+"개");
});




//