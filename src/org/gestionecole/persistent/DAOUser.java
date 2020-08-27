package org.gestionecole.persistent;

import java.util.List;

import org.gestionecole.beans.User;

public interface DAOUser extends DAO<User, java.lang.Integer> {

	List<User> getByLogin(String login);

}
