<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#frm {
		margin-top: 80px; 
	}
</style>
</head>
<body>
	<div align="center"></div>
	<div>회원검색</div>
			<form id="frm" action="./memberSelect.do" method="get"> 	
			<table border="1">
			<tr>
				<th width="150">회원번호 검색</th>
				<td width="230"><input type="text" id="memberCode" required="required">&nbsp;&nbsp;
					<input type="hidden" name="job" value="update">
					<button type="submit" value="update">검색</button>
			</form>
						<form id="frm2" action="./memberUpdate.do" method="post">
							회원번호:  <input type="text" name="email" value="${memberCode } " readonly>
							이메일: <input type="text" name="email" value="${email} "><br> 
							비밀번호: <input type="text" name="password" value="${password} "><br>
							이름: <input type="text" name="name" value="${name }"><br>
							전화번호: <input type="text" name="phone" value="${phone }"><br>
							사업자번호: <input type="text" name="businessNum" value="${businessNum }"><br>
							권한: <input type="number" name="author" value="${author }"><br>
							<input type="submit" value="수정">
						</form>
			</tr>
		</table>
</body>
</html>