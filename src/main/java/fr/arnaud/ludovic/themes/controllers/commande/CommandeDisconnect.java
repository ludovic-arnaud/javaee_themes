package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandeDisconnect implements Commande {

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
