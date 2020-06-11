<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="themes.do?action=UpdateTheme" method="POST"
		onsubmit="return valider()">

		<label for="name">
			<fmt:bundle basename="ressources" prefix="lbl_">
				<fmt:message key="listname"/>
			</fmt:bundle>
		</label>
		<input type="text" name="name" value="${themeName }"><br>
		<label for="description">
			<fmt:bundle basename="ressources" prefix="lbl_">
				<fmt:message key="listdesc"/>
			</fmt:bundle>
		</label>
		<textarea id= "description" name="description" rows="2" cols="30">${themeDesc }</textarea><br>
		<label for="detailed">
			<fmt:bundle basename="ressources" prefix="lbl_">
				<fmt:message key="listdetdesc"/>
			</fmt:bundle>
		</label>
		<textarea id= "detailed" name="detailed" rows="5" cols="30">${themeDetail }</textarea><br>
		<label for="color">
			<fmt:bundle basename="ressources" prefix="lbl_">
				<fmt:message key="color"/>
			</fmt:bundle>
		</label>
		<input type="color" name="color" value="${themeColor }">
		<br>
		<br>
		<button type="reset">
			<fmt:bundle basename="ressources" prefix="btn_">
				<fmt:message key="reset"/>
			</fmt:bundle>
		</button>
		<button type="submit">
			<fmt:bundle basename="ressources" prefix="btn_">
				<fmt:message key="submit"/>
			</fmt:bundle>
		</button>
		<br>
	</form>
	
	<form action="themes.do?action=InitTheme" method="post">
	<button type="submit" name="btn_return" value="btn_return">
		<fmt:bundle basename="ressources" prefix="btn_">
			<fmt:message key="return"/>
		</fmt:bundle>
	</button>
	</form>

</body>
</html>