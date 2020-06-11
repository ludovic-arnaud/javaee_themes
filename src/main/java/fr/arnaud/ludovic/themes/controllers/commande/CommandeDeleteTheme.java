package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;
import fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl;

public class CommandeDeleteTheme implements Commande {
	
	private ServiceTheme service = new ServiceThemeImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String themeId = request.getParameter("themeId");
		System.out.println(themeId);
		
		try {
			ThemeDTO themeDto = new ThemeDTO(Integer.valueOf(themeId));
			service.deleteThemeById(themeDto);
			
			return "redirect";
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "themes";
		}
	}

}
