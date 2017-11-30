package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;

public interface CategoriaDao {

	List<Categoria> listarCategoria();
	void guardarCategoria(Categoria categoria);
	//Categoria consultarCategoria(Ingrediente ingrediente);
	
	//void persistirCategoria(Categoria categoria);
	Categoria consultarCategoriaById(Long idCategoria);

}
