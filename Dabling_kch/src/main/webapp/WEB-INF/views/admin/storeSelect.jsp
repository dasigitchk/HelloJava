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
	<div><h1>메장 선택 보기</h1></div>
		 <p>매장번호: ${store.storeCode }, 매장이름: ${store.storeName }, 지역: ${store.storeRegion }, 카테고리: ${store.storeCategory }, 매장설명: ${store.storeInfo }, 위도: ${store.lat }, 경도: ${store.lng }, 매장사진: ${store.storeImage }, 주소: ${storeAddress }, 사업자번호: ${store.businessNum }</p><br/> 		
	</div>	
</div>
</body>
</html>