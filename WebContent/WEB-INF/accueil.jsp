<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Accueil" />
</jsp:include>
<body>
<p>
<%
org.gestionecole.beans.User notreBean  = (org.gestionecole.beans.User) request.getAttribute("personne");
out.println( notreBean.getLogin() );
out.println( notreBean.getPassword() );
%>
</p>
</body>
</html>