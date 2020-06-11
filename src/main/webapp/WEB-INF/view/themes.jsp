<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
	<fmt:bundle basename="ressources" prefix="msg_">
		<fmt:message key="welcome"/>
	</fmt:bundle>
	${user.getPrenom() }
</h1>
<h2>
	<fmt:bundle basename="ressources" prefix="msg_">
		<fmt:message key="list"/>
	</fmt:bundle>
</h2>

<c:forEach var="theme" items="${themes }">

	<fmt:bundle basename="ressources" prefix="lbl_">
		<fmt:message key="listname"/>
	</fmt:bundle>
	${theme.getNom() }
	<br>
	
	<fmt:bundle basename="ressources" prefix="lbl_">
		<fmt:message key="listdesc"/>
	</fmt:bundle>
	${theme.getDescription() }
	<br>
	
	<fmt:bundle basename="ressources" prefix="lbl_">
		<fmt:message key="listdetdesc"/>
	</fmt:bundle>
	${theme.getDescriptionDetaillee() }
	<br>
	
	<form action="themes.do?action=InitUpdateTheme" method="post">
		<button type="submit" name="btn_update" value="btn_update">
			<fmt:bundle basename="ressources" prefix="btn_">
				<fmt:message key="update"/>
			</fmt:bundle>
		</button>
	</form>
	
	<form action="themes.do?action=InitDeleteTheme" method="post">
		<button type="submit" name="btn_delete" value="btn_delete">
			<fmt:bundle basename="ressources" prefix="btn_">
				<fmt:message key="delete"/>
			</fmt:bundle>
		</button>
	</form>
	<br>
</c:forEach>

<form action="themes.do?action=InitCreateTheme" method="post">
	<button type="submit" name="btn_create" value="btn_create">
		<fmt:bundle basename="ressources" prefix="btn_">
			<fmt:message key="create"/>
		</fmt:bundle>
	</button>
</form>

</body>
</html>