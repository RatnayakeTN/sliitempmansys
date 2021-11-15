 
function validateForm() {
  var x = document.forms["ApplyLeaves"]["from_date"].value;
  var y = document.forms["ApplyLeaves"]["to_date"].value;
  var f = document.forms["ApplyLeaves"]["from_time"].value;
  var t = document.forms["ApplyLeaves"]["to_time"].value;
  var a = document.forms["ApplyLeaves"]["Leave_type"].value;
  
  if (x >= y ) {
    alert("Applied Dates does not exsist");
    return false;
  }
   if(f >= t){
		  alert("Applied Time does not exsist");
		  return false;
	  
	  
  }
}
