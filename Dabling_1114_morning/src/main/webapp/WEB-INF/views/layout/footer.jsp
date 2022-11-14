<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<footer class="tm-bg-bluegray pt-5 pb-3 tm-text-gray tm-footer">
		<div class="container-fluid tm-container-small">
			<div class="row">
				<div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
					<h3 class="tm-text-primary mb-4 tm-footer-title">About
						Catalog-Z</h3>
					<p>
						Catalog-Z is free <a rel="sponsored"
							href="https://v5.getbootstrap.com/">Bootstrap 5</a> Alpha 2 HTML
						Template for video and photo websites. You can freely use this
						TemplateMo layout for a front-end integration with any kind of CMS
						website.
					</p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
					<h3 class="tm-text-primary mb-4 tm-footer-title">Our Links</h3>
					<ul class="tm-footer-links pl-0">
						<li><a href="./main.do">Home</a></li>
						<c:choose>
							<c:when test="${empty email}">
								<li><a href="memberloginForm.do">Login</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="logout.do">Logout</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="memberJoinForm.do">Join</a></a></li>
						<c:if test="${ not empty email }">
							<li><a href="#top">Mypage</a></li>
						</c:if>
					</ul>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
					<img src="assets/images/DablingLogo4.png" width="150px">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-md-7 col-12 px-5 mb-3">Copyright 2020
					Catalog-Z Company. All rights reserved.</div>
				<div class="col-lg-4 col-md-5 col-12 px-5 text-right">
					Designed by <a href="https://templatemo.com" class="tm-text-gray"
						rel="sponsored" target="_parent">TemplateMo</a>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>