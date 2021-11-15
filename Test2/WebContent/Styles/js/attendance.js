/**
 * 
 */
function validate() {
  var x = document.forms["addNewRec"]["user"].value;
  if (x == "") {
    alert("UserName parameter not set");
    return false;
  }
  var x = document.forms["addNewRec"]["empId"].value;
  if (x == "") {
    alert("Employee ID must be filled out");
    return false;
  }
  var x = document.forms["addNewRec"]["date"].value;
  if (x == "") {
	    alert("Please set a date");
	    return false;
	  }
  
  var x = document.forms["addNewRec"]["inTime"].value;
  if (x == "") {
    alert("Please set a sign in time");
    return false;
  }
  var x = document.forms["addNewRec"]["outTime"].value;
  if (x == "") {
    alert("Please set a sign out time");
    return false;
  }
}

