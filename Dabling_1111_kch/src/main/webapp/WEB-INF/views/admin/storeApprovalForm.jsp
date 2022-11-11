<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div>
			<h1>매장등록대기목록</h1>
		</div>
		<table border="1">
			<thead>
				<tr>
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
				<c:forEach items="${stores }" var="s">
					<form action="storeApproval.do" method="post">
					<tr>
						<td>${s.storeCode }</td>
						<td>${s.storeName }</td>
						<td>${s.storeRegion }</td>
						<td>${s.storeCategory }</td>
						<td>${s.storeInfo }</td>
						<td>${s.storeAddress }</td>
						<td>${s.businessNum }</td>
						<td>${s.approvalState }</td>
						<td>
							<button type="submit" onsubmit="remove()">승인</button>
							<button type="button">거부</button>
						</td>
					</form>
					</tr>
				</c:forEach>
			</thead>
			<tbody>
			</tbody>
		</table>
		<script>
			function remove() {
				this.parentElement.parentElement.remove();
			}
		</script>
</body>
</html>