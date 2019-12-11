(function(){

	
	
	var BookEditView = {

			editBook : function(id,element){	
			var book = window.BookList.getBookById(id);
			var modal = document.createElement("div");
			var bookHidden = document.createElement("input");

			bookHidden.setAttribute("type","hidden");
			bookHidden.setAttribute("value",book.id);
			bookHidden.setAttribute("name","bookId");


			modal.classList.add("modal"); // первый div

			var modalContent = document.createElement("div");
			modalContent.classList.add("modal-content"); // второй div

			var span = document.createElement("span"); // кнопка закрытия окна
			span.classList.add("close");

			var i = document.createElement("i");
			i.classList.add("fas");
			i.classList.add("fa-times");
			span.appendChild(i);
			


			var container = document.createElement("div"); // контейнер
			container.classList.add("container");
			var form = document.createElement("form");
			form.setAttribute("action","/Laba2Library/Max/EditBook.php");
			form.setAttribute("method","post");
			form.setAttribute("enctype","multipart/form-data");
			var row1 = document.createElement("div"); // ряд для изменений
			row1.classList.add("row");
			row1.classList.add("inputs-modal");

			var colBookName = document.createElement("div");
			colBookName.classList.add("col-2");
			colBookName.textContent = "Book name";
			var colBookNameInput = document.createElement("div");
			colBookNameInput.classList.add("col-2");
			var inputBookName = document.createElement("input");
			inputBookName.classList.add("textinput");
			inputBookName.setAttribute("type","text");
			inputBookName.setAttribute("name","name");
			inputBookName.setAttribute("value",book.name);

			colBookNameInput.appendChild(inputBookName);
			row1.appendChild(colBookName);
			row1.appendChild(colBookNameInput);

			var row2 = document.createElement("div"); // ряд для изменений
			row2.classList.add("row");
			row2.classList.add("inputs-modal");

			var colBookDesc = document.createElement("div");
			colBookDesc.classList.add("col-2");
			colBookDesc.textContent = "Book Description";
			var colBookDescInput = document.createElement("div");
			colBookDescInput.classList.add("col-2");
			var inputBookDesc = document.createElement("textarea");
			inputBookDesc.classList.add("textinput");
			inputBookDesc.setAttribute("name","description");
			inputBookDesc.id = "textArea";
			inputBookDesc.textContent = book.description;

			colBookDescInput.appendChild(inputBookDesc);
			row2.appendChild(colBookDesc);
			row2.appendChild(colBookDescInput);

			var row3 = document.createElement("div"); // ряд для изменений
			row3.classList.add("row");
			row3.classList.add("inputs-modal");

			var colBookGenre = document.createElement("div");
			colBookGenre.classList.add("col-2");
			colBookGenre.textContent = "Book Genre";
			var colBookGenrecInput = document.createElement("div");
			colBookGenrecInput.classList.add("col-2");
			var inputBookGenre = document.createElement("input");
			inputBookGenre.classList.add("textinput")
			inputBookGenre.setAttribute("name","genre");
			inputBookGenre.setAttribute("type","text");
			inputBookGenre.setAttribute("value",book.genre);
			

			colBookGenrecInput.appendChild(inputBookGenre);
			row3.appendChild(colBookGenre);
			row3.appendChild(colBookGenrecInput);


			var row5 = document.createElement("div"); // ряд для изменений
			row5.classList.add("row");
			row5.classList.add("inputs-modal");

			var colBookAuthorName = document.createElement("div");
			colBookAuthorName.classList.add("col-2");
			colBookAuthorName.textContent = "Author name";
			var colBookAuthorNameInput = document.createElement("div");
			colBookAuthorNameInput.classList.add("col-2");
			var inputBookAuthorName = document.createElement("input");
			inputBookAuthorName.classList.add("textinput");
			inputBookAuthorName.setAttribute("type","text");
			inputBookAuthorName.setAttribute("name","authorName");
			inputBookAuthorName.setAttribute("value",book.authorName);
			

			colBookAuthorNameInput.appendChild(inputBookAuthorName);
			row5.appendChild(colBookAuthorName);
			row5.appendChild(colBookAuthorNameInput);

			var row6 = document.createElement("div"); // ряд для изменений
			row6.classList.add("row");
			row6.classList.add("inputs-modal");

			var colBookYear = document.createElement("div");
			colBookYear.classList.add("col-2");
			colBookYear.textContent = "Book year";
			var colBookYearInput = document.createElement("div");
			colBookYearInput.classList.add("col-2");
			var inputBookYear = document.createElement("input");
			inputBookYear.classList.add("textinput");
			inputBookYear.setAttribute("type","text");
			inputBookYear.setAttribute("name","year");
			inputBookYear.setAttribute("value",book.year);
			

			colBookYearInput.appendChild(inputBookYear);
			row6.appendChild(colBookYear);
			row6.appendChild(colBookYearInput);

			var row7 = document.createElement("div"); // ряд для изменений
			row7.classList.add("row");
			row7.classList.add("inputs-modal");

			var colBookButton = document.createElement("div");
			colBookButton.classList.add("col-2");
			var button = document.createElement("input");
			// button.classList.add("far");
			// button.classList.add("fa-share-square");
			// button.classList.add("edit-movie-button");
			button.setAttribute("type","submit");
			colBookButton.appendChild(button);
			row7.appendChild(colBookButton);

			var row8 = document.createElement("div"); // ряд для изменений
			row8.classList.add("row");
			row8.classList.add("inputs-modal");

			var colBookImage = document.createElement("div");
			colBookImage.classList.add("col-2");
			colBookImage.textContent = "Book Image";
			var colBookImageInput = document.createElement("div");
			colBookImageInput.classList.add("col-2");
			var inputBookImage = document.createElement("input");
			inputBookImage.classList.add("textinput");
			inputBookImage.setAttribute("type","file");
			inputBookImage.setAttribute("name","file");
			inputBookImage.setAttribute("value",book.imgSource);
			colBookImageInput.appendChild(inputBookImage);
			row8.appendChild(colBookImage);
			row8.appendChild(colBookImageInput);

			var row9 = document.createElement("div"); // ряд для изменений
			row9.classList.add("row");
			row9.classList.add("inputs-modal");

			var colBookCheck = document.createElement("div");
			colBookCheck.classList.add("col-2");
			var checkBox = document.createElement("input");
			checkBox.setAttribute("type","checkbox");
			checkBox.setAttribute("name","check");
			var labelForCheckBox = document.createElement("label");
			labelForCheckBox.appendChild(checkBox);
			var p = document.createElement("p");
			p.textContent = "check, if you want to clear default book photo";
			labelForCheckBox.appendChild(p);
			colBookCheck.appendChild(labelForCheckBox);
			row9.appendChild(colBookCheck);
			
			form.appendChild(row1);
			form.appendChild(row2);
			form.appendChild(row3);
			form.appendChild(row5);
			form.appendChild(row6);
			form.appendChild(row8);
			form.appendChild(row9);
			form.appendChild(row7);
			form.appendChild(bookHidden);
			container.appendChild(form);
			modalContent.appendChild(span);
			modalContent.appendChild(container);
			modal.appendChild(modalContent);
			element.appendChild(modal);
			
	},
	clear : function(element){
		var modal = document.querySelector(".modal");
		element.removeChild(modal);
	},
	}

window.BookEditView = BookEditView;
}());