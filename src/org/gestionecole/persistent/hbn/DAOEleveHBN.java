package org.gestionecole.persistent.hbn;

import org.gestionecole.beans.Eleve;
import org.gestionecole.persistent.DAOEleve;

public class DAOEleveHBN extends AbstractDAOHBN<Eleve, java.lang.Integer> implements DAOEleve {
	private static DAOEleveHBN instance;
	
	public static DAOEleve getInstance() {
		if (instance == null) {
			instance = new DAOEleveHBN();
		}
		return instance;
	}
	
	@Override
	public Class<Eleve> getBeanClass() {
		return Eleve.class;
	}
}
