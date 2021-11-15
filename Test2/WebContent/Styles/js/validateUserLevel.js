/**
 * 
 */

function validateUserLevel(){
	
	var x = document.forms["addNewUserLevel"]["Ulevel"].value;
	  if (x == "") {
	    alert("User Level is empty");
	    return false;
	  }
	  
	  var x = document.forms["addNewUserLevel"]["Ulevel"].value;
	  var letters = /^[A-Za-z]+$/;
	  if (!x.match(letters)) {
	    alert("Enter letters Only");
	    return false;
	  }
	  
	  var x = document.forms["addNewUserLevel"]["No"].value;
	  if (x == "") {
	    alert("Number is empty");
	    return false;
	  }
	  
	  var y = document.forms["addNewUserLevel"]["No"].value;
	  var numbers = /^[0-9]+$/;
	  if (!y.match(numbers)) {
	    alert("Enter numbers Only");
	    return false;
	  }
}