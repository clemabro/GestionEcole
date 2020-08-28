package org.gestionecole.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeconnexionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9024715711772586384L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		this.getServletContext().getRequestDispatcher( "/WEB-INF/connexion.jsp").forward(request, response);
	}
}
