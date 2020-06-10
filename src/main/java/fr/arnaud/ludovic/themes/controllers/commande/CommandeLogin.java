package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.arnaud.ludovic.themes.modeles.dto.UtilisateurDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;
import fr.arnaud.ludovic.themes.services.ServiceUtilisateur;
import fr.arnaud.ludovic.themes.services.impl.ServiceUtilisateurImpl;

public class CommandeLogin implements Commande {
	
	private ServiceUtilisateur service = new ServiceUtilisateurImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");

		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", mdp);
		
		try {
			UtilisateurDTO utilisateur=new UtilisateurDTO(login,mdp);
			Utilisateur user=service.login(utilisateur);
			session.setAttribute("isConnected", true);
			
			session.setAttribute("user", user);
			return "connected";
		}

		catch (Exception e) {
			session.setAttribute("isConnected", false);
			request.setAttribute("msg", e.getMessage());
			return "login";
		}
		
	}

}
