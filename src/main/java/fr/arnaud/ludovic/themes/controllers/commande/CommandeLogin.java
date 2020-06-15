package fr.arnaud.ludovic.themes.controllers.commande;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.arnaud.ludovic.themes.modeles.dto.UtilisateurDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;
import fr.arnaud.ludovic.themes.services.ServiceUtilisateur;
import fr.arnaud.ludovic.themes.services.impl.ServiceUtilisateurImpl;

// TODO: Auto-generated Javadoc
/**
 *  Classe CommandeLogin qui implémente Commande
 */
public class CommandeLogin implements Commande {
	
	/** Constante logger */
	final static Logger logger = Logger.getLogger(CommandeInconnue.class);	

	/** Ajout du bundle pour prendre en charge les langues */
	ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");
	
	/** Implémente le Service de Theme */
	private ServiceUtilisateur service = new ServiceUtilisateurImpl();

	/**
	 * Vérifie que l'utilisateur existe bien
	 * Si oui, il est renvoyé vers redirect.jsp qui renvoie vers la liste de thèmes
	 * Si non, il doit ressaisir ses identifiants
	 *
	 * @param request
	 * @param response
	 * @return jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");

		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", mdp);
		
		try {
			UtilisateurDTO utilisateur = new UtilisateurDTO(login,mdp);
			Utilisateur user = service.login(utilisateur);
			session.setAttribute("isConnected", true);
			
			session.setAttribute("user", user);
			return "redirect";
		}

		catch (Exception e) {
			session.setAttribute("isConnected", false);
			request.setAttribute("msg", e.getMessage());
			logger.error(bundle.getString("error.login"), e);
			return "login";
		}
		
	}

}
