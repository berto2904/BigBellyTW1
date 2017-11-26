package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ComboDao;
import ar.edu.unlam.tallerweb1.dao.IngredienteDao;
import ar.edu.unlam.tallerweb1.dao.PanDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioCrearHamburguesa")
@Transactional
public class ServicioCrearHamburguesaImpl implements ServicioCrearHamburguesa {

	@Inject
	private IngredienteDao ingredienteDao;
	
	@Inject
	private ComboDao comboDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public List<Ingrediente> listarPanes() {
		List<Ingrediente> panes = ingredienteDao.listarPanesActivos();
		return panes;
	}
	@Override
	public List<Ingrediente> listarCarnes() {
		List<Ingrediente> carnes = ingredienteDao.listarCarnesActivos();
		return carnes;
	}
	@Override
	public List<Ingrediente> listarAderezos() {
		List<Ingrediente> aderezos = ingredienteDao.listarAderezosActivos();
		return aderezos;
	}
	@Override
	public List<Ingrediente> listarVegetales() {
		List<Ingrediente> vegetales = ingredienteDao.listarVegetalesActivos();
		return vegetales;
	}
	
	@Override
	public Combo guardarCombo(Set<Ingrediente> ingredientes,Usuario usuario) {
		Combo combo = new Combo();
		combo.setUsuarioCreador(usuario);
		combo.setActivo(validarCombo(ingredientes));
		combo.setDescripcion("Creado por  "+ usuario.getNombre());
		combo.setPrecioFinal(precioFinalCombo(precioCostoCombo(ingredientes)));
		for (Ingrediente ingrediente : ingredientes) {
			combo.getIngredientes().add(ingrediente);
			ingrediente.getCombos().add(combo);
			Long stockActual = ingrediente.getStock() - 1 ;
			ingrediente.setStock(stockActual);
		}
		ingredienteDao.persisirListaIngrediente(ingredientes);
		comboDao.guardarCombo(combo);
		return combo;
	}
	
	@Override
	public Boolean validarCombo (Set<Ingrediente> ingredientes) {
		Integer cantPan=0;
		Integer cantCarne=0;
		Integer cantAderezo=0;
		
		for (Ingrediente ingrediente : ingredientes) {
			Categoria categoriaIngrediente=ingrediente.getCategoria();
			String nombreCategoriaIngrediente = categoriaIngrediente.getDescripcion();
			if(nombreCategoriaIngrediente.equals("Pan")) {				
			cantPan+=1;
			}
			
			if(nombreCategoriaIngrediente.equals("Carne")) {				
				cantCarne+=1;
				}
			if(nombreCategoriaIngrediente.equals("Aderezo")) {				
				cantAderezo+=1;
				}
		}
		if(cantCarne>=1 && cantAderezo>=1 &&cantPan==1) {
			return true;
			}else {
				return false;
				}		
	}
	
	@Override
	public Double precioCostoCombo(Set<Ingrediente> ingredientes) {		
		Double costoCombo=0.0;
		for (Ingrediente ingrediente : ingredientes) {
			Double costoIngrediente = ingrediente.getPrecio();
			costoCombo=costoCombo+costoIngrediente;			
		}
		return costoCombo;
	}
	
	@Override
	public Double precioFinalCombo(Double costoCombo) {
		Double finalCombo=costoCombo*30/100;
		Double precioFinal=costoCombo+finalCombo;
		return precioFinal;		
	}	
	
	@Override
	public Ingrediente consultarIngredienteById(Long id) {
		Ingrediente ingrediente = ingredienteDao.consultarIngredienteById(id);
		return ingrediente;
	}
	
	@Override
	public List<Combo> listarCombos(Usuario usuario) {
		List<Combo> combos = comboDao.listarCombosByUsuarioTrue(usuario);
		return combos;
	}
	
}
