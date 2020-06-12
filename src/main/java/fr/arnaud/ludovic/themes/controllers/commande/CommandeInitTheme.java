package fr.arnaud.ludovic.themes.controllers.commande;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;
import fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeInitTheme qui implémente Commande
 */
public class CommandeInitTheme implements Commande {
	
	/** Implémente le Service de Theme */
	private ServiceTheme serviceTheme = new ServiceThemeImpl();

	/**
	 * Génère une liste de thème et renvoie vers themes.jsp
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Theme> themes = serviceTheme.getAllThemes();
		request.setAttribute("themes", themes);
		
		return "themes";
	}

}
