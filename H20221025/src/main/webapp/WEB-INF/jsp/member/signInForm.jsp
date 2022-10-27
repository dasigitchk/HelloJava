<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면(signInForm)</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="./signIn.do" method="post">
	아이디: <input type="text" name="id">
	패스워드: <input type="text" name="passwd"><br>
	<input type="submit" value="로그인">
	<input type="reset" value="초기화">
	</form>
</body>
</html>