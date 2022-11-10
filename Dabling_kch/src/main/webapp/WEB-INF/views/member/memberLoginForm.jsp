<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style>
		.form {
			margin-top: 80px;
		}
	</style>
</head>

<body>
	<main>
		<div align="center">
			<div>
				<form class="form" action="memberLogin.do" method="post">
					<div class="input">
						<span>or use your account</span><br>
						<input type="email" id="email" name="email" placeholder="Email" required="required" /><br>
						<input type="password" id="password" name="password" placeholder="Password"
							required="required" /><br>
						<a href="#">비밀번호를 잊어버렸나요?</a>
					</div><br>
					<div>
						<input type="submit" value="로그인">&nbsp;&nbsp;
						<input type="reset" value="취소">&nbsp;&nbsp;
						<input type="button" value="홈 가기" onclick="location.href='main.do'">
					</div>
				</form>
			</div>
		</div>

	</main>
	<script type="text/javascript">

	</script>
</body>

</html>