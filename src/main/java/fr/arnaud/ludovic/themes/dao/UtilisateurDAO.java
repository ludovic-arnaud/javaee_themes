package fr.arnaud.ludovic.themes.dao;

import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;

public interface UtilisateurDAO extends DAO<Utilisateur, Integer> {
	
	public Utilisateur findUserByMail(String mail);
	
	public Utilisateur findUserByMailAndPassword(String mail,String password);
	

}
