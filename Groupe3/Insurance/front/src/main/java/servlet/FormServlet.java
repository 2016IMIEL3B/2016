package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/servlet/result")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (request.getParameter("login") !=  null) {
			if (request.getParameter("password").equals(request.getParameter("password2"))) {
				rd = request.getRequestDispatcher("/views/result.jsp");
				request.setAttribute("login", request.getParameter("login"));
                request.setAttribute("password", request.getParameter("password"));             
			} else {
				rd = request.getRequestDispatcher("/views/error.jsp");
				request.setAttribute("message", "Problème de mot de passe");
			}
		} else {
			rd = request.getRequestDispatcher("/views/error.jsp");
			request.setAttribute("message", "Il y a des champs vides");
		}
			
		rd.include(request, response);
	}
}
