<%@page import="java.util.List"%>
<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>도서 리스트.</title>
</head>

<body>

	<table border="1">
		<caption>도서목록</caption>
		<thead>
			<tr>
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>도서저자</th>
				<th>도서출판사</th>
				<th>도서가격</th>
			</tr>
			<c:forEach var="bList" items="${list }">
				<tr>
					<td>${bList.bookCode }</td>
					<td>${bList.bookTitle }</td>
					<td>${bList.bookAuthor }</td>
					<td>${bList.bookPress }</td>
					<td>${bList.bookPrice }</td>
				</tr>
			</c:forEach>
		</thead>
		<tbody>
		</tbody>
	</table>

	<a href="main.do">첫페이지</a>
</body>

</html>