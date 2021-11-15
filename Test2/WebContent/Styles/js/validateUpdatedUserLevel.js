/**
 * 
 */

function updateUserLevel(){
	
	var q = document.forms["editUserlevel"]["NewUlevel"].value;
	  if (q == "") {
	    alert("User Level field is empty");
	    return false;
	  }
	  
	  var y = document.forms["editUserlevel"]["NewUlevel"].value;
	  var letters = /^[A-Za-z]+$/;
	  if (!y.match(letters)) {
	    alert("Enter letters Only");
	    return false;
	  }
	  
	  var p = document.forms["editUserlevel"]["NewNo"].value;
	  if (p == "") {
	    alert("Number field is empty");
	    return false;
	  }
	  
	  var q = document.forms["editUserlevel"]["NewNo"].value;
	  var numbers = /^[0-9]+$/;
	  if (!q.match(numbers)) {
	    alert("Enter numbers Only");
	    return false;
	  }
}