package org.gestionecole.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gestionecole.beans.Eleve;
import org.gestionecole.business.ClasseManager;
import org.gestionecole.business.EleveManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EleveAjaxServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8592735022139180495L;

	public void doPost(  HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "getAllById":
			getAllById(request,response);
			break;
		case "saveEleve":
			saveEleve(request,response);
			break;
		default:
			response.sendRedirect(request.getContextPath() + "/classe");
			break;
		}
	}
	
	private static void getAllById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer idClasse = Integer.valueOf(request.getParameter("idClasse"));
		List<Eleve> listEleve = EleveManager.getInstance().getAllById(idClasse);
		JSONArray arrayJson = new JSONArray();
		for(Eleve eleve : listEleve) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("idEleve", eleve.getId());
			jsonObj.put("nom", eleve.getNom());
			jsonObj.put("prenom", eleve.getPrenom());
			jsonObj.put("dateNaissance", eleve.getDateNaissance().toString());
			
			arrayJson.add(jsonObj);
		}
				

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(arrayJson.toString());
	}
	
	private static void saveEleve(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer idClasse = Integer.valueOf(request.getParameter("idClasse"));
		String nomEleve = request.getParameter("nomEleve");
		String prenomEleve = request.getParameter("prenomEleve");
		String dateNaissEleve = request.getParameter("dateNaissEleve");
		
		Eleve eleveToSave = new Eleve();
		eleveToSave.setClasse(ClasseManager.getClasseDAO().getById(idClasse));
		eleveToSave.setNom(nomEleve);
		eleveToSave.setPrenom(prenomEleve);
		eleveToSave.setDateNaissance(Date.valueOf(dateNaissEleve));
		EleveManager.getEleveDAO().save(eleveToSave);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("test", "OK");
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonObj.toString());
	}
}
