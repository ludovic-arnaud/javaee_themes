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
 * Classe CommandeCreateTheme qui implémente Commande
 */
public class CommandeCreateTheme implements Commande {
	
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
	 * Génère un nouveau Theme à partir du DTO et retourne l'url du jsp
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String detailed = request.getParameter("detailed");
		String color = request.getParameter("color");

		session = request.getSession(true);

		if (session.getAttribute("isConnected").equals(true)) {
			try {
				ThemeDTO themeDto = new ThemeDTO(name, color, description, detailed);
				Theme theme = service.createTheme(themeDto);
				return "redirect";

			} catch (Exception e) {
				request.setAttribute("msg", e.getMessage());
				logger.error(bundle.getString("error.creationTheme"), e);
				return "createTheme";
			}
		} else {
			logger.warn(bundle.getString("warn.session"));
			return "login";
		}

	}

}
