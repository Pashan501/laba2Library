function down(e){

	var child = e.target;
	if(child.firstElementChild != null)
	{
		if (child.firstElementChild.classList.contains("dropDownHide"))
		{
			child.firstElementChild.classList.remove("dropDownHide");
			child.firstElementChild.classList.add("dropDownShow");
			if(child.firstElementChild.classList.contains("dropDownShow"))
			{
					$(child.firstElementChild).mouseover(function(){

				child.firstElementChild.classList.remove("dropDownHide");
				child.firstElementChild.classList.add("dropDownShow");
		});
					$(child.firstElementChild).mouseout(function(){

				child.firstElementChild.classList.remove("dropDownShow");
				child.firstElementChild.classList.add("dropDownHide");
		});
			}
		$(child).mouseout(function(){

				child.firstElementChild.classList.remove("dropDownShow");
				child.firstElementChild.classList.add("dropDownHide");
		});
		}
	}
}

var catchTarget = document.querySelector(".row.main-row-1");
$(catchTarget).mouseover(down);


