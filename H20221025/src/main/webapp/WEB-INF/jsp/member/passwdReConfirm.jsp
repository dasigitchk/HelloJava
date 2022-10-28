<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재전송</title>
</head>
<body>
	<h3>비밀번호 재전송</h3>
	<form action="./passwdReConfirm.do" method="post">
	아이디: <input type="text" name="id">
	<input type="submit" value="이메일발송">
	<input type="reset" value="초기화">
	</form>
</body>
</html>