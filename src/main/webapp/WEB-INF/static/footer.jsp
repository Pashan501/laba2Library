<footer>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="../scripts/script1.js"></script>
    <script src="../scripts/BookList.js"></script>
<script src = "../scripts/BookView.js"></script>
<script src ="../scripts/BookListView.js"></script>
<script>
	
	// window.BookList.getAllBooks.then(function(fullfiled){window.BookList.listBooks = fullfiled},function(error){console.log("error")});
	window.BookList.getAllBooks().then(function(list){
		window.BookListView.renderAll(list,document.querySelector(".row.first-row-in-main-page"));
	});	
	// window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
	// window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
	// window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
	//  window.BookView.render({name:"HUY",imgSource:"img/logolabrary-cover.jpg"},document.querySelector(".row.first-row-in-main-page"));
</script>
</footer>
</div>
</body>
</html>
