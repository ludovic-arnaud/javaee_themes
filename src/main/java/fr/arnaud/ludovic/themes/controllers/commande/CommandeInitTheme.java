package fr.arnaud.ludovic.themes.controllers.commande;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;
import fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl;

public class CommandeInitTheme implements Commande {
	
	private ServiceTheme serviceTheme = new ServiceThemeImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Theme> themes = serviceTheme.getAllThemes();
		System.out.println(themes);
		request.setAttribute("themes", themes);
		
		return "themes";
	}

}
