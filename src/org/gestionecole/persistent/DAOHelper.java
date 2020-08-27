package org.gestionecole.persistent;

import org.gestionecole.persistent.hbn.DAOFactoryHBN;

public class DAOHelper {
	private static final String DAOHBN = "HBN"; // Constante
	private static final String TYPE = DAOHBN; // Constante

	public static DAOFactory getDAOFactory() {
		if (DAOHBN.equals(TYPE)) {
			return DAOFactoryHBN.getInstance();
		}
		return null;
	}
}
