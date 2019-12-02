<%@include file="/WEB-INF/static/header.jsp"%>

<main id ="main">
	<div id="wrapper-register-page">
	<c:if  test = "${form}">
		<form action="" method="post">
			<div class="container-register-page">
				<table>
			<tr>
				<td>
					<div class="titles">
						<em><h1>Registration</h1></em></tr></td>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="email" >Email</label>
						<div class="input">
							<input type="email" name="email" id="email" value="${email}">
						</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="name">Name</label>
						<div class="input">
							<input type="text" name="name" id="name" value="${name}">
						</div>
				</td>
			</tr>
			<tr>
				<td>
						<label for="Surname">Surname</label>
						<div class="input">
							<input type="text" name="surName" id="Surname" value="${surName}">
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
						<input type="password" name="rePassword" id="password" value="">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="country">Country</label>
					<div class="input">
						<input type="text" name="country" id="country" value="${country}">
					</div>
					<label for="city">City</label>
					<div class="input">
						<input type="text" name="city" id="city" value="${city}">
					</div>
					<label for="street">Street</label>
					<div class="input" type="text" name = "street" width = "40px">
						<input type="text" name="street" id="street" value="${street}">
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
					<c:if test="${error == true}">
						<p style="color:red">sorry, wrong data</p>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<div> If you are registered, please<a href="./login"> Sign in.</a></div>
				</td>
			</tr>
		</table>
			</div>	
		
	</form>
		</c:if>
		<c:if test = "${form == false}">
			<script>
				var wrapperRegister = document.querySelector("#wrapper-register-page");
				var newDiv = document.createElement("div");
				newDiv.classList.add("grateful-for-register");
				var paragraph = document.createElement("p");
				paragraph.textContent = "Thank you for your register";
				newDiv.appendChild(paragraph);
				wrapperRegister.appendChild(newDiv);
				setTimeout(function(){
					window.location.replace("/Laba2Library/Max/MainPage.php");
					},1500);
			</script>
		</c:if>
	</div>
	
</main>
<%@include file="/WEB-INF/static/footer.jsp"%>