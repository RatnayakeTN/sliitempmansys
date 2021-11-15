/**
 * 
 */

function validateReg(){
	
	
	var x = document.forms["addNewUser"]["FirstName"].value;
	  if (x == "") {
	    alert("First name is empty");
	    return false;
	  }
	  
	  var a = document.forms["addNewUser"]["FirstName"].value;
	  var ltz = /^[A-Za-z]+$/;
	  if(!a.match(ltz)){
		  
		  alert("Enter letters only");
		  return false;
	  }
	  
	  
	  var x = document.forms["addNewUser"]["LastName"].value;
	  if (x == "") {
	    alert("Last name is empty");
	    return false;
	  }
	  
	  var q = document.forms["addNewUser"]["LastName"].value;
	  var lettersz = /^[A-Za-z]+$/;
	  if (!q.match(lettersz)) {
	    alert("Enter letters Only");
	    return false;
	  }
	  
	  var x = document.forms["addNewUser"]["Email"].value;
	  if (x == "") {
		    alert("Please Enter a Email");
		    return false;
		  }
	  
	  var y = document.forms["addNewUser"]["Email"].value;
	  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	  if (!y.match(mailformat)) {
		    alert("Please Enter a valid Email");
		    return false;
		  }
	  
	  var x = document.forms["addNewUser"]["ContactNo"].value;
	  if (x == "") {
	    alert("Please Enter a contact number");
	    return false;
	  }
	  
	  var y = document.forms["addNewUser"]["ContactNo"].value;
	  var numbers = /^[0-9]+$/;
	  if (!y.match(numbers)) {
	    alert("Enter only numbers");
	    return false;
	  }
	  
	  var x = document.forms["addNewUser"]["UserName"].value;
	  if (x == "") {
	    alert("Please Enter a username");
	    return false;
	  }
	  
	  var x = document.forms["addNewUser"]["Password"].value;
	  if (x == "") {
	    alert("Please Enter a password");
	    return false;
	  }
	  
	  var x = document.forms["addNewUser"]["RepeatPassword"].value;
	  if (x == "") {
	    alert("Re Enter the password");
	    return false;
	  }
	  
	  var x = document.forms["addNewUser"]["RepeatPassword"].value;
	  var y = document.forms["addNewUser"]["Password"].value;
	  if (x != y) {
	    alert("Password does not match");
	    return false;
	  }
	  
	  var x = document.forms["addNewUser"]["Address"].value;
	  if (x == "") {
	    alert("Please Enter a address");
	    return false;
	  }
	
}