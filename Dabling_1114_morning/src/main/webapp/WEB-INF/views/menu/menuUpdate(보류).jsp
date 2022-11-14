<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>storeMyPage</title>
    <style>
        h3 {
            margin-top: 80px;
        }

        form {
            margin: 50px;
        }

        label {
            width: 100px;
        }

        lnput {
            width: 300px;
        }

        button {
            text-align: center;
        }
    </style>
</head>

<body>
    <h3>메뉴 수정페이지</h3>
    <div>
    		<form id="frm" action="menuUpdate.do" method="post" enctype="multipart/form-data">
		<div>
			<label>메뉴명</label><input type="text" id="menuName" name="menuName" value="${menu.menuName }" required="required"><br>
			<label>메뉴사진</label><input type="file" id="menuImage" name="menuImage" value="${menu.menuImage }"><br>
        	<img src="<%=request.getContextPath() %>/upload/${menu.menuImage}" style="width:250px; height:150px;"><br>
			<label>가격</label><input type="text" id="price" name="price" value="${menu.price }" required="required"><br>
			<input type="submit" value="수정" id="update" >&nbsp;&nbsp; 
			<input type="reset" value="취소" id="delete">
		</div>
	</form>
    

    </div>

    <script>
     
    </script>

</body>

</html>