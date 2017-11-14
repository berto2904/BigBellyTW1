package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;

public interface ServicioCrearHamburguesa {
 
	Ingrediente consultarIngredienteById(Long id);
	List<Ingrediente> listarPanes();
	List<Ingrediente> listarCarnes();
	List<Ingrediente> listarAderezos();
	List<Ingrediente> listarVegetales();
	Boolean validarCombo(List<Ingrediente> ingredientes);
	void guardarCombo(Set<Ingrediente> ingredientes);

}
