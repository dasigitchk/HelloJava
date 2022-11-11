<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.form {
	margin-top: 80px;
}
</style>
<title>내정보 조회</title>
</head>
<body>
	<div align="center">
		<div class="form">
			<h1>회원정보수정</h1>
			<div>
				<form id="frm" action="memberInfoUpdate.do" onsubmit="return formSubmit()" method="post">
					<div>
						<table border="1">
							<tr>
								<th>패스워드</th>
								<td><input type="password" id="passwd" required="required"
									name="passwd"></td>
							</tr>
							<tr>
								<th>패스워드확인</th>
								<td><input type="password" id="passwd1" required="required"
									name="passwd1"></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" id="name" name="name"
									required="required"></td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><input type="text" id="phone" name="phone"
									required="required"></td>
							</tr>
							<tr>
								<th>사업자번호</th>
								<td><input type="text" id="businessNum" name="businessNum"
									required="required"></td>
							</tr>
						</table>
					</div>
					<br />
					<div>
						<input type="submit" value="회원정보수정하기">&nbsp;&nbsp; <input
							type="reset" value="취소">&nbsp;&nbsp;
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function formSubmit() {
			if (frm.passwd.value != frm.passwd1.value) {
				alert("패스워드가 일치하지 않습니다.")
				frm.passwd.value = "";
				frm.passwd1.value = "";
				frm.passwd.focus();
				return false;
			}
			return true;

	</script>
</body>
</html>