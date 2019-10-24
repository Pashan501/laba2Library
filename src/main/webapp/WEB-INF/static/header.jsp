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
				<div class="row">
					<div class="col-2">
						<img src="img/logolabrary-cover.jpg" alt="our logo library">
					</div>
					<div class="col-1">
						<a id="socialbutton">Browse</a>
							<ul class="nav-token" class="dropDownHide">
   							<li class="nav-token"><a href="#">Facebook</a></li>
   							<li class="twitter"><a href="#">Twitter</a></li>
   							<li class="gplus"><a href="#">Google Plus</a></li>
   							<li class="vk"><a href="#">ВКонтакте</a></li>
   							<li class="rss"><a href="#">RSS</a></li>
							</ul>
					</div>
					<!-- <c:if test='${user.type == "admin"}'>
						
					</c:if> -->
				</div>
			</div>
		</div>
	</nav>
	</header>
