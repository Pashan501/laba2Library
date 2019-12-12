<%@include file="/WEB-INF/static/header.jsp"%>
<main id="main">
	<div class="container main-page-container">
		 <div class="row first-row-in-main-page"></div>
	</div>
</main>
    <script src="../scripts/BookList.js"></script>
<script src = "../scripts/BookView.js"></script>
<script src ="../scripts/BookListView.js"></script>
<script src = "../scripts/BookEditView.js"></script>
			<script>
					window.BookList.getAllBooks().then(function(list){
					window.BookListView.renderAll(list,document.querySelector(".row.first-row-in-main-page"), "${sessionScope.user.type}");
					});	
			</script>           
<%@include file="/WEB-INF/static/footer.jsp"%>