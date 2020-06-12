package fr.arnaud.ludovic.themes.dao.impl;

import fr.arnaud.ludovic.themes.dao.GenericDaoJPAImpl;
import fr.arnaud.ludovic.themes.dao.ThemeDAO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;

// TODO: Auto-generated Javadoc
/**
 * The Class ThemeDAOImpl.
 */
public class ThemeDAOImpl extends GenericDaoJPAImpl<Theme, Integer> implements ThemeDAO{

	/**
	 * Génère la classe Theme
	 *
	 * @return classe Theme
	 */
	@Override
	public Class<Theme> getClazz() {
		setClazz(Theme.class);
		return Theme.class;
	}
}
