package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandeInitCreateTheme implements Commande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "createTheme";
	}

}
