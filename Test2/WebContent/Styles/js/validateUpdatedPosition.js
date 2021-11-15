/**
 * 
 */

function updatePosition(){
	
	var x = document.forms["editPosition"]["NewPositionName"].value;
	  if (x == "") {
	    alert("Position name is empty");
	    return false;
	  }
	  
	  var x = document.forms["editPosition"]["NewPositionName"].value;
	  var letters = /^[A-Za-z]+$/;
	  if (!x.match(letters)) {
	    alert("Enter letters Only");
	    return false;
	  }
	  
	  var x = document.forms["editPosition"]["NewSalary"].value;
	  if (x == "") {
	    alert("Basic Salary empty");
	    return false;
	  }
	  
	  var y = document.forms["editPosition"]["NewSalary"].value;
	  var numbers = /^[0-9]+$/;
	  if (!y.match(numbers)) {
	    alert("Enter number only");
	    return false;
	  }
	  
	  
	  
//	  var p = document.forms["editPosition"]["NewSalary"].value;
//	  var re = /^\d+(?:[.,]\d+)*$/gm;
//	  var str = '1234\n1,234\n1.234\n1,23,334\n1.23.334\n1,23,334.00\n1.23.334,00\n1,23...233\n1,23.';
//
//	  while ((p = re.exec(str)) != null) {
//	  if (p.index == re.lastIndex) {
//		  alert("Enter a valid amount");
//	  re.lastIndex++;
//	  }
//	 }
}