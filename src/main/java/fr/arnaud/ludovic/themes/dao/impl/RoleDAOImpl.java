package fr.arnaud.ludovic.themes.dao.impl;

import javax.persistence.EntityManager;

import fr.arnaud.ludovic.themes.dao.GenericDaoJPAImpl;
import fr.arnaud.ludovic.themes.dao.RoleDAO;
import fr.arnaud.ludovic.themes.dao.exception.DataAccessException;
import fr.arnaud.ludovic.themes.modeles.entities.Role;

public class RoleDAOImpl extends GenericDaoJPAImpl<Role, Integer> implements RoleDAO {

	@Override
	public Role getRole(String code) {
		EntityManager em = getEntityManager();
		Role role = null;
		try {
			em.getTransaction().begin();
			String req = "SELECT u FROM " + Role.class.getName() + " u WHERE u.code = :code ";
			role = em.createQuery(req, Role.class).setParameter("code", code).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("le role n'exsiste pas");
		}

		finally {
			closeEntityManager(em);
		}

		return role;
	}

	@Override
	public Class<Role> getClazz() {
		setClazz(Role.class);
		return Role.class;
	}

}
