package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

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
	public void guardarCombo(List<Ingrediente> ingredientes) {
		Combo combo = new Combo();
		combo.setIngredientes(ingredientes);
		combo.setDescripcion("Creado por cliente");
		for (Ingrediente ingrediente : ingredientes) {
			Long idIngrediente = ingrediente.getIdIngrediente();
			long stockActual = ingrediente.getStock() - 1 ;
			ingredienteDao.guardarStockIngrediente(idIngrediente,stockActual);
		}
		comboDao.guardarCombo(combo);
		
	}
	@Override
	public Boolean validarCombo (List<Ingrediente> ingredientes) {
		Integer CantPan=0;
		Integer CantCarne=0;
		Integer CantAderezo=0;
		
		for (Ingrediente ingrediente : ingredientes) {
			Categoria categoriaIngrediente=ingrediente.getCategoria();
			String nombreCategoriaIngrediente = categoriaIngrediente.getDescripcion();
			if(nombreCategoriaIngrediente=="pan") {				
			CantPan=CantPan+1;
			}
			
			if(nombreCategoriaIngrediente=="carne") {				
				CantCarne=CantCarne+1;
				}
			if(nombreCategoriaIngrediente=="aderezo") {				
				CantAderezo=CantAderezo+1;
				}
		}
				
		if(CantCarne>=1&&CantAderezo>=1&&CantPan==1) {return true;}else {return false;}
		
	}
	
}
