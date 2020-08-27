package org.gestionecole.beans;

public class Materiel extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -194844785361105728L;
	
	private String nom;
	private TypeMateriel typeMateriel;
	/**
	 * @param nom
	 * @param typeMateriel
	 */
	public Materiel(String nom, TypeMateriel typeMateriel) {
		this.nom = nom;
		this.typeMateriel = typeMateriel;
	}
	
	/**
	 * 
	 */
	public Materiel() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeMateriel getTypeMateriel() {
		return typeMateriel;
	}

	public void setTypeMateriel(TypeMateriel typeMateriel) {
		this.typeMateriel = typeMateriel;
	}
}
