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
		<label for="codiceFiscaleInputId">CODICE_FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId">
		<br><br>
		<label for="etaInputId">ETA:</label><br>
		<input type="text" name="etaInput" id="etaInputId">
		<br><br>
		<label for="mottoDiVitaInputId">MOTTO_DI_VITA:</label><br>
		<input type="text" name="mottoDiVitaInput" id="mottoDiVitaInputId">
		<br><br>
		
		<input type="submit" value="INSERT">
	
	</form>
	<hr> <br>

    <a href="http://localhost:8080/helloabitante/searchForm.jsp" target="_self" > Torna alla Ricerca </a>

</body>
</html>