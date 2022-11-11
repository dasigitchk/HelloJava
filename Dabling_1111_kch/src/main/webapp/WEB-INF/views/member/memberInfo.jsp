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
			<c:forEach items="${list }" var="a">	
				${a.memberCode}  ${a.email } : ${a.password }: ${a.email }: ${a.name }: ${a.phone } : ${a.businessNum } : ${a.author }
				<br />
			</c:forEach>
			<input type="button" value="홈 가기" onclick="location.href='main.do'">
		</div>
	</div>
</body>
</html>