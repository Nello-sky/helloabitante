package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

/**
 * Servlet implementation class ExecuteInsertAbitanteServlet
 */
@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteInsertAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destinazione = null;
		String messaggioErrore = "riempire tutti i campi";

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		Long idNuovoAbitante = DB_Mock.getNexIdAvailable();
		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		String etaDaPagina = request.getParameter("etaInput");
		String codiceFiscaleDaPagina = request.getParameter("codiceFiscaleInput");
		String mottoDiVitaDaPagina = request.getParameter("mottoDiVitaInput");

		Integer eta = null;
		try {
			eta = Integer.parseInt(etaDaPagina);
		} catch (Exception ex) {

		}

		if (nomeDaPagina.isBlank()) {
			request.setAttribute("messaggioDiErrore", messaggioErrore);
			destinazione = "insert.jsp";
		} else {
			abitanteServiceInstance.inserisciNuovo(new Abitante(idNuovoAbitante, nomeDaPagina, cognomeDaPagina,
					codiceFiscaleDaPagina, eta, mottoDiVitaDaPagina));

			request.setAttribute("listAbitantiAttributeName", abitanteServiceInstance.listAll());

			destinazione = "results.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

}
