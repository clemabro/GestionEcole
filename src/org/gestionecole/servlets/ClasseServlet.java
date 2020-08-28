package org.gestionecole.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gestionecole.beans.Classe;
import org.gestionecole.beans.User;
import org.gestionecole.business.ClasseManager;

public class ClasseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1490023807697587876L;
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User utilisateur = (User) session.getAttribute("user");
		if(session != null & utilisateur != null) {
			List<Classe> listeClasses = ClasseManager.getInstance().listAll();
			request.setAttribute("listClasses", listeClasses);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/connexion");
		}
	}
}
