package org.gestionecole.persistent.hbn;

import org.gestionecole.beans.Niveau;
import org.gestionecole.persistent.DAONiveau;

public class DAONiveauHBN extends AbstractDAOHBN<Niveau, java.lang.Integer> implements DAONiveau{
	private static DAONiveauHBN instance;
	
	public static DAONiveau getInstance() {
		if (instance == null) {
			instance = new DAONiveauHBN();
		}
		return instance;
	}
	
	@Override
	public Class<Niveau> getBeanClass() {
		return Niveau.class;
	}
}
