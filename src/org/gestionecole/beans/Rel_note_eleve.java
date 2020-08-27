package org.gestionecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rel_note_eleve")
public class Rel_note_eleve extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6764662841784070284L;
	
	@Column(name = "idNote")
	private Integer idNote;
	
	@Column(name = "idEleve")
	private Integer idEleve;
	
	@Column(name = "idCour")
	private Integer idCour;
	
	/**
	 * @param idNote
	 * @param idEleve
	 * @param idCour
	 */
	public Rel_note_eleve(Integer idNote, Integer idEleve, Integer idCour) {
		this.idNote = idNote;
		this.idEleve = idEleve;
		this.idCour = idCour;
	}

	/**
	 * 
	 */
	public Rel_note_eleve() {
	}

	public Integer getIdNote() {
		return idNote;
	}

	public void setIdNote(Integer idNote) {
		this.idNote = idNote;
	}

	public Integer getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}

	public Integer getIdCour() {
		return idCour;
	}

	public void setIdCour(Integer idCour) {
		this.idCour = idCour;
	}
}
