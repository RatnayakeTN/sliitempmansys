<%@page import="com.handlers.ContactDao"%>  
<jsp:useBean id="u" class="model.Contact"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
ContactDao.delete(u);  
response.sendRedirect("ShowContacts.jsp");   
%>