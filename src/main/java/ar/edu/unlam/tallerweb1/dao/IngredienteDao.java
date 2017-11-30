package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;


public interface IngredienteDao {
	
	Ingrediente consultarIngredienteById(Long idIngrediente);
	void guardarStockIngrediente(Long idIngrediente, long stockActual);
	void persisitIngrediente(Ingrediente ingrediente);
	void persisirListaIngrediente(Set<Ingrediente> ingredientes);
	
	List<Ingrediente> listarIngrediente();
	void guardarIngredienteEnCombo(Ingrediente ingrediente);
	void persisirListaIngredienteAdmin(Set<Ingrediente> listaIngredientes);
	void eliminarIngrediente(Ingrediente ingrediente);
	void eliminarIngredienteEnCombo(Ingrediente ingrediente);
	void guardarIngrediente(Ingrediente ingrediente);
	Ingrediente consultarIngredienteByNombre(String nombreIngrediente);
	Set<Ingrediente> listarIngredientePersistidos();
	List<Categoria> listarCategoria();
	List<Ingrediente> listarIngredientesActivosConStockByCategoria(String categoria);
	
}
