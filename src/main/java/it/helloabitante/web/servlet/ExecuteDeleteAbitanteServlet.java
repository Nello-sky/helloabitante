package it.helloabitante.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

/**
 * Servlet implementation class ExecuteDeleteAbitanteServlet
 */
@WebServlet("/ExecuteDeleteAbitanteServlet")
public class ExecuteDeleteAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteDeleteAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long idDelete = Long.parseLong(request.getParameter("idDelete"));
		// Business
				AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
				abitanteService.rimuovi(idDelete);

				request.setAttribute("listAbitantiAttributeName", abitanteService.listAll());

				// forward
				request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
