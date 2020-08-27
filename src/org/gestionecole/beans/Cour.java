package org.gestionecole.beans;

public class Cour extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5789103485209930229L;
	
	private String intitule;
	private Matiere matiere;
	
	/**
	 * @param intitule
	 * @param matiere
	 */
	public Cour(String intitule, Matiere matiere) {
		this.intitule = intitule;
		this.matiere = matiere;
	}

	/**
	 * 
	 */
	public Cour() {
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
}
