package org.gestionecole.beans;

public class Professeur extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2926877438853493437L;
	
	private String nom;
	private String prenom;
	private String tel;
	private String mail;
	private TypeProf typeProf;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param mail
	 * @param typeProf
	 */
	public Professeur(String nom, String prenom, String tel, String mail, TypeProf typeProf) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
		this.typeProf = typeProf;
	}

	/**
	 * 
	 */
	public Professeur() {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public TypeProf getTypeProf() {
		return typeProf;
	}

	public void setTypeProf(TypeProf typeProf) {
		this.typeProf = typeProf;
	}
}
