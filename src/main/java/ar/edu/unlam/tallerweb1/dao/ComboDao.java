package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Pan;

public interface ComboDao {

	void guardarCombo(Combo combo);
	Boolean validarCombo (Combo c1);
	void desactivarCombo(Long id, Boolean estado);
	Combo consultaComboById(Long id);
	
	
	

}
