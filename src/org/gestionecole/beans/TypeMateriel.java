package org.gestionecole.beans;

public class TypeMateriel extends AbstractID {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1964977413766963712L;
	
	private String libelle;

	/**
	 * @param libelle
	 */
	public TypeMateriel(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * 
	 */
	public TypeMateriel() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
