package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;

public interface ComboDao {

	void guardarCombo(Combo combo);
	Combo consultarComboByNombre(String descripcion);
	void eliminarCombo(Combo combo);
	List<Combo> listarCombo();
	Combo consultarComboById(Long idCombo);

}
