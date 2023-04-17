<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ExecuteInsertAbitanteServlet" method="post">
		<label for="nomeInput">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId">
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId">
		<br><br>
		<input type="submit" value="INSERT">
	
	</form>
	<hr> <br>

    <a href="http://localhost:8080/helloabitante/searchForm.jsp" target="_self" > Torna alla Ricerca </a>

</body>
</html>