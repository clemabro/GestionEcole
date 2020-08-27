package org.gestionecole.business;

import org.gestionecole.beans.Niveau;
import org.gestionecole.persistent.DAOHelper;
import org.gestionecole.persistent.DAONiveau;

public class NiveauManager {
	
	private static NiveauManager singleton;

	public static NiveauManager getInstance() {
		if (singleton == null) {
			singleton = new NiveauManager();
		}
		return singleton;
	}

	public static DAONiveau getNiveauDAO() {
		return DAOHelper.getDAOFactory().getDAONiveau();
	}
	
	public Niveau getById(Integer id) {
		return getNiveauDAO().getById(id);
	}

}
