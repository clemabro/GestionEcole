package org.gestionecole.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gestionecole.beans.User;
import org.gestionecole.business.UserManager;

public class addEventServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6969512867736361963L;
	
	public void doPost(  HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String date = request.getParameter("date");
		String titre = request.getParameter("titre");
		
		System.out.println("date : "+date+"\ntitre : "+titre);
	}
}
