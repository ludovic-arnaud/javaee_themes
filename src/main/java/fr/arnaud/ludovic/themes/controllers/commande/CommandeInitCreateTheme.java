package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeInitCreateTheme qui implémente Commande
 */
public class CommandeInitCreateTheme implements Commande {

	/**
	 * Appel de HttpSession pour vérifier que l'utilisateur est loggé, sinon renvoie
	 * sur la page de login
	 */
	HttpSession session;

	/**
	 * Renvoie vers le createTheme.jsp
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		session = request.getSession(true);

		if (session.getAttribute("isConnected").equals(true)) {
			return "createTheme";
		} else {
			return "login";
		}
	}

}
