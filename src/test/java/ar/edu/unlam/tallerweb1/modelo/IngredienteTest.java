package ar.edu.unlam.tallerweb1.modelo;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;


import org.junit.Test;

public class IngredienteTest {

	@Test
	public void queUnIngredienteNoTengaStockNegativo() throws Exception {
		Ingrediente i1 = new Ingrediente();
		i1.setStock((long) 100);
		Assert.assertTrue(i1.getStock()>=0);		
	}
	
	@Test
	public void queUnIngredienteNoTengaTiempoDeCoccionNegativo() throws Exception 
	{
		Ingrediente i1 = new Ingrediente();
		i1.setTiempoCoccion((long) 15);
		Assert.assertTrue(i1.getTiempoCoccion()>0);
	}
	
	@Test
	public void queUnIngredienteNoTengaPrecioNegativo() throws Exception 
	{
		Ingrediente i1 = new Ingrediente();
		i1.setPrecio((25.00));
		Assert.assertTrue(i1.getPrecio()>0);
	}
	//
	@Test (expected=Exception.class)
	public void queUnIngredienteConPrecioNegativoDeError()throws Exception
	{
		Ingrediente i1 = new Ingrediente();
		i1.setPrecio((-25.00));
	}
}
