/**
 * 
 */

function validatePosition(){
	
	var x = document.forms["addNewPosition"]["PositionName"].value;
	  if (x == "") {
	    alert("Position name is empty");
	    return false;
	  }
	  
	  var x = document.forms["addNewPosition"]["PositionName"].value;
	  var letters = /^[A-Za-z]+$/;
	  if (!x.match(letters)) {
	    alert("Enter letters Only");
	    return false;
	  }
	  
	  var x = document.forms["addNewPosition"]["BasicSalary"].value;
	  if (x == "") {
	    alert("Basic Salary empty");
	    return false;
	  }
	  
	  var y = document.forms["addNewPosition"]["BasicSalary"].value;
	  var numbers = /^[0-9]+$/;
	  if (!y.match(numbers)) {
	    alert("Enter numbers Only");
	    return false;
	  }
	  

}