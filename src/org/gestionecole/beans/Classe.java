package org.gestionecole.beans;

import java.util.Set;

public class Classe extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2622998231855055741L;
	
	private String nom;
	private Niveau niveau;
	private Set<Eleve> eleves;
	
	/**
	 * @param nom
	 * @param niveau
	 */
	public Classe(String nom, Niveau niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
	}
	
	public Classe() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Set<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}
}
