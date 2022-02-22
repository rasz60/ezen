let joinCheck = false;

$(function pwdCheck() {
	$("#pwdCheck").on("keyup", function() {
		var pwd = $("#pwd").val();
		var value = $(this).val();
		if ( pwd === value ) {
			$("#pwdCheckStatus").text("비밀번호가 일치합니다.").css("color","blue");
		} else if ( pwd == "" ) {
			$("#pwdCheckStatus").text("비밀번호 입력란을 먼저 입력해주세요.").css("color","red");
		} else {
			$("#pwdCheckStatus").text("비밀번호가 일치하지 않습니다.").css("color","red");
		}
	});
});

$(function pwdCheck() {
	$("#pwdCheck").on("keyup", function() {
		var pwd = $("#pwd").val();
		var value = $(this).val();
		if ( pwd === value ) {
			$("#pwdCheckStatus").text("비밀번호가 일치합니다.").css("color","blue");
		} else if ( pwd == "" ) {
			$("#pwdCheckStatus").text("비밀번호 입력란을 먼저 입력해주세요.").css("color","red");
		} else {
			$("#pwdCheckStatus").text("비밀번호가 일치하지 않습니다.").css("color","red");
		}
	});
});
