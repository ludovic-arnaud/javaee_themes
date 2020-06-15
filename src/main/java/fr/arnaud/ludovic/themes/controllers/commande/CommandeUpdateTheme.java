package fr.arnaud.ludovic.themes.controllers.commande;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;
import fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeLogin qui implémente Commande
 */
public class CommandeUpdateTheme implements Commande {
	
	/** Constante logger */
	final static Logger logger = Logger.getLogger(CommandeInconnue.class);	

	/** Ajout du bundle pour prendre en charge les langues */
	ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");

	/**
	 * Appel de HttpSession pour vérifier que l'utilisateur est loggé, sinon renvoie
	 * sur la page de login
	 */
	HttpSession session;

	/** Implémente le Service de Theme */
	private ServiceTheme service = new ServiceThemeImpl();

	/**
	 * Création d'une nouveau thème et redirection vers redirect.jsp qui renvoie
	 * vers la liste de thèmes
	 *
	 * @param request
	 * @param response
	 * @return jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String themeId = request.getParameter("themeId");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String detailed = request.getParameter("detailed");
		String color = request.getParameter("color");

		session = request.getSession(true);

		if (session.getAttribute("isConnected").equals(true)) {
			try {
				ThemeDTO themeDto = new ThemeDTO(name, color, description, detailed, Integer.valueOf(themeId));
				Theme theme = service.updateTheme(themeDto);
				return "redirect";

			} catch (Exception e) {
				request.setAttribute("msg", e.getMessage());
				logger.error(bundle.getString("error.updateTheme"), e);
				return "updateTheme";
			}
		} else {
			logger.warn(bundle.getString("warn.session"));
			return "login";
		}

	}

}
