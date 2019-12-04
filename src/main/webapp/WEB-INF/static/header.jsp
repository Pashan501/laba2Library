<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="../style/style1.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div class = "main-wrapper">
	<header>
		<nav>
		<div class="wrapper nav-wrapper">
			<div class="container">
				<div class="row main-row-1">
					<div class="col-2 choosing-nav">
						<span class="nav-buttons">Browse
							<ul class="lists dropDownHide">
   							<li class="nav-buttons"><a href="/Laba2Library/Max/MainPage.php">All Books</a></li>
   							<li class="nav-buttons"><a href="#">Biographies</a></li>
   							<li class="nav-buttons"><a href="#">Romance</a></li>
							</ul>
						</span>
					</div>
					<div class="col-2 choosing-nav">
						<span class="nav-buttons">My Books
							<ul class="lists dropDownHide">
   							<li class="nav-buttons"><a href="#">Penis</a></li>
   							<li class="nav-buttons"><a href="#">Biographies</a></li>
   							<li class="nav-buttons"><a href="#">Romance</a></li>
							</ul>
						</span>
					</div>
					<div class="col-6 " id = "search-wrapper" name = "search">
						<input type="text"  id="myInput" placeholder="Search">
					</div>
					<c:choose>
							<c:when test='${sessionScope.user == null}'>
								<div class="col-1 choosing-nav">
								<a href="/Laba2Library/Max/Login.php" class="login-and-register-label">Log in</a>
								</div>
								<div class="col-1 choosing-nav">
								<a href="/Laba2Library/Max/Register.php" class="login-and-register-label">Register</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-2 choosing-nav">
									<span id="user-view-in-header">
										<p id= "user-view-name">${sessionScope.user.name}</p> 
									<a href="/Laba2Library/Max/Logout.php?logout=1" id="logout-button"><i class="fas fa-sign-out-alt logout-value"></i></a>
									</span>
								</div>
							</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</nav>
	</header>
