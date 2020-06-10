package fr.arnaud.ludovic.themes.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import fr.arnaud.ludovic.themes.dao.ThemeDAO;
import fr.arnaud.ludovic.themes.dao.impl.ThemeDAOImpl;
import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;

public class ServiceThemeImpl implements ServiceTheme {
	
	private ThemeDAO themeDao = new ThemeDAOImpl();

	@Override
	public List<Theme> getAllThemes() {
		List<Theme> listThemes = new ArrayList<Theme>();
		listThemes = themeDao.findAll();
		return listThemes;
	}

	@Override
	public Theme createTheme(ThemeDTO themeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theme deleteTheme(ThemeDTO themeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theme updateTheme(ThemeDTO themeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
