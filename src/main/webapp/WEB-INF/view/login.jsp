<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
	<fmt:bundle basename="ressources" prefix="title_">
		<fmt:message key="login"/>
	</fmt:bundle>
</title>
</head>
<body>

<form action="themes.do?action=Login" method="post" id="contact" onsubmit="return valider()">
<br>
	<div><label for="">
		<fmt:bundle basename="ressources" prefix="lbl_">
			<fmt:message key="login"/>
		</fmt:bundle>
	</label>
	<input type="text" name="login" value='${login}' autofocus="autofocus"/></div>
	<br>
	<div><label for="">
		<fmt:bundle basename="ressources" prefix="lbl_">
			<fmt:message key="password"/>
		</fmt:bundle>
	</label>
	<input type="password" value='${password}' name="mdp" /></div>
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
	</button><br>
	
</form>

<br>${msg }<br>

</body>
</html>