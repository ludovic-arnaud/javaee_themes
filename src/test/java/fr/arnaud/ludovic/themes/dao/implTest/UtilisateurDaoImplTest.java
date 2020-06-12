package fr.arnaud.ludovic.themes.dao.implTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.arnaud.ludovic.themes.dao.impl.UtilisateurDaoImpl;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;

// TODO: Auto-generated Javadoc
/**
 * Classe de test UtilisateurDaoImplTest permettant de tester
 * UtilisateurDaoImpl.
 */
class UtilisateurDaoImplTest {

	/** Création d'un UtilisateurDaoImpl de test qui sera appelé dans chaque test */
	private static UtilisateurDaoImpl userTest;

	/**
	 * Instanciation de l'userTest avant chaque test.
	 */
	@BeforeEach
	public void initUtilisateurDaoImpl() {
		userTest = new UtilisateurDaoImpl();
	}

	/**
	 * Fermeture de l'userTest après chaque test.
	 */
	@AfterEach
	public void closeUtilisateurDaoImpl() {
		userTest = null;
	}

	/**
	 * Test de la méthode findUserByMailAndPassword() en utilisant un utilisateur
	 * existant de la base de données Cet utilisateur est construit à partir du
	 * script sql fourni dans les ressources
	 */
	@Test
	public void TestFindUserByMailAndPassword() {

		Utilisateur mathildeDubois = new Utilisateur("mathilde.dubois@afpa.fr", "passwordmathilde");

		Utilisateur user = userTest.findUserByMailAndPassword(mathildeDubois.getEmail(), mathildeDubois.getPassword());

		assertThat(user).isNotNull();

	}
}