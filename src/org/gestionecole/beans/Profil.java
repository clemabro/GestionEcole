package org.gestionecole.beans;

public class Profil extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7916177563310694109L;
	
	private String libelle;

	/**
	 * @param libelle
	 */
	public Profil(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * 
	 */
	public Profil() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
