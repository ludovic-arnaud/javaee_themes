<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="themes.do?action=CreateTheme" method="POST"
		onsubmit="return valider()">

		<label for="name">Nom :</label>
		<input type="text" name="name" value=""><br>
		<label for="description">Description :</label>
		<input type="text" name="description" value=""><br> 
		<label for="detailed">Description détaillée :</label>
		<input type="text" name="detailed" value=""><br>
		<label for="color">Couleur :</label>
		<input type="color" name="color" value="">
		<br>
		<br>
		<button type="reset">Annuler</button>
		<button type="submit">Valider</button>
		<br>
	</form>
	
</body>
</html>