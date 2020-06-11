<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
	<fmt:bundle basename="ressources" prefix="title_">
		<fmt:message key="theme"/>
	</fmt:bundle>
</title>
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
	
	<form action="themes.do?action=InitUpdateTheme" method="post" id="contact" onsubmit="return valider()">
		<input id="themeId" name="themeId" type="hidden" value="${theme.getIdtheme() }">
		<input id="themeName" name="themeName" type="hidden" value="${theme.getNom() }">
		<input id="themeDesc" name="themeDesc" type="hidden" value="${theme.getDescription() }">
		<input id="themeDetail" name="themeDetail" type="hidden" value="${theme.getDescriptionDetaillee() }">
		<input id="themeColor" name="themeColor" type="hidden" value="${theme.getCouleur() }">
		<button type="submit">
			<fmt:bundle basename="ressources" prefix="btn_">
				<fmt:message key="update"/>
			</fmt:bundle>	
		</button>
	</form>
	
	<form action="themes.do?action=DeleteTheme" method="post" id="contact" onsubmit="return valider()">
		<input id="themeId" name="themeId" type="hidden" value="${theme.getIdtheme() }">
		<button type="submit">
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