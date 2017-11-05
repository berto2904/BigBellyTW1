package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.dao.ComboDao;
import ar.edu.unlam.tallerweb1.modelo.Combo;

public class ServicioAdministrarComboImpl implements ServicioAdministrarCombo{
	
	@Inject
	private ComboDao comboDao;

	@Override
	public List<Combo> listarCombosConStock() {
	List<Combo> comboDisponibles = comboDao.listarComboConStock();
	return comboDisponibles;

	}

}
