package it.helloabitante.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;
import it.provaabitante.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteEditAbitanteService
 */
@WebServlet("/ExecuteEditAbitanteService")
public class ExecuteEditAbitanteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteEditAbitanteService() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
		
		// binding
				String nomeDaPagina = request.getParameter("nomeInput");
				String cognomeDaPagina = request.getParameter("cognomeInput");
				String etaDaPagina = request.getParameter("etaInput");
				String codiceFiscaleDaPagina = request.getParameter("codiceFiscaleInput");
				String mottoDiVitaDaPagina = request.getParameter("mottoDiVitaInput");
				Long idDaPagina = Long.parseLong(request.getParameter("idUpdate"));
						
				Integer etaResult = UtilityForm.parseFromString(etaDaPagina);

				Abitante abitanteInsert = new Abitante(idDaPagina ,nomeDaPagina, cognomeDaPagina, codiceFiscaleDaPagina, etaResult,
						mottoDiVitaDaPagina);

				// validazioni
				if (abitanteInsert.getNome().isBlank() || abitanteInsert.getCognome().isBlank() || abitanteInsert.getCodiceFiscale().isBlank()
						|| abitanteInsert.getEta()==null || abitanteInsert.getMottoDiVita().isBlank()) {
					
					
					
					String messaggioDiErrore = "riempire tutti i campi";
					request.setAttribute("messaggioDiErrore", messaggioDiErrore);
					Abitante AbitanteToUpdate = abitanteService.caricaSingolo(idDaPagina);
					request.setAttribute("AbitanteToUpdate", AbitanteToUpdate);
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					return;
				}

				// Business
				abitanteService.aggiorna(abitanteInsert);

				request.setAttribute("listAbitantiAttributeName", abitanteService.listAll());

				// forward
				request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
