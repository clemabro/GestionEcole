package org.gestionecole.persistent;

import java.util.List;

import org.gestionecole.beans.Eleve;

public interface DAOEleve extends DAO<Eleve, java.lang.Integer> {

	List<Eleve> getAllById(Integer idClasse);

}
