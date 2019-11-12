(function(){

var BookView = {

	render: function(book,element){
		if(element.children.length  < 4){
			var book1Colum = document.createElement("div");
			book1Colum.classList.add("col-4");

			var book1Container = document.createElement("div");
			book1Container.classList.add("book-container");
			var bookImg = document.createElement("img");
			bookImg.setAttribute("src",book.imgSource);
			bookImg.classList.add("book-img-size");
			var bookLinkingName = document.createElement("a");
			bookLinkingName.textContent = book.name;
			bookLinkingName.setAttribute("href","");
			book1Container.appendChild(bookImg);
			book1Container.appendChild(bookLinkingName);
			book1Colum.appendChild(book1Container);
			element.appendChild(book1Colum);
		}else{
			if(element.nextSibling != null){
				this.render(book,element.nextSibling);
			}else{
				var mainPageContainer = document.querySelector(".container.main-page-container");
				var row = document.createElement("div");
				row.classList.add("row");
				mainPageContainer.appendChild(row);
				this.render(book,row);
			}
		}
	}
}

window.BookView = BookView;
}());