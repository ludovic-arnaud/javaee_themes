package fr.arnaud.ludovic.themes.services.impl;

import fr.arnaud.ludovic.themes.controllers.exceptions.BadRequestException;
import fr.arnaud.ludovic.themes.dao.UtilisateurDAO;
import fr.arnaud.ludovic.themes.dao.impl.UtilisateurDaoImpl;
import fr.arnaud.ludovic.themes.modeles.dto.UtilisateurDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;
import fr.arnaud.ludovic.themes.services.ServiceUtilisateur;

public class ServiceUtilisateurImpl implements ServiceUtilisateur {
	
	private UtilisateurDAO utilisateurDAO = new UtilisateurDaoImpl();

	@Override
	public Utilisateur login(UtilisateurDTO user) {
		if (user.getEmail() == null || user.getPassword() == null) {
			throw new BadRequestException("erreur, Login ou Password est nul");
		} else {
			Utilisateur userEntity = utilisateurDAO.findUserByMailAndPassword(user.getEmail(), user.getPassword());
			return userEntity;
		}

	}

}