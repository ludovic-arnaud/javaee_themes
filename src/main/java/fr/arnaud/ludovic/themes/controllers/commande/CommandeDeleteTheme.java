package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;
import fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeDeleteTheme qui implémente Commande
 */
public class CommandeDeleteTheme implements Commande {

	/**
	 * Appel de HttpSession pour vérifier que l'utilisateur est loggé, sinon renvoie
	 * sur la page de login
	 */
	HttpSession session;

	/** Implémente le Service de Theme */
	private ServiceTheme service = new ServiceThemeImpl();

	/**
	 * Supprime un Theme via son id à partir du DTO et retourne l'url du jsp
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String themeId = request.getParameter("themeId");

		session = request.getSession(true);

		if (session.getAttribute("isConnected").equals(true)) {
			try {
				ThemeDTO themeDto = new ThemeDTO(Integer.valueOf(themeId));
				service.deleteThemeById(themeDto);

				return "redirect";

			} catch (Exception e) {
				request.setAttribute("msg", e.getMessage());
				return "themes";
			}
		} else {
			return "login";
		}

	}

}
