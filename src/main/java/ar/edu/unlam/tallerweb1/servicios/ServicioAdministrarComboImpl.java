package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.ComboDao;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;



@Service("servicioAdministrarCombo")
@Transactional
public class ServicioAdministrarComboImpl implements ServicioAdministrarCombo {
	
	
	@Inject
	private ComboDao comboDao;	
	
	@Override
	public Combo guardarCombo(Combo combo) {
		Combo combo1 = comboDao.consultarComboByNombre(combo.getDescripcion());
		try {
			combo1.setPrecioFinal(combo.getPrecioFinal());
			comboDao.guardarCombo(combo1);
			return combo1;
			
		} catch (Exception e) {
			comboDao.guardarCombo(combo);
			return combo;
		}
	}
	@Override
	public List<Combo> listarCombo() {
		List<Combo> combos = comboDao.listarCombo();
		return combos;
	}
	
	@Override
	public Combo eliminarCombo(Long idCombo) {
		Combo combo = comboDao.consultarComboById(idCombo);
		comboDao.eliminarCombo(combo);
		return combo;
	}
	
	@Override
	public Combo agregarIngredientesAlCombo(List<Ingrediente> listaIngredientes) {
		Combo combo = new Combo();
		combo.setIngredientes(listaIngredientes);
		return combo;
	}
	
}