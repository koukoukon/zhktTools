<!--Author: xmoban.cn
Author URL: http://xmoban.cn
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
	<title>智慧课堂小工具登录</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Validate Login & Register Forms Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->

	<!-- css files -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Magra:400,700&amp;subset=latin-ext" rel="stylesheet">
	<!-- //web-fonts -->

	<style>
		.loginMes{
			display: none;
			position: absolute;
			left: calc(50% - 190px);
			top: 200px;
			border: 1px solid #25b4ed;
			text-align: center;
			line-height: 200px;
			font-family: 'Magra', sans-serif;
			border-radius: 5%;
			background-color: #ffffff;
			width: 380px;
			height: 200px;
		}
	</style>
</head>

<body>
	<!-- title -->
    <br>
    <br>
	<h1>
		使用智慧课堂账号登录
	</h1>
	<!-- //title -->

	<!-- content -->
	<div class="container-agille">
		<div class="formBox level-login">
			<div class="box boxShaddow"></div>

			<div class="box loginBox">
                <h3>Login Here</h3>
				<form id="fo" method="POST" class="form" action="${pageContext.request.contextPath}/user/home">
					<div class="f_row-2">
						<input name="account" type="text" class="input-field" id="account" placeholder="Username" required>
					</div>
					<div class="f_row-2 last">
						<input id="password" type="password" name="password" placeholder="Password" class="input-field" required>
						<span style="color: red;font-weight: bold" id="n_mes">${requestScope.mes}</span>
					</div>
					<input readonly="readonly" value="登录" class="submit-w3" id="loginBtn">
				</form>

			</div>

		</div>
	</div>

<%--	<form action="user/start" method="post">--%>
<%--		<input type="submit" value="tet">--%>
<%--	</form>--%>

	<div id="loginMes" class="loginMes">正在登录。。。</div>

	<!-- js files -->
	<!-- Jquery -->

	<!-- //Jquery -->
	<!-- input fields js -->
	<script src="js/input-field.js"></script>
	<!-- //input fields js -->

</body>
<script>
	$(function () {
        // $("#loginMes").css("display","none");
		$("#loginBtn").on("click", function () {
			var account = $("#account").val();
			var password = $("#password").val();
			if (account.length > 0 && password.length > 0) {
                // $("#loginMes").css("display","block");
				$("#fo").submit();
			}
			return false;
		})
	})
</script>
</html>