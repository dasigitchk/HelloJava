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
				<li class="nav-item"><a href="#">---�Ϲ�ȸ��---</a></li>
				<li class="nav-item"><a href="memberInfo.do">��������ȸ</a></li>
				<li class="nav-item"><a href="memberInfoUpdateForm.do">����������</a></li>
				<li class="nav-item"><a href="#">���Ѱ���Ȯ��</a></li>
				<li class="nav-item"><a href="reservationStatus.do">������Ȳ��ȸ</a></li>
				<li class="nav-item"><a href="reservationCancel.do">�������</a></li>
				<li class="nav-item"><a href="reservationHistory.do">�̿볻��</a></li>
				<li class="nav-item"><a href="#">����Խ���</a></li>
			</c:if>
			<c:if test="${author == '2'}">
				<li><a href="#">---�����ȸ��---</a></li>
				<li><a href="storeInsertForm.do">�����Ͻ�û</a></li>
				<li><a href="#">---�����(�������)ȸ��---</a></li>
				<li><a href="storeMyPage.do">����������</a></li>
				<li><a href="storeReservationStatus.do">������Ȳ��ȸ</a></li>
				<li><a href="storeReservationHistory.do">���೻����ȸ</a></li>
				<li><a href="menuInsertForm.do">�޴����</a></li>
				<li><a href="menuList.do">�޴�����/����</a></li>
			</c:if>
			<c:if test="${author == '9'}">
				<lable>My Page</lable>
				<li><a href="#">---������---</a></li>
				<li><a href="memberSelectForm.do">ȸ��������ȸ</a></li>
				<li><a href="memberUpdateForm.do">ȸ����������(���Ѻ���)</a></li>
				<li><a href="storeApprovalForm.do">�����Ͻ���</a></li>
				<li><a href="storeSelectForm.do">����������ȸ</a></li>
				<li><a href="storeUpdateForm.do">������������</a></li>
				<li><a href="storeDeleteForm.do">������������</a></li>
			</c:if>
		</ul>
	</div>
	<script>
		
	</script>
</body>
</html>