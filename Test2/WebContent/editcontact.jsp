<%@page import="com.handlers.ContactDao"%>  
<jsp:useBean id="u" class="model.Contact"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=ContactDao.update(u);  
response.sendRedirect("ShowContacts.jsp");  
%>