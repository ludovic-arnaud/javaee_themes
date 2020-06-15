package fr.arnaud.ludovic.themes.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import fr.arnaud.ludovic.themes.controllers.commande.CommandeInconnue;
import fr.arnaud.ludovic.themes.controllers.exceptions.BadRequestException;
import fr.arnaud.ludovic.themes.dao.ThemeDAO;
import fr.arnaud.ludovic.themes.dao.impl.ThemeDAOImpl;
import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;

// TODO: Auto-generated Javadoc
/**
 * La classe ServiceThemeImpl implémente l'interface ServiceTheme.
 */
public class ServiceThemeImpl implements ServiceTheme {
	
	/** Constante logger */
	final static Logger logger = Logger.getLogger(CommandeInconnue.class);

	/** Implémentation du DAO de Theme */
	private ThemeDAO themeDao = new ThemeDAOImpl();
	
	/** Ajout du bundle pour prendre en charge les langues */
	ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");

	/**
	 * Génère la liste de tous les thèmes contenus dans la base de données
	 *
	 * @return List<Theme> listThemes
	 */
	@Override
	public List<Theme> getAllThemes() {
		List<Theme> listThemes = new ArrayList<Theme>();
		listThemes = themeDao.findAll();
		return listThemes;
	}

	/**
	 * Permet de créer un nouveau thème
	 *
	 * @param ThemeDTO themeDTO
	 * @return Theme theme
	 */
	@Override
	public Theme createTheme(ThemeDTO themeDTO) {
		if (themeDTO.getNom() == "") {
			throw new BadRequestException(bundle.getString("ex.themenull"));
		} else {
			Theme theme = new Theme(themeDTO.getNom(), themeDTO.getCouleur(), themeDTO.getDescription(),
					themeDTO.getDescriptionDetaillee());
			theme = themeDao.create(theme);
			return theme;
		}
	}

	/**
	 * Permet de supprimer un thème
	 *
	 * @param ThemeDTO themeDTO
	 */
	@Override
	public void deleteTheme(ThemeDTO themeDTO) {
		if (themeDTO.getNom() == null) {
			throw new BadRequestException(bundle.getString("ex.themenull"));
		} else {
			Theme theme = new Theme(themeDTO.getNom(), themeDTO.getCouleur(), themeDTO.getDescription(),
					themeDTO.getDescriptionDetaillee());
			themeDao.delete(theme);
		}
	}

	/**
	 * Permet de supprimer un thème par son id
	 *
	 * @param ThemeDTO themeDTO
	 */
	@Override
	public void deleteThemeById(ThemeDTO themeDTO) {
		Theme theme = new Theme(themeDTO.getId());
		themeDao.deleteById(theme.getIdtheme());
	}

	/**
	 * Permet de modifier un thème
	 *
	 * @param ThemeDTO themeDTO
	 * @return Theme theme
	 */
	@Override
	public Theme updateTheme(ThemeDTO themeDTO) {
		if (themeDTO.getNom() == null) {
			throw new BadRequestException(bundle.getString("ex.themenull"));
		} else {
			Theme theme = themeDao.findById(themeDTO.getId());
			theme.setNom(themeDTO.getNom());
			theme.setCouleur(themeDTO.getCouleur());
			theme.setDescription(themeDTO.getDescription());
			theme.setDescriptionDetaillee(themeDTO.getDescriptionDetaillee());
			themeDao.update(theme);
			return theme;
		}
	}
}
