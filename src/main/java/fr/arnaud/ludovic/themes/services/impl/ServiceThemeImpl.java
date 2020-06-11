package fr.arnaud.ludovic.themes.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import fr.arnaud.ludovic.themes.controllers.exceptions.BadRequestException;
import fr.arnaud.ludovic.themes.dao.ThemeDAO;
import fr.arnaud.ludovic.themes.dao.impl.ThemeDAOImpl;
import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;

public class ServiceThemeImpl implements ServiceTheme {

	private ThemeDAO themeDao = new ThemeDAOImpl();
	ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");

	@Override
	public List<Theme> getAllThemes() {
		List<Theme> listThemes = new ArrayList<Theme>();
		listThemes = themeDao.findAll();
		return listThemes;
	}

	@Override
	public Theme createTheme(ThemeDTO themeDTO) {
		if (themeDTO.getNom() == null) {
			throw new BadRequestException(bundle.getString("ex.themenull"));
		} else {
			Theme theme = new Theme(themeDTO.getNom(), themeDTO.getCouleur(), themeDTO.getDescription(),
					themeDTO.getDescriptionDetaillee());
			theme = themeDao.create(theme);
			return theme;
		}
	}

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

	@Override
	public void deleteThemeById(ThemeDTO themeDTO) {
		Theme theme = new Theme(themeDTO.getId());
		themeDao.deleteById(theme.getIdtheme());
	}

	@Override
	public Theme updateTheme(ThemeDTO themeDTO) {
		if (themeDTO.getNom() == null) {
			throw new BadRequestException(bundle.getString("ex.themenull"));
		} else {
			Theme theme = themeDao.findById(themeDTO.getId());
			theme.setCouleur(themeDTO.getCouleur());
			theme.setDescription(themeDTO.getDescription());
			theme.setDescriptionDetaillee(themeDTO.getDescriptionDetaillee());
			System.out.println(theme);
			themeDao.update(theme);
			return theme;
		}
	}
}
