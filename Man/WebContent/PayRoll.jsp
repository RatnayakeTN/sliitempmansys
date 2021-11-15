<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type = "text/css" href=payroll.css />
<meta charset="ISO-8859-1">
<title>Payroll</title>
</head>
<body>
<div class="nmd1">
	<h4>PayRoll</h4>
</div>
<div class="nmd2">
	<form name="form" method="post" action="PayrollCalServlet">
		<table id="table_payroll">
			<tr>
				<td>Employee ID : </td><td><input type="text" name="empid"></td>
			</tr>
			<tr>
				<td>Employee Name : </td><td><input type="text" name="empname"></td>
			</tr>
				
			<tr>
				<td>Number of Hours worked :</td><td><input type="text" name="hours"></td>
			</tr>
			
			<tr>
				<td>Hourly Rate :</td><td><input type="text" name="rate"></td>
			</tr>
			
			<tr>
				<td>Basic Salary :</td><td><input type="text" name="basic"></td>
			</tr>
			
			<tr>
				<td>Tax :</td><td><input type="text" name="taxes"></td>
			</tr>
			
			<tr>
				<td>Bonus :</td><td><input type="text" name="bonus"></td>
			</tr>
			
				
			<tr>
				<td><input type="submit" value="Calculate Salary" id="button_payroll"></td>
			</tr>
			
		</table>
	</form>
</div>
</body>
</html>