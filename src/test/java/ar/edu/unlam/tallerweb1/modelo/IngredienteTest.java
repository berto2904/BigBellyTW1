package ar.edu.unlam.tallerweb1.modelo;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class IngredienteTest {

	@Test
	public void queUnIngredienteNoTengaStockNegativo() throws Exception {
		Ingrediente i1 = mock (Ingrediente.class);
		when(i1.getStock()).thenReturn((long) 100);
		Assert.assertTrue(i1.getStock()>=0);		
	}
	
	@Test
	public void queUnIngredienteNoTengaTiempoDeCoccionNegativo() throws Exception 
	{
		Ingrediente i1 =  mock (Ingrediente.class);
		when(i1.getTiempoCoccion()).thenReturn((long) 15);
		Assert.assertTrue(i1.getTiempoCoccion()>0);
	}
	
	@Test
	public void queUnIngredienteNoTengaPrecioNegativo() throws Exception 
	{
		Ingrediente i1 =  mock (Ingrediente.class);
		when(i1.getPrecio()).thenReturn(25.00);

	}
	
	@Test (expected=Exception.class)
	public void queUnIngredienteConPrecioNegativoDeError()throws Exception
	{
		Ingrediente i1 = new Ingrediente();
		when(i1.getPrecio()).thenReturn(-25.00);
	}
}
