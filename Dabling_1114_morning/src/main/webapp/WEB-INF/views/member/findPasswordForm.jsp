<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<style>
.searchForm {
	margin-top: 80px;
}

#saveNum {
	display : none;
}
</style>
</head>

<body>
	<main>

		<div class="searchForm" align="center">
			<form id="searchForm" >
				<div class="input">
					<span>찾으시는 계정을 입력하세요</span><br> <input type="email" id="email"
						name="email" placeholder="Email" required="required" />
					<input type="button" id="btn" value="조회" onclick="emailCheck()"></input>
					<br> <input id="result" readonly>
				</div>
				<br>
				<div id="messagefrm" style="display: none;">
					<p>계정으로 임시비밀번호를 전송하였습니다.</p>
				</div>
				<div>
					<input type="button" id="sendEmail" value="비밀번호 메일전송" onclick="emailSend()">
					<button id="saveNum" value="1"></button>
					<!-- 인증번호를 임시저장할 가짜버튼 -->
					<input type="button" value="홈 가기" onclick="location.href='main.do'">
				</div>
			</form>
		</div>
	</main>

	<script type="text/javascript">
		function emailCheck() { // 이메일 조회하고 보여주게 하기
			let email = document.getElementById('email').value;
			let url = "ajaxEmailFind.do?email=" + email;
			fetch(url)
				.then(response => response.text())
				.then(data => { // 결과처리 함수
					if (data == '0') {
						num = email.indexOf('@');
						str = email.substring(3, num);
						result = email.replace(str, '***');
						document.getElementById('result').value = result + "계정이 존재합니다.";
					} else {
						document.getElementById('result').value = email + "는 존재하지 않는 계정입니다.";
						document.getElementById('email').value = "";
						document.getElementById('email').focus();
					}
				});
			}
		
		function emailSend() {
			alert("임시비밀번호 메일이 발송중입니다.");
			let email = document.getElementById('email').value;
			let url = "sendEmail.do?email=" + email;
			console.log(email);
			
			fetch(url)
				.then(response => response.text())
				.then(data => { // 결과처리 함수
					console.log(data);
					if(data != "failed"){
						alert("임시비밀번호 메일이 발송되었습니다");
						searchForm.emailCheck.disabled=true;
						searchForm.saveNum.value=data;
					}else{
						alert("발송에 실패했습니다. 잠시 후 다시 시도해주세요");
					}
				})
		}
	</script>
</body>

</html>