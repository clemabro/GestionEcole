package org.gestionecole.business;

import java.util.List;

import org.gestionecole.beans.User;
import org.gestionecole.persistent.DAOHelper;
import org.gestionecole.persistent.DAOUser;

public class UserManager {
	private static UserManager singleton;

	public static UserManager getInstance() {
		if (singleton == null) {
			singleton = new UserManager();
		}
		return singleton;
	}

	public static DAOUser getUserDAO() {
		return DAOHelper.getDAOFactory().getDAOUser();
	}
	
	public List<User> getByLogin(String login) {
		return getUserDAO().getByLogin(login);
	}
}
