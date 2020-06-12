package fr.arnaud.ludovic.themes.services.impl;

import java.util.ResourceBundle;

import fr.arnaud.ludovic.themes.controllers.exceptions.BadRequestException;
import fr.arnaud.ludovic.themes.dao.UtilisateurDAO;
import fr.arnaud.ludovic.themes.dao.impl.UtilisateurDaoImpl;
import fr.arnaud.ludovic.themes.modeles.dto.UtilisateurDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;
import fr.arnaud.ludovic.themes.services.ServiceUtilisateur;

// TODO: Auto-generated Javadoc
/**
 * La classe ServiceUtilisateurImpl implémente l'interface ServiceUtilisateur.
 */
public class ServiceUtilisateurImpl implements ServiceUtilisateur {
	
	/** Ajout du bundle pour prendre en charge les langues */
	ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");
	
	/** Implémentation du DAO de Utilisateur */
	private UtilisateurDAO utilisateurDAO = new UtilisateurDaoImpl();

	/**
	 * Permet à l'utilisateur de se logger en vérifiant son email et son mot de passe
	 *
	 * @param UtilisateurDTO user
	 * @return Utilisateur userEntity
	 */
	@Override
	public Utilisateur login(UtilisateurDTO user) {
		if (user.getEmail() == null || user.getPassword() == null) {
			throw new BadRequestException(bundle.getString("ex.loginandpasswordnull"));
		} else {
			Utilisateur userEntity = utilisateurDAO.findUserByMailAndPassword(user.getEmail(), user.getPassword());
			return userEntity;
		}

	}

}
