<%@include file="/WEB-INF/static/header.jsp"%>
<main id="main">
	<div class="container main-page-container">
		 <div class="row first-row-in-main-page">
			<!-- <div class="col-4">
				<div class="book-container">
					<img src="https://www.moscowbooks.ru/image/book/575/w259/i575271.jpg" alt="" class = "book-img-size">
					<a href="">Book name</a>
				</div>
			</div>  -->
		</div>
	</div>
</main>
<script src = "scripts/BookView.js"></script>
<script>
	console.log(document.querySelector(".row.first-row-in-main-page"));
	window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
	window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
	window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
	 window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
</script>
<%@include file="/WEB-INF/static/footer.jsp"%>