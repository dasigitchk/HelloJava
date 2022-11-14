<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/all.min.css">
<link rel="stylesheet" href="assets/css/templatemo-style.css">
</head>
<body>


    <div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll" data-image-src="assets/images/food.jpg">
        <form class="d-flex tm-search-form">
            <input class="form-control tm-search-input" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success tm-search-btn" type="submit">
                <i class="fas fa-search"></i>
            </button>
        </form>
    </div>

	<div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-6 tm-text-primary">
                Latest Photos
            </h2>
            <div class="col-6 d-flex justify-content-end align-items-center">
                <form action="" class="tm-text-primary">
                    Page <input type="text" value="1" size="1" class="tm-input-paging tm-text-primary"> of 200
                </form>
            </div>
        </div>
        
        <div class="row tm-mb-90 tm-gallery">
            <!--식당리스트 띄우기-->
            <c:forEach var="sl" items="${storeList}" varStatus="status">
                <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5" id="${sl.storeCode}" onclick="showId(this)">
                    <figure class="effect-ming tm-video-item">
                        <img src="upload/${sl.storeImage}" alt="Image" class="img-fluid">
                        <figcaption class="d-flex align-items-center justify-content-center">
                            <h2>${sl.storeName}</h2>
                            <a >View more</a>
                        </figcaption>                    
                    </figure>
                    <div class="d-flex justify-content-between tm-text-gray">
                        <span class="tm-text-gray-light">${sl.storeCategory}</span>
                        <span>${sl.storeRegion}</span>
                    </div>
                </div>

            </c:forEach>
                     
        </div> 
        
        <!-- 페이지 넘기기 -->
        <div class="row tm-mb-90">
            <div class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
                <div class="tm-paging d-flex">
                    <a href="javascript:void(0);" class="active tm-paging-link">1</a>
                    <a href="javascript:void(0);" class="tm-paging-link">2</a>
                    <a href="javascript:void(0);" class="tm-paging-link">3</a>
                    <a href="javascript:void(0);" class="tm-paging-link">4</a>
                </div>
                <a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next Page</a>
            </div>            
        </div>
    </div> <!-- container-fluid, tm-container-content -->
	<script>
		function showId(tagId) {
			let storeCode = tagId.id;
			let url = "store.do";
			location.href = url + "?storeCode=" + storeCode;
		}
	</script>
</body>

</html>