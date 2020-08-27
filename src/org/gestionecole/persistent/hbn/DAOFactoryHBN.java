package org.gestionecole.persistent.hbn;

import org.gestionecole.persistent.DAOFactory;
import org.gestionecole.persistent.DAONiveau;

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
}
