<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>매장관리 페이지</h3>
<div align="center">
	<div><h1>매장 목록 보기</h1></div>
	<div>
		<c:forEach items="${stores }" var="s">
		 	${s.storeCode } : ${s.storeName } : ${${s.storeRegion } : ${s.storeCategory } : ${s.storeInfo } : ${s.lat } : ${s.lng } : ${s.storeImage } : ${s.storeAddress }<br/> 		
		</c:forEach>
	</div>
</div>
</body>
</html>