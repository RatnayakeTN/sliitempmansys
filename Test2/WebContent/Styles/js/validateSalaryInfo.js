/**
 * 
 */

function validate() {
	
  var x = document.forms["addBasicSalaryInfo"]["employeeid"].value;
  if (x == "") {
    alert("Select Employee");
    return false;
  }
  var x = document.forms["addBasicSalaryInfo"]["basicsalary"].value;
  if (x == "") {
    alert("Please insert Basic Salary");
    return false;
  }
  
  var y = document.forms["addBasicSalaryInfo"]["basicsalary"].value;
  var numbers = /^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(numbers)) {
    alert("Please Enter a Valid Amount for Basic Salary");
    return false;
  }
  
  
  var x = document.forms["addBasicSalaryInfo"]["allowances"].value;
  if (x == "") {
	    alert("Please insert Allowance Amount");
	    return false;
  }
  
 
  var y = document.forms["addBasicSalaryInfo"]["allowances"].value;
  var numbers = /^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(numbers)) {
    alert("Please Enter a Valid Amount for Allowances");
    return false;
  }
  
}