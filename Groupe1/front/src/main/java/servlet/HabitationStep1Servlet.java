package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Manon on 23/03/2016.
 */
@WebServlet("/servlet/habitationStep1")
public class HabitationStep1Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");

        RequestDispatcher rd = null;

        if (!"".equals(nom) && !"".equals(prenom)){
            rd = this.getServletContext().getRequestDispatcher("/views/myResult.jsp");
            req.setAttribute("nom", nom);
            req.setAttribute("prenom", prenom);
        } else {
            rd = this.getServletContext().getRequestDispatcher("/views/myError.jsp");
            req.setAttribute("message","Le nom ou le prenom n'est pas remplit");
        }

        rd.include(req,resp);
    }

}