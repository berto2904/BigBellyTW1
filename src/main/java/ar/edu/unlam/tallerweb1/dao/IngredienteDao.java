package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;


public interface IngredienteDao {
	
	Ingrediente consultarIngredienteById(Long idIngrediente);
	List<Ingrediente> listarPanesActivos();
	List<Ingrediente> listarCarnesActivos();
	List<Ingrediente> listarAderezosActivos();
	List<Ingrediente> listarVegetalesActivos();
	void guardarStockIngrediente(Long idIngrediente, long stockActual);
	void persisitIngrediente(Ingrediente ingrediente);
	void persisirListaIngrediente(Set<Ingrediente> ingredientes);
	
	//TODO
	List<Ingrediente> listarIngrediente();
	void guardarIngredienteEnCombo(Ingrediente ingrediente);
	void persisirListaIngredienteAdmin(Set<Ingrediente> listaIngredientes);
	//nuevo
	void eliminarIngrediente(Ingrediente ingrediente);
	void eliminarIngredienteEnCombo(Ingrediente ingrediente);
	void guardarIngrediente(Ingrediente ingrediente);
	Ingrediente consultarIngredienteByNombre(String nombreIngrediente);
	Set<Ingrediente> listarIngredientePersistidos();
	List<Categoria> listarCategoria();
	
	
//	List<Ingrediente> listarIngrediente();
//	Ingrediente consultarIngredienteByNombre(String nombre);
//	
//	void eliminarIngrediente(Ingrediente ingrediente);
}
