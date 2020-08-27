package org.gestionecole.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gestionecole.beans.User;
import org.gestionecole.business.UserManager;

public class ConnexionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5778012815705069460L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/connexion.jsp").forward( request, response );
	}
	
	public void doPost(  HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("motdepasse");
		String message = "Erreur de connexion votre mot de passe ou login est incorrect ";
		Boolean isConnected = false;
		
		List <User> listeUserByLogin =  UserManager.getInstance().getByLogin(login);
		
		if(!listeUserByLogin.isEmpty() && !(listeUserByLogin == null)) {
			for(User userInListe : listeUserByLogin) {
				if(userInListe.getPassword().equals(password)) {
					User personne = userInListe;
					request.setAttribute("personne", personne);
					isConnected = true;
					response.sendRedirect(request.getContextPath() + "/classe");
				}
			}
		}
		
		if(!isConnected) {
			request.setAttribute( "messageErreur", message );
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connexion.jsp" ).forward( request, response );
		}
	}
}
