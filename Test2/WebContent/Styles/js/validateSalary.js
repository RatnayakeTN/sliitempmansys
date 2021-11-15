/**
 * 
 */

function validateSalary() {
	
  var x = document.forms["addSalary"]["emp_id"].value;
  if (x == "") {
    alert("Please Select Employee");
    return false;
  }
 
  var x = document.forms["addSalary"]["month"].value;
  if (x == "") {
	    alert("Please Select Year and Month");
	    return false;
  }
  
  var x = document.forms["addSalary"]["epf_deductions"].value;
  if (x == "") {
    alert("Please insert EPF Deductions");
    return false;
  }
  
//  var y = document.forms["addSalary"]["epf_deductions"].value;
//  var numbers = /^[0-9]+$/;
//  var decimal = /^[-+]?[0-9]+\.[0-9]+$/;
//  if (!y.match(numbers)) {
//    alert("Please enter a valid amount for EPF Deductions");
//    return false;
//  }
  
  var y = document.forms["addSalary"]["epf_deductions"].value;
  var decimal = /^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(decimal)) {
	    alert("Please enter a valid amount for EPF Deductions");
	    return false;
  }
  
  var x = document.forms["addSalary"]["OT"].value;
  if (x == "") {
    alert("Please insert Over Time Payments");
    return false;
  }
  
  var y = document.forms["addSalary"]["OT"].value;
  var numbers =/^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(numbers)) {
    alert("Please enter a valid amount for Over Time Payments");
    return false;
  }
  
  var x = document.forms["addSalary"]["deductions"].value;
  if (x == "") {
    alert("Please insert Other Deductions");
    return false;
  }
  
  
  var y = document.forms["addSalary"]["deductions"].value;
  var numbers = /^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(numbers)) {
    alert("Please enter a valid amount for Other Deductions");
    return false;
  }
  
  var x = document.forms["addSalary"]["net_salary"].value;
  if (x == "") {
	    alert("Please insert Net Salary");
	    return false;
  }
  
  var y = document.forms["addSalary"]["net_salary"].value;
  var numbers = /^[-+]?[0-9]+\.[0-9]+$/;
  if (!y.match(numbers)) {
    alert("Please enter a valid amount for Net Salary");
    return false;
  }
  
  


}