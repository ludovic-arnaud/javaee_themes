package fr.arnaud.ludovic.themes.controllers.commande;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeInitCreateTheme qui implémente Commande
 */
public class CommandeInitCreateTheme implements Commande {
	
	/** Constante logger */
	final static Logger logger = Logger.getLogger(CommandeInconnue.class);	

	/** Ajout du bundle pour prendre en charge les langues */
	ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");

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
			logger.warn(bundle.getString("warn.session"));
			return "login";
		}
	}

}
