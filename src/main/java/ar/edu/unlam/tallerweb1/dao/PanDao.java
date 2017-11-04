package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pan;

public interface PanDao {

	List<Pan>listarPanes();
	Pan consultarPanById(Long idPan);
	Pan consultarPanByNombre(String nombrePan);
	void guardarPan(Pan pan);
	void eliminarPan(Pan pan);

}
