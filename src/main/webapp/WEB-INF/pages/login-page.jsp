<%@include file="/WEB-INF/static/header.jsp"%>


<main id="login-main">
	<form action="" method="post">
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
					<div> If you are a new user, <a href="./register">sing up.</a></div>
				</td>
			</tr>
		</table>
	</form>
</main>

<%@include file="/WEB-INF/static/footer.jsp"%>