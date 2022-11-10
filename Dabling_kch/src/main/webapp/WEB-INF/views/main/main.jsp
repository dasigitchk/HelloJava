<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
</head>

<body>
    <section class="section" id="menu">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="section-heading">
                        <h2>최신 식당 리스트</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="menu-item-carousel">
            <div class="col-lg-12">
                <div class="owl-menu-item owl-carousel">

                    <c:forEach var="sl" items="${storeList}" varStatus="status">
                        <div class="item" id="${sl.storeCode}" onclick = "showId(this)">
                            <div class='card card${status.index+1}'>
                                <div class="price">
                                    <h6>${status.index+1}</h6>
                                </div>
                                <div class='info'>
                                    <h1 class='title'>${sl.storeName}</h1>
                                    <p class='description'>${sl.storeInfo}</p>
                                    <div class="main-text-button">
                                        <div class="scroll-to-section"><a href="#reservation">Make Reservation(미완) <i
                                                    class="fa fa-angle-down"></i></a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="item">
                        <div class='card card5'>
                            <div class="price">
                                <h6>$8.50</h6>
                            </div>
                            <div class='info'>
                                <h1 class='title'>Klassy Cup Cake</h1>
                                <p class='description'>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sedii do
                                    eiusmod teme.</p>
                                <div class="main-text-button">
                                    <div class="scroll-to-section"><a href="#reservation">Make Reservation <i
                                                class="fa fa-angle-down"></i></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
             
                </div>
            </div>
        </div>
    </section>
    <script>
        function showId(tagId) {
            let storeCode = tagId.id;
            let url = "store.do";
            location.href= url+"?storeCode="+storeCode;
        }
    </script>
</body>

</html>