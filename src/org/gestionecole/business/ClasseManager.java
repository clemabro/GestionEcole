package org.gestionecole.business;

import java.util.List;

import org.gestionecole.beans.Classe;
import org.gestionecole.persistent.DAOClasse;
import org.gestionecole.persistent.DAOHelper;

public class ClasseManager {
	private static ClasseManager singleton;

	public static ClasseManager getInstance() {
		if (singleton == null) {
			singleton = new ClasseManager();
		}
		return singleton;
	}

	public static DAOClasse getClasseDAO() {
		return DAOHelper.getDAOFactory().getDAOClasse();
	}
	
	public List<Classe> listAll() {
		return getClasseDAO().listAll();
	}
}
