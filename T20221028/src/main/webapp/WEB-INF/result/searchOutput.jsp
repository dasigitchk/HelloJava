<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>조회결과페이지</h3>
	<table border='1'>
		<tr>
			<th>도서번호</th>
			<th>저자</th>
			<th>제목</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<tr>
			<td>${book.bookCode }</td>
			<td>${book.bookAuthor }</td>
			<td>${book.bookTitle }</td>
			<td>${book.bookPress }</td>
			<td>${book.bookPrice }</td>
		</tr>
	</table>
	<a href="main.do">첫페이지</a>
</body>
</html>