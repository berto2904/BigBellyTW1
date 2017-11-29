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

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.dao.ComboDao;

public class ComboTest {	
		
		@Test
		public void queUnComboTengaAlMenosTresOMasIngredientes() throws Exception {
			
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
			
			Set<Ingrediente> c1Ingredientes = new HashSet<Ingrediente>();
			
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
		public void queUnComboTengaStockDeTodosSusIngredientes() throws Exception {
			
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
		
		
		@Test
		public void queUnComboNoTengaStockDeAlgunoDeSusIngredientes() throws Exception {
			
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
			
			Set<Ingrediente> c1Ingredientes = new HashSet<Ingrediente>();
			
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
		
//		@SuppressWarnings("null")
//		@Test
//		public void queListeLosCombosSegunElUsuario() {
//			Rol rol = new Rol((long) 2, "Cliente");
//			Usuario usuario = new Usuario((long) 1,"Pablo","prueba@gmail.com","password",rol);
//			
//			HttpServletRequest request = null;
//			ControladorLogin cont  = new ControladorLogin();
//			ModelAndView mav = cont.validarLogin(usuario, request);
//			
//			request.getSession().setAttribute("idUsuario", usuario.getIdUsuario());
//			request.getSession().setAttribute("ROL", usuario.getRol());
//			
//			
//			assertThat(mav.getView()).isEqualTo("login");
//			assertThat(mav.getModel().get("error")).isEqualTo("usuario-invalido");
//			 
//			List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
//		}
			
		
}
