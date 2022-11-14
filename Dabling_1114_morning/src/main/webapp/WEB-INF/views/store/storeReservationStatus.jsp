<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.form {
	margin-top: 80px;
}

table {
	text-align: center;
}
</style>
<title>매장예약현황조회</title>
</head>
<body>
	<div class="form" align="center">
		<div>
			<h1>${message }</h1>
		</div>
		<form>
	      <span><input type="date" id ="firstDate"></span>
	      <span> ~ </span>
	      <span><input type="date" id ="lastDate"></span>
	      <input type="button" value="검색" onclick="search()">
	    </form>
		<c:set var="today" value="<%=new java.util.Date()%>" />
		<c:set var="date">
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm:ss" />
		</c:set>
		<div>
			<c:if test="${empty reservationStatus}">
				<p>현재 매장의 예약이 없습니다.</p>
			</c:if>
			<c:if test="${not empty reservationStatus}">
				<table border="1">
					<thead>
						<tr>
							<th>예약번호</th>
							<th>회원코드</th>
							<th>예약일</th>
							<th>예약시간</th>
							<th>예약인원</th>
							<th>취소</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reservationStatus }" var="b">
							<c:if test="${b.reservationDate > date }">
								<tr>
									<td>${b.reservationCode }</td>
									<td>${b.memberCode }</td>
									<td>${b.reservationDate }</td>
									<td>${b.reservationTime }</td>
									<td>${b.reservationPeople }</td>
									<td><input type="button" value="취소" class="cancle"	onclick="delRow()"></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<hr>
			<input type="button" value="홈 가기" onclick="location.href='main.do'">
		</div>
	</div>
	<script type="text/javascript">
		// 예약취소ok
		function delRow() {
			let trs = document.querySelector('.cancle').parentNode.parentNode;
			if (confirm('예약을 취소하시겠습니까?')) {
				alert('예약취소 완료!')
				trs.remove();
				
				//DB삭제 ok
				let reservationCode = trs.children[0].textContent;
				let url = "storeReservationCancle.do?reservationCode=" + reservationCode;
				
				fetch(url)
					.then(response => response.text())
					.then(data => { // 결과처리 함수
					})
			}
		};
		
		//날짜 검색
		 function search(){
            console.log(document.querySelector('#firstDate').value)
            console.log(document.querySelector('#lastDate').value)
            let firstDate = document.querySelector('#firstDate').value;
            let lastDate = document.querySelector('#lastDate').value;
            
            let url = "storeReservationSearch.do?firstDate=" + firstDate +"&lastDate=" +lastDate;
			
			fetch(url)
				.then(response => response.text())
				.then(data => { // 결과처리 함수
				})
			}
	</script>
</body>
</html>