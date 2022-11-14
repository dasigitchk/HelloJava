<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div>회원선택조회</div>
	<form id="frm" action="memberSelect.do" onsubmit="return formSubmit()" method="post">
		<table border="1">
			<tr>
				<th width="150">회원번호검색</th>
				<td width="230"><input type=number id="memberCode" name="memberCode"  required="required">&nbsp;&nbsp;
					<button type="submit">검색</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>