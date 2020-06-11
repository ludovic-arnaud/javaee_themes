package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;
import fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl;

public class CommandeUpdateTheme implements Commande {
	
	private ServiceTheme service = new ServiceThemeImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String themeId = request.getParameter("themeId");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String detailed = request.getParameter("detailed");
		String color = request.getParameter("color");
		
		try {
			ThemeDTO themeDto = new ThemeDTO(name, color, description, detailed, Integer.valueOf(themeId));
			Theme theme = service.updateTheme(themeDto);
			return "redirect";
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "updateTheme";
		}
	}

}
