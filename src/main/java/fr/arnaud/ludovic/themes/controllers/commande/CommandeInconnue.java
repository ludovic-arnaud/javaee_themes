package fr.arnaud.ludovic.themes.controllers.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CommandeInconnue implements Commande {

final static Logger logger = Logger.getLogger(CommandeInconnue.class);	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if(logger.isDebugEnabled()) {
			logger.debug("msg de logger is debug enable");
		}
		
		logger.debug("msg de debogage");
	    logger.info("msg d'information");
	    logger.warn("msg d'avertissement");
	    logger.error("msg d'erreur");
	    logger.fatal("msg d'erreur fatale");   
	    logger.trace("msg erreur trace");
		
		return "erreur404";
	}

}