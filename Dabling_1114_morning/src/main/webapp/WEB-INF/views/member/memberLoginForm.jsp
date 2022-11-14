<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style>
		
	</style>
</head>

<body>
		<div class="container-fluid tm-container-content tm-mt-60">
			<form class="form" action="memberLogin.do" method="post">
				<div class="input">
					<input type="email" id="email" name="email" placeholder="Email" required="required" /><br>
					<input type="password" id="password" name="password" placeholder="Password"
						required="required" /><br>
					<a href="findPasswordForm.do">비밀번호를 잊어버렸나요?</a>
				</div>
				<div>
					<input type="submit" value="로그인">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
					<input type="button" value="홈 가기" onclick="location.href='main.do'">
				</div>
			</form>
			<span>or use your Kakao account</span><br>
			<a href="javascript:kakaoLogin();"><img
					src="https://blog.kakaocdn.net/dn/bYZZHh/btrfibui4Cj/DofAXcdzmQGCKkhTNUUAHk/img.png"
					style="height:50px;width:auto;"></a>

		</div>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
		Kakao.init("8fd6e2817c7b55bad682e268c8fc4923");

		function kakaoLogin() {
			window.Kakao.Auth.login({
				scope: 'profile_nickname, account_email',
				success: function (authObj) {
					console.log(authObj);
					window.Kakao.API.request({
						url: '/v2/user/me',
						success: res => {
							const kakao_account = res.kakao_account;
							var email = res.kakao_account.email;
							let url = "kakaoLogin.do?email=" + email;
							location.href = url;
							// fetch(url)
							// 	.then(response => response.text())
							// 	.then(data => {
							// 		if (data = 'main/main.do') {
							// 			alert("Dabling에 오신것을 환영합니다.")
							// 		}

							// 	});
						}
					});
				}
			});
		}
	</script>
</body>

</html>