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
	
 <h3>멤버정보조회</h3>
    <form id="frm" action="memberSelect.do" onsubmit="return formSubmit()" method="get">
       회원번호: <input type="number" name="memberCode"><br>
        <input type="hidden" name="job" value="memberUpdate">
        <input type="submit" value="조회">
    </form>
						<form id="frm2" action="memberUpdate.do" method="post">
							회원번호:  <input type="text" name="newMemberCode" value="${member.memberCode }" readonly><br>
							이메일: <input type="text" name="email" value="${member.email}"><br> 
							비밀번호: <input type="text" name="password" value="${member.password}"><br>
							이름: <input type="text" name="name" value="${member.name }"><br>
							전화번호: <input type="text" name="phone" value="${member.phone }"><br>
							사업자번호: <input type="text" name="businessNum" value="${member.businessNum }"><br>
							권한: <input type="number" name="author" value="${member.author }"><br>
							<input type="submit" value="수정">
						</form>
			</tr>
		</table>
</body>
</html>