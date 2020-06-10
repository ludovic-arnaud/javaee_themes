<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Bonjour ${user.getPrenom() }<br>
<br>
<h1>Liste des thèmes :</h1>
<br>
<c:forEach var="theme" items="${themes }">
	Nom : ${theme.getNom() }<br>
	Description : ${theme.getDescription() }<br>
	Description détaillée : ${theme.getDescriptionDetaillee() }<br>
	<br>
</c:forEach>

</body>
</html>