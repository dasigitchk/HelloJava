<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h3, table {
	margin-top: 80px;
	text-align: center;
}
</style>
</head>
<body>

	<h3>${store.storeName} 매장 등록메뉴</h3>
	<div id="show">
		<c:if test="${empty storeMenuList }">
			<p>현재 매장의 등록된 메뉴가 없습니다.</p>
		</c:if>
		<c:if test="${not empty storeMenuList}">
			<table border="1" id="menuTable">
				<thead>
					<tr>
						<td>메뉴명</td>
						<td>이미지</td>
						<td>가격</td>
						<td><input type="checkBox" value="삭제" class="delete"
							id="allDelete"></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="menu" items="${storeMenuList}">
						<tr>
							<td><span ondblclick="changeName(this)" data-value="${menu.menuName}">${menu.menuName}</span></td>
							<td><div class="contentImage">
									<c:if test="${not empty menu.menuImage }">
										<img src="${menu.menuImage}" style="width: 250px; height: 150px;">
									</c:if>
								</div>
							</td>
							<td><span ondblclick="changePrice(this)" data-value="${menu.price}">${menu.price}</span></td>
							
							<td><input class="check" type="checkBox" value="삭제" class="delete"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" value="삭제하기" id="deleteBtn"> <br>
		</c:if>

	</div>

	<script type="text/javascript">
		// 삭제 전체체크 ok
		let allDelete = document.querySelector("#allDelete")
		let deleteCheck = document.querySelector(".delete")

		allDelete.addEventListener('change', function() {
			//forEach 반복문사용.
			document.querySelectorAll('#show input[value="삭제"]').forEach(
					function(deleteCheck) {
						deleteCheck.checked = allDelete.checked;
					})
		})

		// 메뉴 화면삭제. ok
		document.querySelector('#deleteBtn').addEventListener('click',deleteMenu);

		function deleteMenu(deleteCheck) {
			let trs = document.querySelectorAll('#show>table>tbody>tr');
		
		//DB삭제 ok
		if (confirm('메뉴를 삭제하시겠습니까?')) {
			alert('메뉴삭제 완료!')
			for (let i = 0; i < trs.length; i++) {
					if (trs[i].children[3].children[0].checked) {
							trs[i].remove();
						let menuName = trs[i].children[0].textContent;
						let url = "menuDelete.do?menuName=" + menuName;
						
						fetch(url)
							.then(response => response.text())
							.then(data => { // 결과처리 함수
							})
						}
			}
		}
	}
		//더블클릭시 메뉴변경 ok
		function changeName(value) {
			let menuName = $(value).data("value");
			if(confirm(menuName+'를 메뉴를 수정하시겠습니까?')){
				let menuNameRename = prompt(menuName + " : 변경메뉴명을 입력하세요"+"");
				alert('메뉴수정 완료');
				let url = "menuNameUpdate.do?menuName=" + menuName
						+"&menuNameRename=" + menuNameRename;
				fetch(url)
					.then(response => response.text())
					.then(data => { // 결과처리 함수
					})
			}
		}
		
		//더블클릭시 가격변경 ok
		function changePrice(value) {
			let menuName = value.parentNode.parentNode.children[0].textContent;
			let price = $(value).data("value");
			if(confirm(menuName + price +' 가격을 수정하시겠습니까?')){
				let priceChange = prompt("가격 입력 : "+"");
				alert('메뉴가격 수정 완료');
				let url = "menuPriceUpdate.do?priceChange=" + priceChange
						+"&menuName=" + menuName;
				fetch(url)
					.then(response => response.text())
					.then(data => { // 결과처리 함수
					})
			}
		}
		
	</script>
</html>