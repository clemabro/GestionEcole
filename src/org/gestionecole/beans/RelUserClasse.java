package org.gestionecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reluserclasse")
public class RelUserClasse extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6724853536718669039L;
	
	@Column(name = "idUser")
	private Integer idUser;
	
	@Column(name = "idClasse")
	private Integer idClasse;

	/**
	 * @param idUser
	 * @param idClasse
	 */
	public RelUserClasse(Integer idUser, Integer idClasse) {
		this.idUser = idUser;
		this.idClasse = idClasse;
	}

	/**
	 * 
	 */
	public RelUserClasse() {
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
	}
}
