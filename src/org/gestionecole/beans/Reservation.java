package org.gestionecole.beans;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3628595063876877980L;
	
	@Column(name = "idProf")
	private Integer idProf;
	
	@Column(name = "idMateriel")
	private Integer idMateriel;
	
	@Column(name = "idCour")
	private Integer idCour;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "heureDebut")
	private Time heureDebut;
	
	@Column(name = "heureFin")
	private Time heureFin;
	
	/**
	 * @param idProf
	 * @param idMateriel
	 * @param idCour
	 * @param date
	 * @param heureDebut
	 * @param heureFin
	 */
	public Reservation(Integer idProf, Integer idMateriel, Integer idCour, Date date, Time heureDebut, Time heureFin) {
		this.idProf = idProf;
		this.idMateriel = idMateriel;
		this.idCour = idCour;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	/**
	 * 
	 */
	public Reservation() {
	}

	public Integer getIdProf() {
		return idProf;
	}

	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}

	public Integer getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(Integer idMateriel) {
		this.idMateriel = idMateriel;
	}

	public Integer getIdCour() {
		return idCour;
	}

	public void setIdCour(Integer idCour) {
		this.idCour = idCour;
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
