package com.GestionEcole.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gestionecole.beans.User;
import org.gestionecole.business.UserManager;

public class ConnexionServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/connexion.jsp").forward( request, response );
	}
	
	public void doPost(  HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("motdepasse");
		String message = "Erreur de connexion votre mot de passe ou login est incorrect ";
		
		List <User> listeUserByLogin =  UserManager.getInstance().getByLogin(login);
		
		if(!listeUserByLogin.isEmpty() && !(listeUserByLogin == null)) {
			for(User userInListe : listeUserByLogin) {
				if(userInListe.getPassword().equals(password)) {
					User personne = userInListe;
					request.setAttribute("personne", personne);
					this.getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp" ).forward( request, response );
				}
			}
		}
		request.setAttribute( "messageErreur", message );
		this.getServletContext().getRequestDispatcher( "/WEB-INF/connexion.jsp" ).forward( request, response );
		
		
	}
}
