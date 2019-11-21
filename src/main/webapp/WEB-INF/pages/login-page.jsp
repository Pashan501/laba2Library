<%@include file="/WEB-INF/static/header.jsp"%>
	<main id="main">
	<div class="container main-page-container" id="login-main">
		 <form action="" method="post" id= "login-form">
		<table>
			<tr>
				<td>
					<div class="titles">
						<em><h1>Log in</h1></em></tr></td>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="email">Login</label>
					<div class="input">
						<input type="email" name="email" id="email" value="">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="password">Password</label>
						<div class="input" >
							<input type="password" name="password" id="password" value="">
						</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="input">
						<input type="submit" class="submit" value = "Send">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div> If you are a new user, please<a href="./register"> Sing up.</a></div>
				</td>
			</tr>
			<tr>
				<td>
					<c:if test="${errorLogin == true}">
						<p style="color:red">sorry, wrong data</p>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
	</div>
</main>

<%@include file="/WEB-INF/static/footer.jsp"%>