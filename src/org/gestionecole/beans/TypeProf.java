package org.gestionecole.beans;

public class TypeProf extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5021507405788252131L;
	
	private String libelle;

	/**
	 * @param libelle
	 */
	public TypeProf(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * 
	 */
	public TypeProf() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
