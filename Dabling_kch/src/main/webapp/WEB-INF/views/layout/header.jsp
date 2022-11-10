<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://tiles.apache.org/tags-tiles" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- ***** Logo Start ***** -->
                        <a href="main.do" class="logo">
                            <img src="assets/images/klassy-logo.png" align="klassy cafe html template">
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li class="scroll-to-section"><a href="#top" class="active">Home</a></li>
                            <li class="scroll-to-section"><a href="memberloginForm.do">Login</a></li>
                            <li class="scroll-to-section"><a href="#about">Logout</a></li>
                            <li class="scroll-to-section"><a href="memberJoinForm.do">Join</a></li>
                           	
                        <!-- 
                            <li class="submenu">
                                <a href="javascript:;">Drop Down</a>
                                <ul>
                                    <li><a href="#">Drop Down Page 1</a></li>
                                    <li><a href="#">Drop Down Page 2</a></li>
                                    <li><a href="#">Drop Down Page 3</a></li>
                                </ul>
                                
                            </li>
                        -->
                    
                            <li class="submenu">
                                <a href="javascript:;">Mypage</a>
                                <ul>
                                   <li><a href="#">---일반회원---</a></li>
                                     <li><a href="myInfo.do">내정보조회</a></li>
                                    <li><a href="myInfoUpdateForm.do">내정보수정</a></li>
                                    <li><a href="#">찜한가게확인</a></li>
                                    <li><a href="#">예약현황조회</a></li>
                                    <li><a href="#">예약취소</a></li>
                                    <li><a href="reviewForm.do">리뷰게시판</a></li>
                                    <li><a href="#">---사업자회원---</a></li>
                                    <li><a href="storeMyPage.do">마이페이지</a></li>
                                    <li><a href="storeInsertForm.do">매장등록신청</a></li>
                                    <li><a href="#">예약현황조회</a></li>
                                    <li><a href="#">예약취소</a></li>
                                    <li><a href="#">매장메뉴등록</a></li>
                                    <li><a href="#">매장메뉴수정</a></li>
                                    <li><a href="#">---관리자---</a></li>
                                    <li><a href="memberSelectForm.do">회원정보조회</a></li>
                                    <li><a href="memberUpdateForm.do">회원정보수정(권한변경)</a></li>
                                    <li><a href="#">매장등록승인</a></li>
                                    <li><a href="storeSelectForm.do">매장정보조회</a></li>
                                    <li><a href="#">매장정보수정</a></li>
                                    <li><a href="#">매장정보삭제</a></li>
                                </ul>
                            </li>
                            <!-- <li class=""><a rel="sponsored" href="https://templatemo.com" target="_blank">External URL</a></li> -->
                            <li class="scroll-to-section"><a href="#reservation">Contact Us</a></li> 
                        </ul>        
                        <a class='menu-trigger'>
                            <span>Menu</span>
                        </a>
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
    </header>
</body>
</html>