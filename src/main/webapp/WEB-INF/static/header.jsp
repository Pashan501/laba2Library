<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="style/style1.css">
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
   							<li class="nav-buttons"><a href="#">Science</a></li>
   							<li class="nav-buttons"><a href="#">Biographies</a></li>
   							<li class="nav-buttons"><a href="#">Romance</a></li>
							</ul>
						</span>
					</div>
					<div class="col-2 choosing-nav">
						<span class="nav-buttons">My Books
							<ul class="lists dropDownHide">
   							<li class="nav-buttons"><a href="#">Science</a></li>
   							<li class="nav-buttons"><a href="#">Biographies</a></li>
   							<li class="nav-buttons"><a href="#">Romance</a></li>
							</ul>
						</span>
					</div>
					<div class="col-6 " id = "search-wrapper" name = "search">
						<input type="text"  id="myInput" placeholder="Search">
					</div>
					<c:choose>
							<c:when test='${sessionScope.user == null && sessionScope.admin == null}'>
								<div class="col-2 choosing-nav">
								<a href="/Laba2Library/login" id="logIn-label">Log in</a>
								</div>
							</c:when>
							<c:otherwise>
								<!-- <div class="col-2 choosing-nav">
								<a href="" id="logIn-label">Login in</a>
								</div> -->
							</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</nav>
	</header>
