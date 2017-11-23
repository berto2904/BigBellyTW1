package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;

public interface ServicioAdministrarCombo {
	
	public List<Combo> listarCombo();
	public Combo guardarCombo(Combo combo);
	public Combo eliminarCombo(Long idCombo);
	public Combo agregarIngredientesAlCombo(List<Ingrediente> listaIngredientes);
	

}
