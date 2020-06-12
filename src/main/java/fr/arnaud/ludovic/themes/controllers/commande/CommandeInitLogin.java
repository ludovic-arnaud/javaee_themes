package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeInitLogin qui implémente Commande
 */
public class CommandeInitLogin implements Commande {

	/**
	 * Renvoie sur la page de login
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String password = request.getParameter("mdp");
		if (login == null)
			login = "";
		if (password == null)
			password = "";

		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);

		return "login";
	}

}
