package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;


public interface IngredienteDao {
	
	Ingrediente consultarIngredienteById(Long idIngrediente);
	List<Ingrediente> listarPanesActivos();
	List<Ingrediente> listarCarnesActivos();
	List<Ingrediente> listarAderezosActivos();
	List<Ingrediente> listarVegetalesActivos();
	void guardarStockIngrediente(Long idIngrediente, long stockActual);
}
