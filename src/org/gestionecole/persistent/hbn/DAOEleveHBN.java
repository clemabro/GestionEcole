package org.gestionecole.persistent.hbn;

import java.util.List;

import org.gestionecole.beans.Eleve;
import org.gestionecole.hibernate.HibernateUtil;
import org.gestionecole.persistent.DAOEleve;
import org.hibernate.Query;

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
		Query query = HibernateUtil.getCurrentSession().createQuery("from Eleve e where e.classe.id = :idClasse")
                 .setInteger("idClasse", idClasse)
                 .setCacheable(false);
		 return query.list();
	}
}
