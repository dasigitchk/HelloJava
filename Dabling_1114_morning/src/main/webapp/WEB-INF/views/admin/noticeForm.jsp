<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	width: 1700px;
}

#notices {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#notices td, #notices th {
	border: 1px solid #ddd;
	padding: 8px;
}

#notices tr:nth-child(even) {
	background-color: #f2f2f2;
}

#notices tr:hover {
	background-color: #ddd;
}

#notices th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>

	<h1>공지사항</h1>

	<table id="notices">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${notices }" var="n">
			<tr>
				<td>${n.notice_code }</td>
				<td>${n.title }</td>
				<td>${n.cont }</td>
				<td>${n.writing_date }</td>
				<td>${n.cnt }</td>
			</tr>
		</c:forEach>
		<c:if test="${author == '9'}">
			<button type="button" onClick="location.href='noticeInsertForm.do'">공지작성</button>
		</c:if>
	</table>
</body>
</html>