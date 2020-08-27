package org.gestionecole.beans;

public class Niveau extends AbstractID {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3619887926500990588L;
	
	private String libelle;
	
	/**
	 * @param idNiveau
	 * @param libelle
	 */
	public Niveau(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * 
	 */
	public Niveau() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
