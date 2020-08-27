package org.gestionecole.beans;

import java.sql.Date;

public class Eleve extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4370355653085969182L;
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Classe classe;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param classe
	 */
	public Eleve(String nom, String prenom, Date dateNaissance, Classe classe) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.classe = classe;
	}

	/**
	 * 
	 */
	public Eleve() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
}
