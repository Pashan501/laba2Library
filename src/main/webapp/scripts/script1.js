function down(e){

	var child = e.target.firstElementChild;
	console.log(child);
	if(child==null)
		return;
	
	if (child.classList.contains("dropDownHide"))
	{
		child.classList.remove("dropDownHide");
		child.classList.add("dropDownShow");
		if(child.classList.contains("dropDownShow"))
		{
				$(child).mouseover(function(){

			child.classList.remove("dropDownHide");
			child.classList.add("dropDownShow");
	});
				$(child).mouseout(function(){

			child.classList.remove("dropDownShow");
			child.classList.add("dropDownHide");
	});
		}
	}
}
function up(e){
	var child = e.target.firstElementChild;
	console.log(child);
	if(child==null)
		return;

	if(child.classList.contains("dropDownShow"))
	{
		child.classList.remove("dropDownShow");
		child.classList.add("dropDownHide");
	}
	
}
var catchTarget = document.querySelector(".nav-buttons");
$(catchTarget).mouseover(down);

  $(catchTarget).mouseout(up);

