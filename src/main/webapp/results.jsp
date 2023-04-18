<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina dei risultati</title>
<style type="text/css">
	table, th, td {
	  border: 1px solid black;
	}
	
	th, td {
	  padding: 10px;
	}
	.center {
		margin-left: auto;
		margin-right: auto;
	}
	
	.margin-top-10px {
	    margin-top: 10px;
	}
</style>

</head>
<body>
	<table class="center">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Azione</th>
			</tr>
		</thead>
		
		<% List<Abitante> listaDaServlet = (List<Abitante>)request.getAttribute("listAbitantiAttributeName");
							for(Abitante abitanteItem : listaDaServlet){
				%>
				<tr>
					<td><%=abitanteItem.getNome() %></td>
					<td><%=abitanteItem.getCognome() %></td>
					<td>
						<a href="ExecuteShowAbitanteServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Dettaglio</a>
						<a href="PrepareEditAbitanteServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Modifica</a>
						<a href="PrepareDeleteAbitanteDaServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Cancella</a>
					</td>
				</tr>
		<%	}%>
	
	</table>
	<div align="center" class="margin-top-10px">
		<a href="searchForm.jsp" >Torna alla Ricerca</a>
	</div>
	
	
</body>
</html>