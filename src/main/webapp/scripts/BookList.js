(function(){

	var BookList = {
		listBooks : undefined,

		getAllBooks : async function(){
			var promise = new Promise(function(resolve,reject){
				$.ajax({

				url: "/Laba2Library/Max/BookAjax.php",
				method: "GET",
				data: "",
				error: function(message){
					console.log("ERROR");
				},

				success : function(data){
					resolve(data);
				},
			});

			});

			this.listBooks = await promise;
			return promise;
		},

		getBookById : function(id){
			var book =  this.listBooks.find(item => item.id == id);
		

		return book;
		},

		removeBookById : function(bookId){
			$.ajax({

				url: "/Laba2Library/Max/BookAjax.php",
				method:"POST",
				data: JSON.stringify(window.BookList.getBookById(bookId)),
				contentType: "application/json",
				dataType: "json",
				async:false,
				cache:false,
				processData:false,
				error: function(message){
					console.log("ERROR");
				},

				success : function(data){
					console.log("SUCCESS");
				},
			});
		}

		}
	window.BookList = BookList;
}());