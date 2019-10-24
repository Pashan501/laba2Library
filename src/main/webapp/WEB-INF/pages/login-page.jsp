<%@include file="WEB-INF/static/header.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="../style/style1.css">
</head>

<body style="background-image:url(images/backgrounds.jpg)";>
	<style type="text/css">
		.input
		{
			width: 180px;
			height: 40px;
			margin: auto;
			opacity: .5;
		}
		.titles
		{
			width: 100%;
			text-align: center;

		}
		label
		{
			font-weight: bold;
			width: 100%;
			text-align: right;
		}
	</style>
	<form action="" method="post">
		<table>
			<br>
			<br>
			<br>
			<td><tr>
			<div class="titles">
				<em><h1>Login</h1></em></tr></td>
			</div>
			<td>
				<tr>
				<br>
				<br>
				<label for="email">Name</label>
				<div class="input" type = "text" name = "name" >
					<input type="text" name="name" id="name" value="">
				</div>
			</tr>
			</td>
			<td>
				<tr>
					<label for="password">Password</label>
					<div class="input" type="text" name = "password">
						<input type="text" name="password" id="password" value="">
					</div>
				</tr>
			</td>
			<td>
				<tr>
				<br>
					<div class=" input bottom" style="opacity: 1">
						<button class="larger" type="submit" name="login" id="registration" title="registration">Login</button>
					</div>
				</tr>
			</td>
			<td>
				<tr>
					<div style="width: 100%; text-align:center;"> If you are a new user, <a href="register-page.jsp">registered.</a></div>
				</tr>
			</td>
		</table>
	</form>
</body>
</html>
<%@include file="WEB-INF/static/footer.jsp"%>