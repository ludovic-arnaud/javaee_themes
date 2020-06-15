/**
 * 
 */
package fr.arnaud.ludovic.themes.services.implTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.arnaud.ludovic.themes.dao.ThemeDAO;
import fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO;
import fr.arnaud.ludovic.themes.modeles.entities.Theme;
import fr.arnaud.ludovic.themes.services.ServiceTheme;
import fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl;

/**
 * Classe de test de ServiceThemeImpl Utilise les annotations de la librairie de
 * Mockito grâce à l'annotation @ExtendWith Mockito est un framwork qui permet
 * de mocker (imitation, faux) des Objets et de simuler des comportements (bdd
 * par exemple)
 *
 */
@ExtendWith(MockitoExtension.class)
class ServiceThemeImplTest {

	// On créé une instance de la classe ServiceThemeImpl à tester et on injecte les
	// mocks créés avec @Mock (ou @Spy) dans l'instance
	@InjectMocks
	private ServiceTheme serviceTheme = new ServiceThemeImpl();;

	// On mocke un ThemeDAO
	@Mock
	private ThemeDAO themeDao;

	// On mocke un Theme
	@Mock
	private Theme theme;
	
	// On mocke un ThemeDTO
	@Mock
	private ThemeDTO themeDto;

	// On mocke une List<Theme>
	@Mock
	private List<Theme> themes;

	/**
	 * Test method for
	 * {@link fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl#getAllThemes()}.
	 */
	@Test
	void testGetAllThemes() {
		// ARRANGE
		Theme firstTheme = new Theme("test1", "couleur1", "description1", "descriptionDetaillee1");
		Theme secondTheme = new Theme("test2", "couleur2", "description2", "descriptionDetaillee2");
		themes.add(firstTheme);
		themes.add(secondTheme);

		when(serviceTheme.getAllThemes()).thenReturn(themes);

		// ACT
		List<Theme> retriedvedThemes = serviceTheme.getAllThemes();

		// ASSERT
		assertThat(retriedvedThemes).isEqualTo(themes);

	}

	/**
	 * Test method for
	 * {@link fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl#createTheme(fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO)}.
	 */
	@Test
	void testCreateTheme() {
		// ARRANGE
		themeDto = new ThemeDTO("test", "couleur", "description", "descriptionDetaillee");
		when(serviceTheme.createTheme(themeDto)).thenReturn(theme);

		// ACT
		Theme createdTheme = serviceTheme.createTheme(themeDto);

		// ASSERT
		assertThat(createdTheme).isEqualTo(theme);
	}

	/**
	 * Test method for
	 * {@link fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl#deleteThemeById(fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO)}.
	 */
	@Test
	void testDeleteThemeById() {
		// ARRANGE
		themeDto = new ThemeDTO("test", "couleur", "description", "descriptionDetaillee", 1);

		// ACT
		serviceTheme.deleteThemeById(themeDto);

		// VERIFY
		verify(themeDao).deleteById(themeDto.getId());

	}

	/**
	 * Test method for
	 * {@link fr.arnaud.ludovic.themes.services.impl.ServiceThemeImpl#updateTheme(fr.arnaud.ludovic.themes.modeles.dto.ThemeDTO)}.
	 */
	@Test
	void testUpdateTheme() throws Exception {
		// ARRANGE
		themeDto = new ThemeDTO("test", "couleur", "description", "descriptionDetaillee", 1);
		when(themeDao.findById(themeDto.getId())).thenReturn(theme);
		when(serviceTheme.updateTheme(themeDto)).thenReturn(theme);

		// ACT
		Theme updatedTheme = serviceTheme.updateTheme(themeDto);

		// ASSERT
		assertThat(updatedTheme).isEqualTo(theme);
	}

}
