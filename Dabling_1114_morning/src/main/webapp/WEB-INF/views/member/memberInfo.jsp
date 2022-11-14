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
<title>내정보 조회</title>
</head>
<body>
	<div class="form" align="center">
		<div>
			<h1>내정보 조회</h1>

		</div>
		<div>
			<table border="1">
				<tr>
					<th width="150">회원코드</th>
					<td>${memberCode }</td>
				</tr>
				<tr>
					<th width="150">이메일</th>
					<td>${email }</td>
				</tr>
				<tr>
					<th width="150">이름</th>
					<td>${name }</td>
				</tr>
				<tr>
					<th width="150">전화번호</th>
					<td>${phone }</td>
				</tr>



			</table>

			<input type="button" value="홈 가기" onclick="location.href='main.do'">
			<input type="button" value="내정보 수정" onclick="location.href='memberInfoUpdateForm.do'">
		</div>
	</div>
</body>
</html>