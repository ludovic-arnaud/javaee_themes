package fr.arnaud.ludovic.themes.dao.impl;

import fr.arnaud.ludovic.themes.dao.GenericDaoJPAImpl;
import fr.arnaud.ludovic.themes.dao.ThemeDAO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;

public class ThemeDAOImpl extends GenericDaoJPAImpl<Theme, Integer> implements ThemeDAO{

	@Override
	public Class<Theme> getClazz() {
		setClazz(Theme.class);
		return Theme.class;
	}

}
