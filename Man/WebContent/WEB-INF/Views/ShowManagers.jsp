<%@page import="com.man.model.Manager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.man.service.ManagerService"%>
<%@page import="com.man.service.IManagerService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "manager.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager</title>
</head>
<body>
<div class="nmd1">
	<h4>List of Managers</h4>
</div>	

	<table id="table_man">

		<caption><h5>Managers</h5></caption></caption>
		
		
		  <tr>
                <th>Manager ID</th>
                <th>Manager Name</th>
                <th>Department</th>
                <th>Address</th>
                <th>Qualifications</th>
                <th>Gender</th>
                <th>Select</th>
          </tr>		
	
	
	 <%
        IManagerService iManagerService = new ManagerService();
	 	ArrayList<Manager> arr = iManagerService.getAllManagers();
			
		for(Manager manager : arr){
	%>
	 <tr id="tr_hov">
				<td> <%=manager.getManagerID() %> </td>
				<td> <%=manager.getName() %> </td>
				<td> <%=manager.getDepartment() %> </td>
				<td> <%=manager.getAddress() %> </td>
				<td> <%=manager.getQualifications() %> </td>
				<td> <%=manager.getGender() %> </td>	
				<td> 
				<form method="POST" action="GetManagerServlet">
				<input type="hidden" name="managerID" value="<%=manager.getManagerID()%>"/>
				 <input type="submit" value= "Select Manager" class="btn4" id="button_s_man" /> 
			 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
	
		</table>
	</div>
	<div>
	</br>
	</br>
		<a href="NewManager.jsp">ADD MANAGER</a>
	</div>	
	
</body>
</html>