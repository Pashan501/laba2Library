(function(){

	var BookList = {
		listBooks : undefined,

		getAllBooks : async function(){
			var promise = new Promise(function(resolve,reject){
				$.ajax({

				url: "/Laba2Library/BookServlet",
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
	}
	window.BookList = BookList;
}());