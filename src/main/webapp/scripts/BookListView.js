(function(){

	var BookListView = {

		renderAll:function(list,element,type){
			if(type == 'user')
				type = 'none';
			list.forEach(function(item){
				window.BookView.render(item,element,type);
			});
		}
	}

	window.BookListView = BookListView;
}());