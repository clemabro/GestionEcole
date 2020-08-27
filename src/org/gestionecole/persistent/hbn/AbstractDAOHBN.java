package org.gestionecole.persistent.hbn;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gestionecole.beans.AbstractID;
import org.gestionecole.hibernate.HibernateUtil;
import org.gestionecole.persistent.DAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.sql.Alias;

public abstract class AbstractDAOHBN<T extends AbstractID, KeyType extends Serializable> implements DAO<T, KeyType> {
	public final static Integer EMPLOYE_SORTI = 6;
	public abstract Class<T> getBeanClass();

	@SuppressWarnings("unchecked")
	public T getById(final KeyType id) {
		return (T) HibernateUtil.get(getBeanClass(), id);
	}	

	public T save(final T bean) {
		HibernateUtil.save(bean);
		return bean;
	}

	@SuppressWarnings("rawtypes")
	public Criteria getCriteria(final Class classz) {
		Criteria c = HibernateUtil.createCriteria(classz);
		return c;
	}
	@SuppressWarnings("rawtypes")
	public Criteria getCriteria(final Class classz, Session session) {
		Criteria c = HibernateUtil.createCriteria(classz, session);
		return c;
	}

	public List<String> getOrderCriteres() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		Criteria c = getCriteria(getBeanClass());
		if (getOrderCriteres() != null) {
			for (String critere : getOrderCriteres()) {
				c.addOrder(Order.asc(critere));
			}
		} else {
			c.addOrder(Order.asc(AbstractID.ID));
		}
		return c.list();
	}

	public void delete(final KeyType id) {
		T toDelete = getById(id);
		HibernateUtil.delete(toDelete);
	}

	public Map<Alias, Object> getAlias(T bean) {
		return new HashMap<Alias, Object>();
	}

	public Map<Alias, List<Integer>> getAliasMultiple(T bean) {
		return new HashMap<Alias, List<Integer>>();
	}

}
