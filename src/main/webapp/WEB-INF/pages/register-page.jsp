<%@include file="/WEB-INF/static/header.jsp"%>

<main id ="login-main">
	<div id="wrapper-register-page">
		<form action="" method="post">
		<table>
			<tr>
				<td>
					<div class="titles">
						<em><h1>Register</h1></em></tr></td>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="email" >Email</label>
						<div class="input">
							<input type="email" name="email" id="email" value="">
						</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="name">Name</label>
						<div class="input">
							<input type="text" name="name" id="name" value="">
						</div>
				</td>
			</tr>
			<tr>
				<td>
						<label for="Surname">Surname</label>
						<div class="input">
							<input type="text" name="Suname" id="Surname" value="">
						</div>
				</td>
			</tr>
			<tr>
				<td>
						<label for="password">Password</label>
						<div class="input">
							<input type="password" name="password" id="password" value="">
						</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="password">Re. password</label>
					<div class="input">
						<input type="password" name="password" id="password" value="">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="country">Country</label>
					<div class="input">
						<input type="text" name="country" id="country" value="">
					</div>
					<label for="city">City</label>
					<div class="input">
						<input type="text" name="city" id="city" value="">
					</div>
					<label for="street">Street</label>
					<div class="input" type="text" name = "street" width = "40px">
						<input type="text" name="street" id="street" value="">
					</div>
				</td>
			</tr>
		</table>
	</form>
	</div>
	
</main>
<%@include file="/WEB-INF/static/footer.jsp"%>