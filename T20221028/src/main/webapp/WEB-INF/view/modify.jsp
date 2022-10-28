<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

    <h3>도서수정조회</h3>
    <form action="./searchBook.do" method="get">
       도서번호: <input type="text" name="bookCode"><br>
        <input type="hidden" name="job" value="modify">
        <input type="submit" value="조회">
    </form>
    
    <!-- 도서수정을 위한 화면 작성코드를 입력하세요. -->
	<form action="./modifyBook.do" method="post">
       도서번호: <input type="text" name="bookCode" value="${book.bookCode }" readonly><br>
       도서제목: <input type="text" name="bookTitle" value="${book.bookTitle }" ><br>
       도서저자: <input type="text" name="bookAuthor" value="${book.bookAuthor }" ><br>
       도서출판사: <input type="text" name="bookPress" value="${book.bookPress }" ><br>
       도서가격: <input type="text" name="bookPrice" value="${book.bookPrice }" ><br>
        <input type="submit" value="수정">

    </form>
    <a href="main.do">첫페이지</a>

</body>

</html>