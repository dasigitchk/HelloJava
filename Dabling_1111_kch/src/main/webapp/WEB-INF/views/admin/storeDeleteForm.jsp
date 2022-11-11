<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h3 {
		margin-top: 80px; 
	}
</style>
</head>
<body>
<div align="center"></div>
	
 <h3>매장정보조회</h3>
    <form action="storeSelect.do" method="post">
       사업자번호: <input type="text" name="businessNum"><br>
        <input type="hidden" name="job" value="storeDelete">
        <input type="submit" value="조회">
    </form>
    
    <form action="storeDelete.do" method="post">
       매장번호: <input type="number" name="storeCode" value="${store.storeCode }" readonly><br>
       매장이름: <input type="text" name="storeName" value="${store.storeName }" ><br>
       지역: <input type="text" name="storeRegion" value="${store.storeRegion }" ><br>
       카테고리: <input type="text" name="storeCategory" value="${store.storeCategory }" ><br>
       설명: <input type="text" name="storeInfo" value="${store.storeInfo }" ><br>
       위도: <input type="text" name="lat" value="${store.lat }" ><br>
       경도: <input type="text" name="lng" value="${store.lng }" ><br>
       이미지: <input type="text" name="storeImage" value="${store.storeImage }" ><br>
       변경이미지네임: <input type="text" name="storeImageRename" value="${store.storeImageRename }" ><br>
       주소: <input type="text" name="storeAddress" value="${store.storeAddress }" ><br>
       사업자번호: <input type="text" name="businessNum" value="${store.businessNum }" ><br>
        <input type="submit" value="삭제">
    </form>
 <script>	
 <!--  얼러트로 재확인하는 기능 작성중 -->
<!--	function confirm(){
		 msg = "정말 삭제하시겠습니까? 삭제후에는 되돌릴 수 없습니다.";
         if (confirm(msg)!=0) {
              // Yes click
         } else {
             // no click
	} !-->
</script>
</body>
</html>