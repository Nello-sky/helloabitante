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

	<% Abitante result = (Abitante )request.getAttribute("abitanteDaInviareAPaginaDettaglio");  %>
	<p>nome: <%= result.getNome() %></p>
	<p>cognome: <%= result.getCognome() %></p>
	<p>codiceFiscale: <%= result.getCodiceFiscale() %></p>
	<p>eta: <%= result.getEta() %></p>
	<p>mottoDiVita: <%= result.getMottoDiVita() %></p>
	
	 <a href="http://localhost:8080/helloabitante/searchForm.jsp" target="_self" > Torna alla Ricerca </a>
</body>
</html>