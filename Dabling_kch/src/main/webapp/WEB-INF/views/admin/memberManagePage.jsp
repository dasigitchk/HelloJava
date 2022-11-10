<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberManageForm</title>
</head>
<body>
<div align="center">
	<div><h1>회원 목록 보기</h1></div>
	 <div>회원검색:<input type="text" name="memberCode" value="회원번호를 입력하세요.."/></div>
	<div>
		<c:forEach items="${members }" var="m">
		 	${m.memberCode } : ${s.email } : ${${s.password } : ${s.name } : ${s.phone } : ${s.businessNum } : ${s.author }<br/> 		
		</c:forEach>
	</div>	
</div>
</body>
</html>