<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>storeMyPage</title>
<style>
	h3{
		margin-top: 80px; 
	}
</style>
</head>
<body>
	<h3>매장 마이페이지</h3>
	<div>
		<form action="storeMyPage.do" method="get"></form>
		<label>상호명</label><input type="text" id="storeName" name="storeName" value="${storeName }" required="required"><br>
		<label>지역명</label><input type="text" id="storeRegion" name="storeRegion" value="${storeRegion }" required="required"><br>
		<label>카테고리</label><input type="text" id="storeCategory" name="storeCategory" value="${storeCategory }" required="required"><br>
		<label>상세설명</label><input type="text" id="storeInfo" name="storeInfo" value="${storeInfo }"  required="required"><br>
		<label>위도</label><input type="text" id="lat" name="lat" value="${lat }" required="required"><br>
		<label>경도</label><input type="text" id="lng" name="lng" value="${lng }" required="required"><br>
		<label>대표이미지</label><input type="file" id="storeImage" value="${storeImage }" name="storeImage" required="required"><br>
		<label>주소</label><input type="text" id="storeAddress" value="${storeAddress }" name="storeAddress" required="required">
		<!-- 수정, 탈퇴버튼 추가하기. -->
		<!-- 값/이미지 확인하기. -->
	
	</div>


</body>
</html>