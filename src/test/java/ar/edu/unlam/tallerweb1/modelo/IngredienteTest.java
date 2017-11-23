package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import static org.mockito.Mockito.*;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class IngredienteTest {

	@Test
	@Transactional
	@Rollback(false)
	public void queUnIngredientePersista() {
		
		Ingrediente i1 = mock(Ingrediente.class);
		
		when(i1.getActivo()).thenReturn( true);
		System.out.println(i1.getIdIngrediente());
		Assert.assertTrue(i1.getActivo()==true);
		verify(i1,times(1)).getActivo();
	}

}
