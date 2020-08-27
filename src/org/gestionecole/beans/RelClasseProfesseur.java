package org.gestionecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "relclasseprofesseur")
public class RelClasseProfesseur extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4174116548747462292L;
	
	@Column(name = "idProf")
	private Integer idProf;
	
	@Column(name = "idClasse")
	private Integer idClasse;
	
	/**
	 * @param idProf
	 * @param idClasse
	 */
	public RelClasseProfesseur(Integer idProf, Integer idClasse) {
		this.idProf = idProf;
		this.idClasse = idClasse;
	}

	/**
	 * 
	 */
	public RelClasseProfesseur() {
	}

	public Integer getIdProf() {
		return idProf;
	}

	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}

	public Integer getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
	}
}
