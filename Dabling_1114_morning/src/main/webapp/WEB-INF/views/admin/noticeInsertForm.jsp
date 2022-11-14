<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

input[type=reset] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=reset]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

<h3>공지사항 작성페이지</h3>

<div class="container">
  <form action="noticeInsert.do" method="POST">
    <label for="title">공지제목</label>
    <input type="text" id="title" name="title" placeholder="제목을 입력하세요..">

    <label for="subject">내용</label>
    <textarea id="subject" name="subject" placeholder="내용을 입력하세요.." style="height:200px"></textarea>
    <input type="submit" value="등록" onclick="alert('등록되었습니다.')">
    <input type="reset" value="초기화">
  </form>
</div>
</body>
</html>
