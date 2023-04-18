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

/**
 * Servlet implementation class PrepareEditAbitanteServlet
 */
@WebServlet("/PrepareEditAbitanteServlet")
public class PrepareEditAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareEditAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indiceAbitanteToUpdate= request.getParameter("idDaInviareComeParametro");
		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();
		Abitante result = null;
		try {
			result = abitanteServiceInstance.caricaSingolo(Long.parseLong(indiceAbitanteToUpdate));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		request.setAttribute("AbitanteToUpdate", result);
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
