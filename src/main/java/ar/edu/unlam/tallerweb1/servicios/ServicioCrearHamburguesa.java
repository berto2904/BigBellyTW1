package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;

public interface ServicioCrearHamburguesa {

	List<Ingrediente> listarPanes();
	List<Ingrediente> listarCarnes();
	List<Ingrediente> listarAderezos();
	List<Ingrediente> listarVegetales();
	void guardarCombo(List<Ingrediente> ingredientes);

}
