<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="style/style1.css">
</head>
<body>
	<header>
		<nav>
		<div class="wrapper">
			<div class="container">
				<div class="row main-row-1">
					<div class="col-2">
						<span class="nav-buttons">Browse</span>
							<ul class="lists dropDownHide">
   							<li class="nav-buttons"><a href="#">Science</a></li>
   							<li class="nav-buttons"><a href="#">Biographies</a></li>
   							<li class="nav-buttons"><a href="#">Romance</a></li>
							</ul>
					</div>
					<div class="col-2">
						<span class="nav-buttons">My Books</span>
							<ul class="lists dropDownHide">
   							<li class="nav-buttons"><a href="#">Science</a></li>
   							<li class="nav-buttons"><a href="#">Biographies</a></li>
   							<li class="nav-buttons"><a href="#">Romance</a></li>
							</ul>
					</div>
					<!-- <c:if test='${user.type == "admin"}'>
						
					</c:if> -->
				</div>
			</div>
		</div>
	</nav>
	</header>
