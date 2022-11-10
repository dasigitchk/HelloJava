<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		margin-top: 80px;
	}
</style>
</head>
<body>
<div align="center">
	<div><h1>회원 선택 보기</h1></div>
		 <p>회원번호: ${member.memberCode }, 이메일: ${member.email }, 비밀번호: ${member.password }, 이름: ${member.name }, 전화번호: ${member.phone }, 사업자번호: ${member.businessNum }, 권한: ${member.author }</p><br/> 		
	</div>	
</div>
</body>
</html>