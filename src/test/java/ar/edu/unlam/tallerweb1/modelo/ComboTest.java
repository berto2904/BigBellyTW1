package ar.edu.unlam.tallerweb1.modelo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ComboTest {	
		
		@Test
		public void queUnComboTengaAlMenosTresOMasIngredientes() {
			
			Combo c1 = new Combo();
			Integer cantidad=0;
			List<Ingrediente> cantIngredientes = c1.getIngredientes();	
			
			for (Ingrediente comboarray: cantIngredientes) {cantidad = cantidad+1;}
			Assert.assertTrue(cantidad>=3);		
		}
		
	

}
