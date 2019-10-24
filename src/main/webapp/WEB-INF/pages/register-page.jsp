<%@include file="WEB-INF/static/header.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Registration</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="../style/style1.css">
</head>

<body style="background-image:url(backgrounds.jpg)";>
	<style type="text/css">
		.input
		{
			width: 180px;
			height: 40px;
			margin: auto;
			opacity: .5;
		}
		label
		{
			width: 100%;
			text-align: center;
		}
	</style>
	<form action="" method="post">
		<table >
			<br>
			<br>
			<br>
			<td width="100%"><tr><em><h1>Registration</h1></em></tr></td>
			<td>
				<tr>
				<br>
				<br>
				<label for="email" >Your email address</label>
				<div class="input" type = "text" name = "email" >
					<input type="text" name="email" id="email" value="">
				</div>
			</tr>
			</td>
			<td>
				<tr>
					<label for="name">Name</label>
					<div class="input" type="text" name = "name">
						<input type="text" name="name" id="name" value="">
					</div>
				</tr>
			</td>
			<td>
				<tr>
					<label for="firstName">Surname</label>
					<div class="input" type="text" name = "firstName">
						<input type="text" name="firstName" id="firstName" value="">
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
					<label for="country">Country</label>
					<div class="input" type="text" name = "country" >
						<input type="text" name="country" id="country" value="">
					</div>
					<label for="city">City</label>
					<div class="input" type="text" name = "city" width = "40px">
						<input type="text" name="city" id="city" value="">
					</div>
					<label for="street">Street</label>
					<div class="input" type="text" name = "street" width = "40px">
						<input type="text" name="street" id="street" value="">
					</div>
				</tr>
			</td>
			<td>
				<tr>
				<br>
					<div class=" input bottom" style="opacity: 1">
						<button class="larger" type="submit" name="registration" id="registration" title="registration">Registration</button>
					</div>
				</tr>
			</td>
			<td>
				<tr>
					<div style="width: 100%; text-align:center;"> If you are registered, <a href="login-page.jsp">log in.</a></div>
				</tr>
			</td>
		</table>
	</form>
</body>
</html>
<%@include file="WEB-INF/static/footer.jsp"%>