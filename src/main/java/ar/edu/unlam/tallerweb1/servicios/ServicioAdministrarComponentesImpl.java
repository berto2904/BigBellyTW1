package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PanDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioAdministrarComponenentes")
@Transactional
public class ServicioAdministrarComponentesImpl implements ServicioAdministrarComponentes {

	@Inject
	private PanDao panDao;
	
//-----------------Pan----------------//
	@Override
	public Pan guardarPan(Pan pan) {
		Pan pan1 = panDao.consultarPanByNombre(pan.getNombre());
		try {
			pan1.setPrecio(pan.getPrecio());
			pan1.setStock(pan.getStock());
			panDao.guardarPan(pan1);
			return pan1;
			
		} catch (Exception e) {
			panDao.guardarPan(pan);
			return pan;
		}
	}
	@Override
	public List<Pan> listarPanes() {
		List<Pan> panes = panDao.listarPanes();
		return panes;
	}
	
	@Override
	public Pan eliminarPan(Long idPan) {
		Pan pan = panDao.consultarPanById(idPan);
		panDao.eliminarPan(pan);
		return pan;
	}
	
}
