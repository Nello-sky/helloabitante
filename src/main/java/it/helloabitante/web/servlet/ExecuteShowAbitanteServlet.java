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

@WebServlet("/ExecuteShowAbitanteServlet")
public class ExecuteShowAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ExecuteShowAbitanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		
		
		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();
//		
		Abitante result = null;
		
		try {
			result = abitanteServiceInstance.caricaSingolo(Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		request.setAttribute("abitanteDaInviareAPaginaDettaglio", result);
		
		request.getRequestDispatcher("dettaglio.jsp").forward(request, response);
		
	}


}
