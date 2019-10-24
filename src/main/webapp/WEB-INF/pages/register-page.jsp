<%@include file="WEB-INF/static/header.jsp"%>

<main>
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
					<div class=" input bottom">
						<button class="larger" type="submit" name="registration" id="registration" title="registration">Registration</button>
					</div>
				</tr>
			</td>
			<td>
				<tr>
					<div > If you are registered, <a href="login-page.jsp">log in.</a></div>
				</tr>
			</td>
		</table>
	</form>
</main>
<%@include file="WEB-INF/static/footer.jsp"%>