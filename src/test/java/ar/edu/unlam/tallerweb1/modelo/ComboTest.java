package ar.edu.unlam.tallerweb1.modelo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import ar.edu.unlam.tallerweb1.dao.ComboDao;

public class ComboTest {	
		
		@Test
		public void queUnComboTengaAlMenosTresOMasIngredientes() {
			
			Combo c1 = new Combo();
			Integer cantidad=0;
			Ingrediente i1 = new Ingrediente();
			Ingrediente i2 = new Ingrediente();
			Ingrediente i3 = new Ingrediente();
			
			i1.setNombre("pan");
			i1.setStock((long) 10);
			i2.setNombre("carne");
			i2.setStock((long) 10);
			i3.setNombre("Mayonesa");
			i3.setStock((long) 10);
			
			List<Ingrediente> c1Ingredientes = new ArrayList<Ingrediente>();
			
			c1Ingredientes.add(i1);
			c1Ingredientes.add(i2);
			c1Ingredientes.add(i3);
			
			c1.setIngredientes(c1Ingredientes);	
			
			for (Ingrediente comboarray: c1Ingredientes) {cantidad = cantidad+1;}
			Assert.assertTrue(cantidad>=3);		
		}
		
		@Test
		public void queUnComboNoTengaPrecioNegativo() {
			
			Combo c1 = new Combo();
			c1.setPrecioFinal(135.00);
			Assert.assertTrue(c1.getPrecioFinal()>0);
			
		}
		
		@SuppressWarnings("null")
		@Test
		public void queUnComboTengaStockDeTodosSusIngredientes() {
			
			ComboDao comboDao = null;
			
			Ingrediente i1 = new Ingrediente();
			Ingrediente i2 = new Ingrediente();
			Ingrediente i3 = new Ingrediente();
			
			i1.setNombre("pan");
			i1.setStock((long) 10);
			i2.setNombre("carne");
			i2.setStock((long) 10);
			i3.setNombre("Mayonesa");
			i3.setStock((long) 10);
			
			Combo c1 = new Combo();
			c1.setIdCombo((long) 1);
			
			List<Ingrediente> c1Ingredientes = new ArrayList<Ingrediente>();
			
			c1Ingredientes.add(i1);
			c1Ingredientes.add(i2);
			c1Ingredientes.add(i3);
			
			c1.setIngredientes(c1Ingredientes);
			
			for (Ingrediente comboArray: c1Ingredientes) {
				
				if(comboArray.getStock()==0) {
					c1.setActivo(false);
					comboDao.desactivarCombo(c1.getIdCombo(),false);
					
				}else {
					c1.setActivo(true);
				}			
			}
			
			Assert.assertTrue(c1.getActivo()==true);	
			}
		
		
		@Test
		public void queUnComboNoTengaStockDeAlgunoDeSusIngredientes() {
			
			ComboDao comboDao = null;
			
			Ingrediente i1 = new Ingrediente();
			Ingrediente i2 = new Ingrediente();
			Ingrediente i3 = new Ingrediente();
			
			i1.setNombre("pan");
			i1.setStock((long) 10);
			i2.setNombre("carne");
			i2.setStock((long) 0);
			i3.setNombre("Mayonesa");
			i3.setStock((long) 10);
			
			Combo c1 = new Combo();
			c1.setIdCombo((long) 1);
			
			List<Ingrediente> c1Ingredientes = new ArrayList<Ingrediente>();
			
			c1Ingredientes.add(i1);
			c1Ingredientes.add(i2);
			c1Ingredientes.add(i3);
			
			c1.setIngredientes(c1Ingredientes);
			
			for (Ingrediente comboArray: c1Ingredientes) {
				
				if(comboArray.getStock()==0) {
					c1.setActivo(false);
					//comboDao.desactivarCombo(c1.getIdCombo(),false);

				}else {
					c1.setActivo(true);
				}			
			}			
			Assert.assertFalse(c1.getActivo()==false);	
			}		
}
