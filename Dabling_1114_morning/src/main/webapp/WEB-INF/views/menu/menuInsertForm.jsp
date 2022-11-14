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
		<h3>메뉴등록 페이지입니다.</h3>

	<form id="frm" action="menuInsert.do" method="post" enctype="multipart/form-data">
		<div>
			<label>메뉴명</label><input type="text" id="menuName" name="menuName" required="required"><br>
			<label>대표이미지</label><input type="file" id="menuImage" name="menuImage" ><br>
			<label>가격</label><input type="text" id="price" name="price" required="required"><br>
			<input type="submit" value="추가" >&nbsp;&nbsp; 
			<input type="reset" value="취소">
		</div>

	</form>

	
</body>
</html>