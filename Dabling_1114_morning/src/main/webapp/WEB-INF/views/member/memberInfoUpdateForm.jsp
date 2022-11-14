<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.form {
	margin-top: 80px;
}
</style>
</head>
<body>

	<div>
		<div align="center">
			<form class="form" action="memberInfoUpdate.do"
				onsubmit="return formSubmit()" method="post">
				<h1>내정보 수정</h1>
				<table border="1">
					<tr>
						<th width="150">회원코드</th>
						<td><input type="text" id="memberCode" name="memberCode"
							value=${memberCode } disabled></td>
					</tr>
					<tr>
						<th width="150">이메일</th>
						<td><input type="email" id="email" name="email"
							value=${email } disabled></td>
					</tr>
					<th width="150">비밀번호</th>
					<td><input id="password" name="password" type="password"
						required autofocus></td>
					<br>
					<tr>
						<th width="150">비밀번호확인</th>
						<td><input id="password1" name="password1" type="password"
							required><br></td>
					</tr>
					<tr>
						<th width="150">이름</th>
						<td><input type="text" id="name" name="name" value=${name }
							disabled></td>
					</tr>
					<tr>
						<th width="150">전화번호</th>
						<td><input id="phone" name="phone" type="text" required></td>
					</tr>


				</table>
				<input type="submit" value="수정하기"> <input
					type="reset" value="취소">
			</form>


		</div>
	</div>
	<script type="text/javascript">
		function formSubmit() {
			if (document.getElementById('password').value != document
					.getElementById('password1').value) {
				alert("패스워드가 확인값과 일치 하지 않습니다.");
				document.getElementById('password').value = "";
				document.getElementById('password1').value = "";
				document.getElementById('password').focus();
				return false;
			}

			return true;
		}
	</script>
</body>
</html>
