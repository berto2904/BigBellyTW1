package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.dao.ComboDao;
import ar.edu.unlam.tallerweb1.dao.ComboDaoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearHamburguesa;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearHamburguesaImpl;

public class ComboTest {	
		
		@Test
		public void queUnComboTengaLosIngredientesIndispensables() throws Exception {
									
			ComboDao comboDao = new ComboDaoImpl();
			
			Combo combo1 = new Combo();
			Ingrediente i1 = new Ingrediente();
			Ingrediente i2 = new Ingrediente();
			Ingrediente i3 = new Ingrediente();
			
			Categoria ca1 = new Categoria();
			Categoria ca2 = new Categoria();
			Categoria ca3 = new Categoria();
			
			
			ca1.setDescripcion("Pan");
			ca2.setDescripcion("Carne");
			ca3.setDescripcion("Aderezo");
			
			i1.setCategoria(ca1);
			i2.setCategoria(ca2);
			i3.setCategoria(ca3);

			Set<Ingrediente> comboIngredientes = new HashSet<Ingrediente>();
			comboIngredientes.add(i1);
			comboIngredientes.add(i2);
			comboIngredientes.add(i3);
			combo1.setIngredientes(comboIngredientes);
			
			combo1.setActivo(comboDao.validarCombo(combo1));
		
			Assert.assertTrue(combo1.getActivo()==true);
			
		}
		
		@Test
		public void queUnComboNoTengaPrecioNegativo() throws Exception {
			
			Combo c1 = new Combo();
			ServicioCrearHamburguesa service = new ServicioCrearHamburguesaImpl();
							
			Ingrediente i1 = mock(Ingrediente.class);
			Ingrediente i2 = mock(Ingrediente.class);
			Ingrediente i3 = mock(Ingrediente.class);
			
			
			when(i1.getPrecio()).thenReturn(10.00);
			when(i2.getPrecio()).thenReturn(10.00);
			when(i3.getPrecio()).thenReturn(10.00);
			
			Set<Ingrediente> comboIngredientes = new HashSet<Ingrediente>();
			comboIngredientes.add(i1);
			comboIngredientes.add(i2);
			comboIngredientes.add(i3);
			c1.setIngredientes(comboIngredientes);
			
			Double pcombo = service.precioCostoCombo(comboIngredientes);
			Assert.assertTrue(pcombo>0);			
		}
		
		
		@Test (expected=Exception.class)
		public void queUnComboConPrecioNegativoDeError() throws Exception{
			
			Combo c1 = new Combo();
			ServicioCrearHamburguesa service = new ServicioCrearHamburguesaImpl();
							
			Ingrediente i1 = mock(Ingrediente.class);
			Ingrediente i2 = mock(Ingrediente.class);
			Ingrediente i3 = mock(Ingrediente.class);
			
			
			when(i1.getPrecio()).thenReturn(-10.00);
			when(i2.getPrecio()).thenReturn(-10.00);
			when(i3.getPrecio()).thenReturn(-10.00);
			
			Set<Ingrediente> comboIngredientes = new HashSet<Ingrediente>();
			comboIngredientes.add(i1);
			comboIngredientes.add(i2);
			comboIngredientes.add(i3);
			c1.setIngredientes(comboIngredientes);
			
			Double pcombo = service.precioCostoCombo(comboIngredientes);	
			
			Assert.assertTrue(pcombo>0);
		}
		
		
		@SuppressWarnings("null")
		@Test
		public void queUnComboTengaStockDeTodosSusIngredientes() throws Exception {
			
			ComboDao comboDao = null;

			Ingrediente i1 = mock(Ingrediente.class);
			Ingrediente i2 = mock(Ingrediente.class);
			Ingrediente i3 = mock(Ingrediente.class);
			
			when(i1.getStock()).thenReturn((long) 10);
			when(i2.getStock()).thenReturn((long) 10);
			when(i3.getStock()).thenReturn((long) 10);
						
			Combo c1 = new Combo();
			c1.setIdCombo((long) 1);
			
			Set<Ingrediente> c1Ingredientes = new HashSet<Ingrediente>();
			
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
		
		
		@Test(expected=Exception.class)
		public void queUnComboNoTengaStockDeAlgunoDeSusIngredientes() throws Exception {
			
			ComboDao comboDao = null;

			Ingrediente i1 = mock(Ingrediente.class);
			Ingrediente i2 = mock(Ingrediente.class);
			Ingrediente i3 = mock(Ingrediente.class);
			
			when(i1.getStock()).thenReturn((long) 10);
			when(i2.getStock()).thenReturn((long) 0);
			when(i3.getStock()).thenReturn((long) 10);
						
			Combo c1 = new Combo();
			c1.setIdCombo((long) 1);
			
			Set<Ingrediente> c1Ingredientes = new HashSet<Ingrediente>();
			
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
		
			
}
