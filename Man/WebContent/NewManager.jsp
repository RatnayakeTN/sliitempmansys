<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type = "text/css" href=manager.css />
<title>EMS - Manager Management</title>
</head>
<body>

<div class="nmd1">
	<h4>New Manager Addition </h4></br>
</div>
	<h5>Enter the New Manager's Details </h5>
<div class="nmd2">
	<form method="POST" action="AddManagerServlet">
		<table>
			<tr id="table_man">
				<td>Manager Name</td>
				<td><input type="text" name="managerName"/></td>
			</tr>
			
			<tr id="table_man">
				<td>Department</td>
				<td><input type="text" name="department"/></td>
			</tr>
			
			<tr id="table_man">
				<td>Address</td>
				<td><input type="text" name="address"/></td>
			</tr>
			
			<tr id="table_man">
				<td>Qualifications</td>
				<td><input type="text" name="qualifications"/></td>
			</tr>
			
			<tr id="table_man">
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male" checked="checked"/>Male</td>
			
				<td><input type="radio" name="gender" value="female"/>Female</td>
			
			</tr>
		
			<tr>
				<td><input type="submit" value="Add Manager" class="btn1" id="button_new_man" /> </td>
			</tr>
		</table>
	</form>
</div>

	<form method="POST" action="ListManagerServlet">
		
			<td><input type="submit" value="Show Existing Managers" class="btn2" id="button_new_man" /></td>
			
	</form>

	

</body>
</html>