
function down(){
	var a = document.querySelector(".lists");

	if (a.classList.contains("dropDownHide"))
	{
		a.classList.remove("dropDownHide");
		a.classList.add("dropDownShow");
	}else
		if(a.classList.contains("dropDownShow")){
			 a.classList.remove("dropDownShow");
		a.classList.add("dropDownHide");
		}	
}
var button = document.querySelector(".nav-buttons");
button.addEventListener("click",down);

