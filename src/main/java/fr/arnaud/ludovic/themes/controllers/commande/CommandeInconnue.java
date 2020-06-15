package fr.arnaud.ludovic.themes.controllers.commande;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * Classe CommandeInconnue qui implémente Commande
 */
public class CommandeInconnue implements Commande {

/** Constante logger */
final static Logger logger = Logger.getLogger(CommandeInconnue.class);	

/** Ajout du bundle pour prendre en charge les langues */
ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");

	/**
	 * Renvoie vers la page erreur404 en cas de Commande non trouvée
	 *
	 * @param request
	 * @param response
	 * @return le jsp
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
				
	    logger.warn(bundle.getString("warn.commandeInconnue"));
		
		return "erreur404";
	}

}
