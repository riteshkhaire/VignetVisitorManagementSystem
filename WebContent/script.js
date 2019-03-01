/**
 * 
 */
var tabButtons = doucumet
		.querySelectorAll(".tabContainer .buttonContainer button");
var tabPanels = doucumet.querySelectorAll(".tabContainer .tabPanel");

function showPanel(panelIndex, colorCode) {
	tabButtons.forEach(function(node){
		node.style.backgroundColor="";
		node.style.color="";
	});
	tabButtons[panelIndex].style.backgroundColor=colorCode;
	tabButtons[panelIndex].style.color="white";
	
	tabPanels.forEach(function(node){
		node.style.display="none";
	});
	tabPanels[panelIndex].style.display="block";
	tabPanels[panelIndex].style.backgroundColor=colorCode;

}

function validateForm() {
	var pass = document.forms["SignUp"]["newUserPassword"].value;
	var rePass = document.forms["SignUp"]["newUserRePassword"].value;
	
	var uname=document.forms["addExpectedVisitor"]["visitorName"].value;
	var email=document.forms["addExpectedVisitor"]["visitorEmailId"].value;
	var mobile=document.forms["addExpectedVisitor"]["visitorMobileNumber"].value;
	var date=document.forms["addExpectedVisitor"]["expectedVisitDate"].value;
	var intime=document.forms["addExpectedVisitor"]["expectedVisitTime"].value;
	var purpose=document.forms["addExpectedVisitor"]["purpose"].value;

	if (uname == "" || email=="" ||mobile== "" || date==""||intime==""||purpose=="") {
	    alert("Please fill all mandetory fields ");
	    return false;
	  }



	
	
	

	var uname = doument.forms["SignUp"]["newName"].value;
	if (uname = "") {
		alert("Username Required");
		return false;

		if (pass != rePass) {
			alert("Password mismatch");
		}

	}
}
