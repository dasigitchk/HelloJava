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
	form{
		margin: 50px;
	}
	label{
		width:100px;
	}
	lnput{
		width:300px;
	}
	button{
		text-align: center;
	}
	</style>
</head>
<body>
	<h3>매장 마이페이지</h3>
	<div>
		<form action="storeMyPage.do" method="get"></form>
		<label>사업자번호</label><input type="text" id="businessNum" name="businessNum" value="${store.businessNum }" required="required"><br>
		<label>상호명</label><input type="text" id="storeName" name="storeName" value="${store.storeName }" required="required"><br>
		<label>지역명</label><input type="text" id="storeRegion" name="storeRegion" value="${store.storeRegion }" required="required"><br>
		<label>카테고리</label><input type="text" id="storeCategory" name="storeCategory" value="${store.storeCategory }" required="required"><br>
		<label>상세설명</label><input type="text" id="storeInfo" name="storeInfo" value="${store.storeInfo }"  required="required"><br>
		<label>위도</label><input type="text" id="lat" name="lat" value="${store.lat }" required="required"><br>
		<label>경도</label><input type="text" id="lng" name="lng" value="${store.lng }" required="required"><br>
		<label>대표이미지</label><input type="file" id="storeImage" value="${store.storeImage }" name="storeImage" required="required"><br>
		<label>주소</label><input type="text" id="storeAddress" value="${store.storeAddress }" name="storeAddress" required="required"><br>
		<input type="submit" value="수정" job="update" >&nbsp;&nbsp; 
		<input type="submit" value="탈퇴" job="delete">
	
	</div>


</body>
</html>