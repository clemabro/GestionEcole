package org.gestionecole.persistent.hbn;

import java.util.List;

import org.gestionecole.beans.Eleve;
import org.gestionecole.beans.User;
import org.gestionecole.hibernate.HibernateUtil;
import org.gestionecole.persistent.DAOEleve;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Eleve> getAllById(Integer idClasse) {
		Criteria c = HibernateUtil.createCriteria(Eleve.class);
		c.createAlias("classe", "classe");
		c.add(Restrictions.eq("classe.id", idClasse));
		return c.list();
	}
}
