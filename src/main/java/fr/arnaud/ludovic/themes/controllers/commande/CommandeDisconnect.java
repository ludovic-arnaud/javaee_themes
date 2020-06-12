package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeDisconnect qui implémente Commande
 */
public class CommandeDisconnect implements Commande {

	/**
	 * Réinitialise la session à null et renvoie sur la page de login
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("isConnected", false);
		session.setAttribute("email", null);
		session.setAttribute("password", null);
		
		return "login";
	}

}
