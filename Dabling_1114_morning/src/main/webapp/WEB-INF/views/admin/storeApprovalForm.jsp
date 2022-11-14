<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	width: 1700px;
}

#stores {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#stores td, #stores th {
	border: 1px solid #ddd;
	padding: 8px;
}

#stores tr:nth-child(even) {
	background-color: #f2f2f2;
}

#stores tr:hover {
	background-color: #ddd;
}

#stores th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
	<div align="center">
		<h1>매장등록대기목록</h1>
	</div>

	<table id="stores">
		<tr>
			<th>매장번호</th>
			<th>매장이름</th>
			<th>매장지역</th>
			<th>매장분류</th>
			<th>매장설명</th>
			<th>매장주소</th>
			<th>사업자등록번호</th>
			<th>승인상태</th>
			<th>비고</th>
		</tr>
		<c:forEach items="${stores }" var="s" varStatus="status">
			<tr>
				<td>${s.storeCode }</td>
				<td>${s.storeName }</td>
				<td>${s.storeRegion }</td>
				<td>${s.storeCategory }</td>
				<td>${s.storeInfo }</td>
				<td>${s.storeAddress }</td>
				<td>${s.businessNum }</td>
				<td><c:if test="${s.approvalState == 1}">
							승인완료
					</c:if> <c:if test="${s.approvalState == 0}">
						승인대기
					 </c:if></td>
				<td><c:if test="${s.approvalState  == 0}">
						<form action="storeApproval.do" method="post">
							<input type="hidden" name="businessNum" value="${s.businessNum }">
							<button type="submit" onclick="alert('매장을 등록했습니다.')">승인</button>
						</form>

					</c:if></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>