package org.gestionecole.persistent;

public interface DAOFactory {
	DAONiveau getDAONiveau();

	DAOUser getDAOUser();

	DAOClasse getDAOClasse();
}
