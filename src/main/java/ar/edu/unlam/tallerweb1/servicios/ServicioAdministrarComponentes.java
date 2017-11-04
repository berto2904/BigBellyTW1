package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pan;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioAdministrarComponentes {

	public List<Pan>listarPanes();
	public Pan guardarPan(Pan pan);
	public Pan eliminarPan(Long idPan);
	
	
}
