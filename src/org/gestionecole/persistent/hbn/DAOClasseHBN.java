package org.gestionecole.persistent.hbn;

import org.gestionecole.beans.Classe;
import org.gestionecole.persistent.DAOClasse;

public class DAOClasseHBN extends AbstractDAOHBN<Classe, java.lang.Integer> implements DAOClasse {
private static DAOClasseHBN instance;
	
	public static DAOClasseHBN getInstance() {
		if (instance == null) {
			instance = new DAOClasseHBN();
		}
		return instance;
	}
	
	@Override
	public Class<Classe> getBeanClass() {
		return Classe.class;
	}

}
