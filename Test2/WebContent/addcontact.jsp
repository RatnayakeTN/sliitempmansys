<%@page import="com.handlers.ContactDao"%>
<jsp:useBean id="u" class="model.Contact"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	int i=ContactDao.insert(u);
	if(i>0){
		response.sendRedirect("addcontactsuccess.jsp");
	}else{
		response.sendRedirect("addcontacterror.jsp");
}
%>