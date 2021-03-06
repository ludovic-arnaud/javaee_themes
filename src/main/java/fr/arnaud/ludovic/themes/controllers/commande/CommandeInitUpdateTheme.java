package fr.arnaud.ludovic.themes.controllers.commande;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeInitTheme qui implémente Commande
 */
public class CommandeInitUpdateTheme implements Commande {
	
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
	 * Renvoie vers updateTheme.jsp et maintient en mémoire le Theme
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String themeId = request.getParameter("themeId");
		String themeName = request.getParameter("themeName");
		String themeDesc = request.getParameter("themeDesc");
		String themeDetail = request.getParameter("themeDetail");
		String themeColor = request.getParameter("themeColor");

		if (themeName == null)
			themeName = "";
		if (themeDesc == null)
			themeDesc = "";
		if (themeDetail == null)
			themeDetail = "";
		if (themeColor == null)
			themeColor = "#FFFFFF";

		HttpSession session = request.getSession(true);
		session.setAttribute("themeId", themeId);
		session.setAttribute("themeName", themeName);
		session.setAttribute("themeDesc", themeDesc);
		session.setAttribute("themeDetail", themeDetail);
		session.setAttribute("themeColor", themeColor);

		session = request.getSession(true);

		if (session.getAttribute("isConnected").equals(true)) {
			return "updateTheme";
		} else {
			logger.warn(bundle.getString("warn.session"));
			return "login";
		}

	}

}
