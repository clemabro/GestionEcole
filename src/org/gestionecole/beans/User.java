package org.gestionecole.beans;

public class User extends AbstractID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2491429866072529850L;
	
	private String login;
	private String password;
	private Profil profil;
	
	/**
	 * @param login
	 * @param password
	 * @param profil
	 */
	public User(String login, String password, Profil profil) {
		this.login = login;
		this.password = password;
		this.profil = profil;
	}

	/**
	 * 
	 */
	public User() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
}
