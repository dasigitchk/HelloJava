<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.form {
	margin-top: 80px;
}
</style>
<title></title>
</head>
<body>
	<div class="form" align="center">
		<div>
			<h1>${message }</h1>
		</div>
		<c:set var="today" value="<%=new java.util.Date()%>" />
		<c:set var="date">
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm:ss" />
		</c:set>
		<div>

			<table border="1">
				<thead>
					<tr>
						<th><input type="checkbox" name="checkAll" id="th_checkAll"
							onclick="checkAll();" /></th>
						<th>예약번호</th>
						<th>회원코드</th>
						<th>가게코드</th>
						<th>예약일</th>
						<th>예약시간</th>
						<th>예약인원</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reservationStatus }" var="b">

						<c:if test="${b.reservationDate > date }">
							<tr>
								<td><input type="checkbox" name="checkRow"></td>
								<td id = "reservationCode" value="${b.reservationCode }"></td>
								<td>${memberCode }</td>
								<td>${b.storeCode }</td>
								<td>${b.reservationDate }</td>
								<td>${b.reservationTime }</td>
								<td>${b.reservationPeople }</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<input type="button" value="예약취소"
				onclick="location.href='reservationCancel.do'"> <input
				type="button" value="홈 가기" onclick="location.href='main.do'">

		</div>
	</div>
</body>
<script type="text/javascript">
	function checkAll() {
		if ($("#th_checkAll").is(':checked')) {
			$("input[name=checkRow]").prop("checked", true);
		} else {
			$("input[name=checkRow]").prop("checked", false);
		}
	}
</script>

</html>