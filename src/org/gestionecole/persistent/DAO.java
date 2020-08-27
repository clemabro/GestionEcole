package org.gestionecole.persistent;

import java.io.Serializable;
import java.util.List;

import org.gestionecole.beans.AbstractID;

public interface DAO<T extends AbstractID, KeyType extends Serializable> {
	T getById(KeyType id);

	T save(T bean);
	
	Class<T> getBeanClass();

	List<T> listAll();

	void delete(KeyType id);
}
