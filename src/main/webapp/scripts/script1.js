
function down(){
var a = document.querySelector("#test");

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
var button = document.querySelector("#socialbutton");
button.addEventListener("click",down);

