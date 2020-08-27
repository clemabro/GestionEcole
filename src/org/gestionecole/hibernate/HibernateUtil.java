package org.gestionecole.hibernate;

import java.io.Serializable;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class HibernateUtil {

	/**
	 * Le SessionFactory mere.
	 */
	public static SessionFactory SESSION_FACTORY;
	static {
		SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * get session associated with current thread initialize transaction if needed.
	 * 
	 * @return the current hibernate session
	 */
	public static Session getCurrentSession() {
		Session session = SESSION_FACTORY.getCurrentSession();
		if (session.getTransaction() == null || session.getTransaction().getStatus() != TransactionStatus.ACTIVE) {
			session.beginTransaction();
			session.setCacheMode(CacheMode.IGNORE);
		}
		return session;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	public static Object get(final Class clazz, final Serializable object) {
		return get(clazz, object, getCurrentSession());
	}
	
	public static Object get(final Class clazz, final Serializable object, final Session sessionHbn) {
		return sessionHbn.get(clazz, object);
	}
	
	@SuppressWarnings("rawtypes")
	public static Criteria createCriteria(final Class clazz) {
		return createCriteria(clazz, getCurrentSession());
	}


	@SuppressWarnings("rawtypes")
	public static Criteria createCriteria(final Class clazz, final Session sessionHbn) {
		return sessionHbn.createCriteria(clazz);
	}

	/**
	 * Commit current transaction.
	 */
	public static void commit() {
		commit(getCurrentSession());
	}

	public static void commit(Session session) {
		Transaction transaction = session.getTransaction();
		if (transaction.getStatus() != TransactionStatus.COMMITTED && transaction.getStatus() != TransactionStatus.ROLLED_BACK) {
			session.getTransaction().commit();
		}
	}

	/**
	 * Rollback current transaction.
	 */
	public static void rollback() {
		rollback(getCurrentSession());
	}

	public static void rollback(Session session) {
		Transaction transaction = session.getTransaction();
		if (transaction.getStatus() != TransactionStatus.COMMITTED && transaction.getStatus() != TransactionStatus.ROLLED_BACK) {
			session.getTransaction().rollback();
		}
	}

	/**
	 * Flush la session.
	 */
	public static void flush() {
		getCurrentSession().flush();
		// getCurrentSession().setCacheMode(CacheMode.IGNORE);
		// Session session = HibernateUtil.getCurrentSession();
		// session.setCacheMode(CacheMode.IGNORE);
	}

	/**
	 * Clear la session.
	 */
	public static void clear() {
		getCurrentSession().clear();
	}

	/**
	 * Sauvegarde un objet.
	 * 
	 * @param object
	 *            l'objet a sauvegarder.
	 */
	public static void save(final Object object) {
		save(object, getCurrentSession());
	}

	public static void save(final Object object, final Session sessionHbn) {
		sessionHbn.save(object);
		sessionHbn.flush();
	}

	/**
	 * Supprime un objet.
	 * 
	 * @param object
	 *            l'objet a supprimer
	 */
	public static void delete(final Object object) {
		delete(object, getCurrentSession());
	}

	public static void delete(final Object object, final Session sessionHbn) {
		sessionHbn.delete(object);
		sessionHbn.flush();
	}
}
