<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Join</title>
	<style>
		.form {
			margin-top: 80px;
		}
	</style>
</head>

<body>
	<main>
		<div align="center">
			<form class="form" action="memberJoin.do" onsubmit="return formSubmit()" method="post">
				<fieldset>
					<legend>가입 유형을 선택해 주세요</legend>
					<input type='radio' name='member' value='normal' checked="checked"
						onchange="setDisplay()" />일반회원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='radio' name='member' value='business' onchange="setDisplay()" />사업자회원

				</fieldset>
				<fieldset>
					<legend>로그인 정보</legend>
					<ol>
						<li>
							<label for="email">아이디</label>
							<input id="email" name="email" type="text" placeholder="Email" equired autofocus>
							<button type="button" id="btn" value="No" onclick="idCheck()">중복체크</button>
						</li>
						<li>
							<label for="password">비밀번호</label>
							<input id="password" name="password" type="password" required>
						</li>
						<li>
							<label for="password1">비밀번호 확인</label>
							<input id="password1" name="password1" type="password" required>
						</li>
					</ol>
				</fieldset>

				<fieldset>
					<legend>개인 정보</legend>
					<ol>
						<li>
							<label for="name">이름</label>
							<input id="name" name="name" type="text" required>
						</li>
						<li>
							<label for="phone1">연락처</label>
							<input type='tel' name='phone1' />-
							<input type='tel' name='phone2' />-
							<input type='tel' name='phone3' />
						</li>
						<li>
							<label for="name">이름</label>
							<input id="name" name="name" type="text" required>
						</li>
					</ol>
				</fieldset>
				<div id="businessInfo">
					<fieldset>
						<legend>사업자 정보</legend>
						<ol>
							<li>
								<label for="businessNum">사업자번호</label>
								<input id="businessNum" name="businessNum" type="text" required>
							</li>
						</ol>
					</fieldset>
				</div>
				<br />
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp; <input type="reset" value="취소">
				</div>
			</form>
		</div>
	</main>
	<script type="text/javascript">
		function setDisplay() {
			if ($('input:radio[id=business]').is(':checked')) {
				$('#businessInfo').show();
			} else {
				$('#businessInfo').show();
			}
		}

		function formSubmit() {
			if (form.btn.value == 'No') {
				alert("아이디 중복체크를 해주세요..");
				return false;
			}
			if (form.password.value != frm.password1.value) {
				alert("패스워드가 확인값과 일치 하지 않습니다.");
				form.password.value = "";
				form.password1.value = "";
				form.password.focus();
				return false;
			}
			return true;
		}

		function idCheck() { // 아이디 중복체크
			let email = form.email.value;
			let url = "ajaxEmailCheck.do?email=" + email;
			fetch(url)
				.then(response => response.text())
				.then(data => { // 결과처리 함수
					if (data == '1') {
						alert(id + "는 사용가능한 메일입니다.");
						form.password.focus();
						form.btn.value = 'Yes';
					} else {
						alert(email + "는 이미 사용중인 메일입니다.");
						form.email.value = "";
						form.email.focus();
					}
				});
		}
	</script>
</body>

</html>