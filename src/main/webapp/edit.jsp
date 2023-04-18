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

<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		Aggiorna, ma non lasciare campi vuoti<br>
	<%}    %>

  <% Abitante result = (Abitante)request.getAttribute("AbitanteToUpdate");  %>

<form action="ExecuteEditAbitanteService" method="post">

		
		<label for="nomeInput">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId" value="<%= result.getNome()%>"  > 
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId" value="<%=result.getCognome() %>" >
		<br><br>
		<label for="codiceFiscaleInputId">CODICE_FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId" value="<%=result.getCodiceFiscale()%>" >
		<br><br>
		<label for="etaInputId">ETA:</label><br>
		<input type="text" name="etaInput" id="etaInputId" value="<%=result.getEta() %>" >
		<br><br>
		<label for="mottoDiVitaInputId">MOTTO_DI_VITA:</label><br>
		<input type="text" name="mottoDiVitaInput" id="mottoDiVitaInputId" value="<%=result.getMottoDiVita() %>" >
		<br><br>
		
		<input type="hidden" name="idUpdate" value="<%=result.getIdAbitante() %>">
		<input type="submit" value="AGGIORNA">
	
	</form>


        
</body>
</html>