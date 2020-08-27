package org.gestionecole.beans;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@SuppressWarnings({ "rawtypes" })
@MappedSuperclass
public abstract class AbstractID implements Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7684428765381115874L;
	// MAPPING COLONE SQL
	public static final String ID = "id";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object obj) {
		AbstractID o = (AbstractID) obj;
		return getId().equals(o.getId());
	}

	@Override
	public int compareTo(Object arg0) {
		AbstractID o = (AbstractID) arg0;
		return getId().compareTo(o.getId());
	}
}
