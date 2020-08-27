package org.gestionecole.persistent.hbn;

import org.gestionecole.persistent.DAOClasse;
import org.gestionecole.persistent.DAOEleve;
import org.gestionecole.persistent.DAOFactory;
import org.gestionecole.persistent.DAONiveau;
import org.gestionecole.persistent.DAOUser;

public class DAOFactoryHBN implements DAOFactory {
	public static DAOFactoryHBN instance = null;

	private DAOFactoryHBN() {
	}

	/**
	 * Return a singleton of the DAO
	 */
	public static DAOFactoryHBN getInstance() {
		if (instance == null) {
			instance = new DAOFactoryHBN();
		}
		return instance;
	}

	@Override
	public DAONiveau getDAONiveau() {
		return DAONiveauHBN.getInstance();
	}

	@Override
	public DAOUser getDAOUser() {
		return DAOUserHBN.getInstance();
	}

	@Override
	public DAOClasse getDAOClasse() {
		return DAOClasseHBN.getInstance();
	}

	@Override
	public DAOEleve getDAOEleve() {
		return DAOEleveHBN.getInstance();
	}
}
