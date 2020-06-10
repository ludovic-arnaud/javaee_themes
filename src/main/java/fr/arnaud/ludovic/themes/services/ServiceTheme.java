package fr.arnaud.ludovic.themes.services;

import java.util.List;

import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;

public interface ServiceTheme {
	
	public List<Theme> getAllThemes();
	public Theme createTheme(ThemeDTO themeDTO);
	public Theme deleteTheme(ThemeDTO themeDTO);
	public Theme updateTheme(ThemeDTO themeDTO);
	
}