(function(){

var BookView = {

	render: function(book,element,type){
		if(element.children.length  < 4){
			
			var book1Colum = document.createElement("div");
			book1Colum.classList.add("col-4");

			var book1Container = document.createElement("div");
			book1Container.classList.add("book-container");
			var bookImg = document.createElement("img");
			var hiddenId = document.createElement("input");
			hiddenId.setAttribute("type","hidden");
			hiddenId.setAttribute("value",book.id);

			if(type == "admin"){
				var deleteButton = document.createElement("i");
					deleteButton.classList.add("fas");
					deleteButton.classList.add("fa-trash-alt");
					deleteButton.classList.add("delete-button-hover");
					deleteButton.style.color = "white";
					deleteButton.style.display = "flex";
					deleteButton.style.justifyContent = "center";
					deleteButton.style.alignItems = "center";
					deleteButton.style.position = "relative";
					deleteButton.style.top = "50px";

					function remove(){
						var agreement = confirm("Are you sure you want to delete the book " + book.name + " ?");
						if(agreement){

							console.log(hiddenId.getAttribute("value"));
							window.BookList.removeBookById(hiddenId.getAttribute("value"));
							window.location.reload();
						}
					};
				
				var photoBookDivWithParams = document.createElement("div");
				bookImg.addEventListener("mouseover",function(e){
					photoBookDivWithParams.style.position = "absolute";
					photoBookDivWithParams.style.width = bookImg.width;
					photoBookDivWithParams.style.height = bookImg.height;
					photoBookDivWithParams.style.background = "rgb(0,0,0,0.5)";
					deleteButton.addEventListener("click",remove);
					photoBookDivWithParams.appendChild(deleteButton);
					book1Container.appendChild(photoBookDivWithParams);
					book1Container.appendChild(hiddenId);
				});


				photoBookDivWithParams.addEventListener("mouseout",function(e){
					book1Container.removeChild(photoBookDivWithParams);
					book1Container.removeChild(hiddenId);
				});

			}
			bookImg.setAttribute("src",book.imgSource);
			bookImg.classList.add("book-img-size");
			var bookLinkingName = document.createElement("a");
			bookLinkingName.textContent = book.name;
			bookLinkingName.setAttribute("href","/Laba2Library/Max/SingleBookPage.php?bookId="+hiddenId.getAttribute("value"));
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