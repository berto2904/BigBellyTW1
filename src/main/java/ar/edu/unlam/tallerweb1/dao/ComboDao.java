package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;

public interface ComboDao {

	void guardarCombo(Combo combo);

	List<Combo> listarComboConStock();
	
	

}
