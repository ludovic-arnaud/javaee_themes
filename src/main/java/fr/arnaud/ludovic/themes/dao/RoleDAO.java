package fr.arnaud.ludovic.themes.dao;

import fr.arnaud.ludovic.themes.modeles.entities.Role;

public interface RoleDAO extends DAO<Role, Integer> {
	
	public Role getRole(String code);

}
