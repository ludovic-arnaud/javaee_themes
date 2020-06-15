/**
 * 
 */
package fr.arnaud.ludovic.themes.services.implTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import fr.arnaud.ludovic.themes.dao.UtilisateurDAO;
import fr.arnaud.ludovic.themes.modeles.dto.UtilisateurDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Utilisateur;
import fr.arnaud.ludovic.themes.services.ServiceUtilisateur;
import fr.arnaud.ludovic.themes.services.impl.ServiceUtilisateurImpl;

/**
 * @author ludov
 *
 */
@ExtendWith(MockitoExtension.class)
class ServiceUtilisateurImplTest {
	
	// On créé une instance de la classe ServiceUtilisateurImpl à tester et on injecte les
	// mocks créés avec @Mock (ou @Spy) dans l'instance
	@InjectMocks
	private ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateurImpl();
	
	@Mock
	private UtilisateurDAO utilisateurDao;
	
	@Mock
	private Utilisateur utilisateur;
	
	@Mock
	private UtilisateurDTO utilisateurDto;
	

	@Test
	void testLogin() {
		// ARRANGE
		utilisateurDto = new UtilisateurDTO("test@email.com", "password");
		when(utilisateurDao.findUserByMailAndPassword(utilisateurDto.getEmail(), utilisateurDto.getPassword())).thenReturn(utilisateur);
		when(serviceUtilisateur.login(utilisateurDto)).thenReturn(utilisateur);
		
		// ACT
		Utilisateur utilisateurLog = serviceUtilisateur.login(utilisateurDto);
		
		// ASSERT
		assertThat(utilisateurLog).isEqualTo(utilisateur);
	}

}
