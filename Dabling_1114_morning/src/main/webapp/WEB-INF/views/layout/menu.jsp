<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<div>

		<ul class="submenu">
			<c:if test="${author == '1'}">
				<lable id="myPage">My Page</lable>
				<li class="nav-item"><a href="#">---일반회원---</a></li>
				<li class="nav-item"><a href="memberInfo.do">내정보조회</a></li>
				<li class="nav-item"><a href="memberInfoUpdateForm.do">내정보수정</a></li>
				<li class="nav-item"><a href="#">찜한가게확인</a></li>
				<li class="nav-item"><a href="reservationStatus.do">예약현황조회</a></li>
				<li class="nav-item"><a href="reservationCancel.do">예약취소</a></li>
				<li class="nav-item"><a href="reservationHistory.do">이용내역</a></li>
				<li class="nav-item"><a href="#">리뷰게시판</a></li>
			</c:if>
			<c:if test="${author == '2'}">
				<li><a href="#">---사업자회원---</a></li>
				<li><a href="storeInsertForm.do">매장등록신청</a></li>
				<li><a href="#">---사업자(매장승인)회원---</a></li>
				<li><a href="storeMyPage.do">마이페이지</a></li>
				<li><a href="storeReservationStatus.do">예약현황조회</a></li>
				<li><a href="storeReservationHistory.do">예약내역조회</a></li>
				<li><a href="menuInsertForm.do">메뉴등록</a></li>
				<li><a href="menuList.do">메뉴수정/삭제</a></li>
			</c:if>
			<c:if test="${author == '9'}">
				<lable>My Page</lable>
				<li><a href="#">---관리자---</a></li>
				<li><a href="memberSelectForm.do">회원정보조회</a></li>
				<li><a href="memberUpdateForm.do">회원정보수정(권한변경)</a></li>
				<li><a href="storeApprovalForm.do">매장등록승인</a></li>
				<li><a href="storeSelectForm.do">매장정보조회</a></li>
				<li><a href="storeUpdateForm.do">매장정보수정</a></li>
				<li><a href="storeDeleteForm.do">매장정보삭제</a></li>
			</c:if>
		</ul>
	</div>
	<script>
		
	</script>
</body>
</html>