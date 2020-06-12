package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeInitCreateTheme qui implémente Commande
 */
public class CommandeInitCreateTheme implements Commande {

	/**
	 * Renvoie vers le createTheme.jsp
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "createTheme";
	}

}
