<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
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