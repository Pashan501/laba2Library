(function(){

	var BookListView = {

		renderAll:function(list,element){
			console.log(list.length);
			list.forEach(function(item){
				window.BookView.render(item,element);
			});
		}
	}

	window.BookListView = BookListView;
}());