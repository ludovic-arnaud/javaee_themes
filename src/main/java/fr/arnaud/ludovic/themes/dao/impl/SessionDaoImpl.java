package fr.arnaud.ludovic.themes.dao.impl;

import fr.arnaud.ludovic.themes.dao.GenericDaoJPAImpl;
import fr.arnaud.ludovic.themes.dao.SessionDAO;
import fr.arnaud.ludovic.themes.modeles.entities.Session;

public class SessionDaoImpl extends GenericDaoJPAImpl<Session, Integer> implements SessionDAO {

	@Override
	public Class<Session> getClazz() {
		setClazz(Session.class);
		return Session.class;
	}
}
