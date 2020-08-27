package org.gestionecole.beans;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "relcourprofclasse")
public class RelCourProfClasse extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6479064176112708630L;
	
	@Column(name = "idCour")
	private Integer idCour;
	
	@Column(name = "idClasse")
	private Integer idClasse;
	
	@Column(name = "idProf")
	private Integer idProf;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "heureDebut")
	private Time heureDebut;
	
	@Column(name = "heureFin")
	private Time heureFin;

	/**
	 * @param idCour
	 * @param idClasse
	 * @param idProf
	 * @param date
	 * @param heureDebut
	 * @param heureFin
	 */
	public RelCourProfClasse(Integer idCour, Integer idClasse, Integer idProf, Date date, Time heureDebut,
			Time heureFin) {
		this.idCour = idCour;
		this.idClasse = idClasse;
		this.idProf = idProf;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	/**
	 * 
	 */
	public RelCourProfClasse() {
	}

	public Integer getIdCour() {
		return idCour;
	}

	public void setIdCour(Integer idCour) {
		this.idCour = idCour;
	}

	public Integer getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
	}

	public Integer getIdProf() {
		return idProf;
	}

	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Time getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}
}
