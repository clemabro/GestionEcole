package org.gestionecole.persistent.hbn;

import java.util.List;

import org.gestionecole.beans.User;
import org.gestionecole.hibernate.HibernateUtil;
import org.gestionecole.persistent.DAOUser;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class DAOUserHBN extends AbstractDAOHBN<User, java.lang.Integer> implements DAOUser {
	private static DAOUserHBN instance;
	
	public static DAOUser getInstance() {
		if (instance == null) {
			instance = new DAOUserHBN();
		}
		return instance;
	}
	@Override
	public Class<User> getBeanClass() {
		return User.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getByLogin(String login) {
		Criteria c = HibernateUtil.createCriteria(User.class);
		c.add(Restrictions.eq("login", login));
		return c.list();
	}
}
