<%@page import="com.man.model.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "manager.css" />
<meta charset="UTF-8">
<title>Handling Managers Details(Edit)</title>
</head>
<body>
<div class="nmd1">
	<h4>Edit information of a Manager</h4> 
</div>	
	<%
		Manager manager = (Manager)request.getAttribute("manager");
	%>

<div class="nmd2">
	<form method="POST" action="UpdateManagerServlet">
		
		<table >
			<tr id="table_man">
				<td>Manager ID</td>
				<td><input type="text" name="managerID" disabled="disabled"
					value="<%=manager.getManagerID()%>" /></td>
			</tr>
			<tr id="table_man">
				<td>Manager Name</td>
				<td><input type="text" name="managerName" disabled="disabled"
					value="<%=manager.getName()%>" /></td>
			</tr>
			<tr id="table_man">
				<td>Department</td>
				<td><input type="text" name="department"
					value="<%=manager.getDepartment()%>" /></td>
			</tr>
			
			<tr id="table_man">
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=manager.getAddress()%>" /></td>
			</tr>
			<tr id="table_man">
				<td>Qualifications</td>
				<td><input type="text" name="qualification"
					value="<%=manager.getQualifications()%>" /></td>
			</tr>
			<tr id="table_man">
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked"  /> Male</td>
			
				<td><input type="radio" name="gender" value="female"
					/> Female</td>
			</tr>
			<tr>
				<td><br/><input type="hidden" name="managerID"
					value="<%=manager.getManagerID()%>" /> <input type="submit"
					value="Update Manager" class="btn1" id="button_new_man"/></td>
			</tr>
		</table>
	</form>
</div>	
	
		
<div class="nmd2">		
				<form method="POST" action="DeleteManagerServlet">
					<input type="hidden" name="managerID"
						value="<%=manager.getManagerID()%>" /> <input type="submit"
						value="Delete Manager" class="btn3" id="button_new_man"/>
				</form>
				
				
			
</div>			

	
</body>
</html>