package fr.arnaud.ludovic.themes.dao.impl;

import javax.persistence.EntityManager;

import fr.arnaud.ludovic.themes.dao.GenericDaoJPAImpl;
import fr.arnaud.ludovic.themes.dao.UtilisateurDAO;
import fr.arnaud.ludovic.themes.dao.exception.DataAccessException;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;

public class UtilisateurDaoImpl extends GenericDaoJPAImpl<Utilisateur, Integer> implements UtilisateurDAO {

	@Override
	public Class<Utilisateur> getClazz() {
		setClazz(Utilisateur.class);
		return Utilisateur.class;
	}

	@Override
	public Utilisateur findUserByMail(String mail) {
		EntityManager em = getEntityManager();
		Utilisateur user = null;
		try {
			em.getTransaction().begin();
			String req = "SELECT u FROM " + Utilisateur.class.getName() + " u WHERE u.email = :email ";
			user = em.createQuery(req, Utilisateur.class).setParameter("email", mail).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("l'utilisateur n'exsiste pas");
		}

		finally {
			closeEntityManager(em);
		}
		return user;
	}

	@Override
	public Utilisateur findUserByMailAndPassword(String mail, String password) {
		Utilisateur user = null;
		EntityManager em = getEntityManager();

		try {
			String req = "SELECT u FROM " + Utilisateur.class.getName()
					+ " u WHERE u.email = :email AND u.password = :passwd";
			user = em.createQuery(req, Utilisateur.class).setParameter("email", mail).setParameter("passwd", password)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("l'utilisateur n'exsiste pas");
		} finally {
			closeEntityManager(em);
		}

		return user;
	}

}
