package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Commande {
	
	/**
	 * 
	 * @param request 	: arriverait du Front controller
	 * @param reponse 	: arriverait du Front controller
	 * @return			: retournerait sous forme de String la page à forwarder 
	 */
	public String execute (HttpServletRequest request, HttpServletResponse response);
	
}
