package fr.arnaud.ludovic.themes.dao.impl;

import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import fr.arnaud.ludovic.themes.controllers.commande.CommandeInconnue;
import fr.arnaud.ludovic.themes.dao.GenericDaoJPAImpl;
import fr.arnaud.ludovic.themes.dao.UtilisateurDAO;
import fr.arnaud.ludovic.themes.dao.exception.DataAccessException;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilisateurDaoImpl.
 */
public class UtilisateurDaoImpl extends GenericDaoJPAImpl<Utilisateur, Integer> implements UtilisateurDAO {
	
	/** Ajout du bundle pour prendre en charge les langues */
	ResourceBundle bundle = ResourceBundle.getBundle("fr.arnaud.ludovic.themes.properties.langue");
	
	/** Constante logger */
	final static Logger logger = Logger.getLogger(CommandeInconnue.class);

	/**
	 * Génère la classe Utilisateur
	 *
	 * @return classe Utilisateur
	 */
	@Override
	public Class<Utilisateur> getClazz() {
		setClazz(Utilisateur.class);
		return Utilisateur.class;
	}

	/**
	 * Cherche un utilisateur via son email et son mot de passe
	 *
	 * @param mail
	 * @param password
	 * @return Utilisateur user
	 */
	@Override
	public Utilisateur findUserByMailAndPassword(String mail, String password) {
		Utilisateur user = null;
		EntityManager em = getEntityManager();

		try {
			String req = "SELECT u FROM " + Utilisateur.class.getName()
					+ " u WHERE u.email = :email AND u.password = :passwd";
			user = em.createQuery(req, Utilisateur.class).setParameter("email", mail).setParameter("passwd", password)
					.getSingleResult();
			logger.info(bundle.getString("info.user"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(bundle.getString("error.reqUser"), e);
			throw new DataAccessException(bundle.getString("error.log"));
		} finally {
			closeEntityManager(em);
		}

		return user;
	}

}
