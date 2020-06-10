package fr.arnaud.ludovic.themes.dao.impl;

import fr.arnaud.ludovic.themes.dao.CollaborateurDAO;
import fr.arnaud.ludovic.themes.dao.GenericDaoJPAImpl;
import fr.arnaud.ludovic.themes.modeles.entities.Collaborateur;

public class CollaborateurDAOImpl extends GenericDaoJPAImpl<Collaborateur, Integer> implements CollaborateurDAO {

	@Override
	public Class<Collaborateur> getClazz() {
		
			setClazz(Collaborateur.class);
			return Collaborateur.class;
		}
}
