package org.gestionecole.beans;

public class Matiere extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2947884886501450986L;
	
	private String libelle;

	/**
	 * @param libelle
	 */
	public Matiere(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * 
	 */
	public Matiere() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
