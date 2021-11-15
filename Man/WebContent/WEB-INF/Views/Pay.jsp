<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type = "text/css" href=payroll.css />
<meta charset="ISO-8859-1">
<title>Payroll slip</title>
</head>
<body>
<div class="nmd1">
	<h4> Payroll Slip</h4>
</div>	
	<%
		String empid = (String)request.getAttribute("empid");
		String empname = (String)request.getAttribute("empname");
		int hours = (Integer)request.getAttribute("hours");
		int rate = (Integer)request.getAttribute("rate");
		double basic = (Double)request.getAttribute("basic");
		double taxes = (Double)request.getAttribute("taxes");
		double bonus = (Double)request.getAttribute("bonus");	
		double grossPay = (Double)request.getAttribute("gross");
		double netPay = (Double)request.getAttribute("netPay");
		double salary = (Double)request.getAttribute("salary");
	
	%>
<div class="nmd2">
	<table id="table_payroll">
		<tr>
			<td>Employee ID :</td>
			<td><input type="text" name="empid" value="<%=empid%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Employee Name :</td>
			<td><input type="text" name="name" value="<%=empname%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Number of Hours Worked :</td>
			<td><input type="text" name="hours" value="<%=hours%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Hourly Rate :</td>
			<td><input type="text" name="rate" value="<%=rate%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Basic Salary :</td>
			<td><input type="text" name="basic" value="<%=basic%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Taxes Withholding Rate :</td>
			<td><input type="text" name="taxes" value="<%=taxes%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Bonus :</td>
			<td><input type="text" name="bonus" value="<%=bonus%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Gross Pay :</td>
			<td><input type="text" name="grossPay" value="<%=grossPay%>" disabled="disabled" ></td>
		</tr>
		
		<tr>
			<td>Net Pay :</td>
			<td><input type="text" name="netPay" value="<%=netPay%>" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>Salary :</td>
			<td><input type="text" name="salary" value="<%=salary%>" disabled="disabled"></td>
		</tr>
	</table>
</div>	
</body>
</html>