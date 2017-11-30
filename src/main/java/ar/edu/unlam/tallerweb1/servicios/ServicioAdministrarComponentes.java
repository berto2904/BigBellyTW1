package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioAdministrarComponentes {

	public List<Pan>listarPanes();
	public Pan guardarPan(Pan pan);
	public Pan eliminarPan(Long idPan);
	public List<Ingrediente> listarIngredientes();
	public Ingrediente guardarIngrediente(Ingrediente i);
	public Ingrediente eliminarIngrediente(Long id);
	public List<Categoria> listarcategorias();

	
}
