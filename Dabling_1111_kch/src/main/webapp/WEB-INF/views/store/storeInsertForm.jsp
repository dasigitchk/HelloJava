<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
	<!-- 일단 등록기능만구현 보완하여 승인한뒤 사용하게 만들것. -->
	<h3>매장 등록사이트.</h3>

	<form id="frm" action="storeInsert.do" method="post" enctype="multipart/form-data">
		<div>
			<label>사업자번호</label><input type="text" id="businessNum" name="businessNum" required="required"><br>
			<label>상호명</label><input type="text" id="storeName" name="storeName" required="required"><br>
			<label>지역명</label><input type="text" id="storeRegion" name="storeRegion" required="required"><br>
 			<label>카테고리</label><input type="text"id="storeCategory" name="storeCategory" required="required"><br>
			<label>상세설명</label><input type="text" id="storeInfo" name="storeInfo" required="required"><br>
			<label>위도</label><input type="text" id="lat" name="lat" required="required"><br>
			<label>경도</label><input type="text" id="lng" name="lng" required="required"><br>
			<label>대표이미지</label><input type="file" id="storeImage" name="storeImage" ><br>
			<label>주소</label><input type="text" id="storeAddress" name="storeAddress" required="required"><br>
			<input type="submit" value="신청" >&nbsp;&nbsp; 
			<input type="reset" value="취소">
		</div>

	</form>



</body>

</html>