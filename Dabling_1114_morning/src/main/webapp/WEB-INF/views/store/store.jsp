<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Restaurant HTML Template</title>

	<!-- 상세페이지 Css -->
</head>
<style>
</style>

<body>

	<!-- 스크롤이미지  -->
	<div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll"
		data-image-src="assets/images/food.jpg">
		<form class="d-flex tm-search-form">
			<input class="form-control tm-search-input" type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success tm-search-btn" type="submit">
				<i class="fas fa-search"></i>
			</button>
		</form>
	</div>
	<!-- 스크롤이미지  끝-->

	<!--  가게정보 보이기 -->
	<div class="store-picture-wrap">
		<div class="store-image">
			<img src="upload/${store.storeImage}.jpg" alt="${store.storeImage}">
		</div>
		<div class="store-info">
			<h1 class="title">${store.storeName}</h1>
			<c:if test="${like !=null}">
				<button id="like-btn">#{likeValue}</button>
			</c:if>
			<h2 class="lead">${store.storeInfo}</h2>
		</div>
	</div>
	<!--  가게정보 보이기 끝-->

	<!-- 메뉴리스트 -->
	<div class="row tm-mb-74 tm-people-row">
		<c:forEach var="menu" items="${menuList}" varStatus="status">
			<div class="col-lg-3 col-md-6 col-sm-6 col-12 mb-5">
				<img src="upload/${menu.menuImage}" alt="Image" class="mb-4 img-fluid">
				<h2 class="tm-text-primary mb-4">${menu.menuName}</h2>
				<h3 class="tm-text-secondary h5 mb-4">${menu.price}</h3>
			</div>
		</c:forEach>
	</div>
	<!-- 메뉴리스트 끝 -->

	<!-- 리뷰카드 리스트 -->
	<div class="row">
		<c:forEach var="review" items="${reviewList}" varStatus="status">
			<!--리뷰영역-->
			<div class="review-card" id="review-${status.index}">
				<h5 class="tm-text-primary mb-4">
					<span>${review.reviewDate}</span> ⭐${review.rate}
				</h5>
				<h4 class="tm-text-secondary h4 mb-4">${review.content}</h4>
				<input type="hidden" id="reservation-code" value="${review.reservationCode}">
			</div>
			<!--답글영역-->
			<c:forEach var="reply" items="${replyList}" varStatus="replySt">
				<c:choose>
					<!--리뷰 예약코드와 답글 예약코드 같은지 확인-->
					<c:when test="${review.reservationCode == reply.reservationCode }">
						<div class="reply-card" id="review-${status.index}-reply">
							<ul>
								<li><div class= "reply-card-content">${reply.content}</div></li>
								<c:if test="${author == '2'}">
								<li>
									<button id="modify-reply-btn">답글수정</button>
									<button id="delete-reply-btn">답글삭제</button>
								</li>
								</c:if>
							</ul>
						</div>
					</c:when>
					<c:otherwise>
						<c:if test="${author == '2'}">
							<div class="reply-card" id="review-${status.index}-reply">
								<ul>
									<li class="reply-card-content"><textarea placeholder="답글내용 작성"></textarea></li>
									<li>
										<button id="add-reply-btn">답글등록</button>
									</li>
								</ul>
							</div>
						</c:if>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!--답변리스트 FOREACH끝-->
		</c:forEach>
		<!--리뷰리스트 FOREACH끝-->
	</div>
	<!-- 리뷰리스트 끝 -->

	<!-- 예약하기, 지도 -->
	<div class="container-fluid tm-mt-60">
		<div class="row tm-mb-50">
			<!-- 예약-->
			<div class="col-lg-4 col-12 mb-5">
				<h2 class="tm-text-primary mb-5">Reservation</h2>
				<form id="contact-form" action="" method="POST" class="tm-contact-form mx-auto">
					<div class="form-group">
						<input type="hidden" id="storelat" value="${store.lat}"> <input type="hidden" id="storelng"
							value="${store.lng}">
						<c:choose>
							<c:when test="${memberCode != null}">
								<input class="form-control rounded-0" type="text" name="name" placeholder="${name}"
									id="name" readonly>
								<input type="hidden" id="memberCode" value="${memberCode}">
								<input type="hidden" id="storeCode" value="${store.storeCode}">
							</c:when>
							<c:otherwise>
								<input type="text" name="name" class="form-control rounded-0" placeholder="Name"
									required />
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<c:choose>
							<c:when test="${memberCode != null}">
								<input type="text" name="name" class="form-control rounded-0" placeholder="${phone}"
									id="phone" readonly>
							</c:when>
							<c:otherwise>
								<input type="text" name="name" class="form-control rounded-0" placeholder="Phone"
									id="phone">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<c:choose>
							<c:when test="${memberCode!= null}">
								<input class="form-control rounded-0" type="email" placeholder="${email}" id="email"
									readonly>
							</c:when>
							<c:otherwise>
								<input class="form-control rounded-0" type="email" placeholder="Email" id="email">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<select class="form-control" id="person" name="person">
							<option value="-">Number of Guests</option>
							<option value="1">1 Person</option>
							<option value="2">2 People</option>
							<option value="3">3 People</option>
							<option value="4">4 People</option>
							<option value="5">5 People</option>
							<option value="6">6 People</option>
						</select>
					</div>
					<div class="form-group">
						<table>
							<tr>
								<td><label for="time">Date</label></td>
								<td><label for="time">Time</label></td>
							</tr>
							<tr>
								<td><input class="form-control rounded-0" type="text" placeholder="YYYY/MM/DD"
										id="date"></td>
								<td><input class="form-control rounded-0" type="text" placeholder="HH:MM" id="time">
								</td>
							</tr>
						</table>
					</div>
					<div class="form-group tm-text-right">
						<c:choose>
							<c:when test="${memberCode== null}">
								<!-- <input type="button" class="form-control rounded-0" value="로그인후 예약가능"> -->
								<button type="button" class="btn btn-primary">로그인후 예약가능</button>
							</c:when>
							<c:otherwise>
								<!-- <input type="button" class="form-control rounded-0" id="bookBtn"value="Book Now"> -->
								<button type="button" class="btn btn-primary" id="bookBtn">Book
									Now</button>
							</c:otherwise>
						</c:choose>
					</div>




				</form>
			</div>
			<!-- 중간 섹션-->
			<div class="col-lg-4 col-12 mb-5">
				<div class="tm-address-col">
					<h2 class="tm-text-primary mb-5">Our Address</h2>
					<p class="tm-mb-50">Quisque eleifend mi et nisi eleifend
						pretium. Duis porttitor accumsan arcu id rhoncus. Praesent
						fermentum venenatis ipsum, eget vestibulum purus.</p>
					<p class="tm-mb-50">Nulla ut scelerisque elit, in fermentum
						ante. Aliquam congue mattis erat, eget iaculis enim posuere nec.
						Quisque risus turpis, tempus in iaculis.</p>
					<address class="tm-text-gray tm-mb-50">
						120-240 Fusce eleifend varius tempus<br> Duis consectetur at
						ligula 10660
					</address>
					<ul class="tm-contacts">
						<li><a href="#" class="tm-text-gray"> <i class="fas fa-envelope"></i> Email: info@company.com
							</a></li>
						<li><a href="#" class="tm-text-gray"> <i class="fas fa-phone"></i> Tel: 010-020-0340
							</a></li>
						<li><a href="#" class="tm-text-gray"> <i class="fas fa-globe"></i> URL: www.company.com
							</a></li>
					</ul>
				</div>
			</div>
			<!-- 지도-->
			<div class="col-lg-4 col-12">
				<h2 class="tm-text-primary mb-5">Our Location</h2>
				<!-- Map -->
				<div class="mapouter mb-4" id="map"></div>
			</div>
		</div>
	</div>
	<!-- 예약하기, 지도 끝-->

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fbd0c3f89baf8cb5bc48455b0ff961e4">
	</script>
	<script>
		//-----------------------카카오지도생성----------------------------------
		let storelat = document.getElementById('storelat').value;
		let storelng = document.getElementById('storelng').value;

		var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
		mapOption = {
			center: new kakao.maps.LatLng(storelat, storelng), // 지도의 중심좌표
			level: 3
			// 지도의 확대 레벨
		};
		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
		// 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(storelat, storelng);
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position: markerPosition
		});
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		//-------------------------------------------------------------------------

		document.querySelector('#bookBtn').addEventListener('click', makeReservation);
		document.querySelector('#like-btn').addEventListener('click', LikeFnc);
		
		document.querySelector('#add-reply-btn').addEventListener('click', addReply);
		document.querySelector('#modify-reply-btn').addEventListener('click', modifyReply);
		document.querySelector('#delete-reply-btn').addEventListener('click', deleteReply);



		function makeReservation() {
			let memberCode = document.getElementById('memberCode').value;
			let storeCode = document.getElementById('storeCode').value;
			let date = document.getElementById('date').value;
			let time = document.getElementById('time').value;
			let person = document.getElementById('person').value;

			data = "memberCode=" + memberCode + "&storeCode=" + storeCode +
				"&date=" + date + "&time=" + time + "&person=" + person;

			let addBookAjax = new XMLHttpRequest();
			addBookAjax.open('post', './makeReservation.do');
			addBookAjax.setRequestHeader('Content-type',
				'application/x-www-form-urlencoded');
			addBookAjax.send(data);
			addBookAjax.onload = function () {
				let message = addBookAjax.responseText;
				document.getElementById('memberCode').value = "";
				document.getElementById('storeCode').value = "";
				document.getElementById('date').value = "";
				document.getElementById('time').value = "";
				document.getElementById('person').value = "";
				alert(message);
			}
		}

		function LikeFnc() {
			let memberCode = document.getElementById('memberCode').value;
			let storeCode = document.getElementById('storeCode').value;
			data = "memberCode=" + memberCode + "&storeCode=" + storeCode;

			let addLikeAjax = new XMLHttpRequest();
			addLikeAjax.open('post', './likeCommand.do');
			addLikeAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			addLikeAjax.send(data);
			addLikeAjax.onload = function () {
				let message = addLikeAjax.responseText;
				alert(message);
				if (message == "찜추가 완료") {
					document.querySelecter('#like-btn').textContent = "찜취소하기";
				} else if (message == "찜취소 완료") {
					document.querySelecter('#like-btn').textContent = "찜하기";
				}
			}
		}

		function addReply(){
			let reservationCode = document.getElementById('reservation-code').value;
			console.log(this);

		}

		function modifyReply(){
			//수정버튼 누르면 textarea열리고 그내용이 담기게
			//수정완료 누르면 내용 수정커맨드로 이동
		}

		function deleteReply(){

		}

	</script>
</body>

</html>