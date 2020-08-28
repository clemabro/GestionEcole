package org.gestionecole.business;

import java.util.List;

import org.gestionecole.beans.Eleve;
import org.gestionecole.persistent.DAOEleve;
import org.gestionecole.persistent.DAOHelper;

public class EleveManager {
	private static EleveManager singleton;

	public static EleveManager getInstance() {
		if (singleton == null) {
			singleton = new EleveManager();
		}
		return singleton;
	}

	public static DAOEleve getEleveDAO() {
		return DAOHelper.getDAOFactory().getDAOEleve();
	}
	
	public List<Eleve> listAll() {
		return getEleveDAO().listAll();
	}
}
