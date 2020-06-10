package fr.arnaud.ludovic.themes.services;

import fr.arnaud.ludovic.themes.modeles.dto.UtilisateurDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;

public interface ServiceUtilisateur {
	
	public Utilisateur login(UtilisateurDTO user);

}
