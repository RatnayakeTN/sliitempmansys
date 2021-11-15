/**
 * 
 */
function validateSalaryInfo() {
	
  var x = document.forms["updateBasicSalaryInfo"]["employeeid"].value;
  if (x == "") {
    alert("Select Employee");
    return false;
  }
  var x = document.forms["updateBasicSalaryInfo"]["basicsalary"].value;
  if (x == "") {
    alert("Please insert Basic Salary");
    return false;
  }
  
  var y = document.forms["updateBasicSalaryInfo"]["basicsalary"].value;
  var numbers = /^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(numbers)) {
    alert("Please Enter a Valid Amount for Basic Salary");
    return false;
  }
  
  
  var x = document.forms["updateBasicSalaryInfo"]["allowances"].value;
  if (x == "") {
	    alert("Please insert Allowance Amount");
	    return false;
  }
  
  var y = document.forms["updateBasicSalaryInfo"]["allowances"].value;
  var numbers = /^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(numbers)) {
    alert("Please Enter a Valid Amount for Allowances");
    return false;
  }
  
}