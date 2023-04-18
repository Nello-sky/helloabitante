<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p> Vuoi eliminare? </p>
	<% Abitante result = (Abitante)request.getAttribute("AbitanteToDelete");  %>
	<p>nome: <%= result.getNome() %></p>
	<p>cognome: <%= result.getCognome() %></p>
	<p>codiceFiscale: <%= result.getCodiceFiscale() %></p>
	<p>eta: <%= result.getEta() %></p>
	<p>mottoDiVita: <%= result.getMottoDiVita() %></p>

    <form action="ExecuteDeleteAbitanteServlet" method="post">
		<input type="hidden" name="idDelete" value="<%=result.getIdAbitante() %>">
		<input type="submit" value="ok">
	
	</form>

<!-- aggiungere ulteriore controller-->
	<a href="http://localhost:8080/helloabitante/results.jsp" target="_self"> Torna a dettagli </a>

</body>
</html>