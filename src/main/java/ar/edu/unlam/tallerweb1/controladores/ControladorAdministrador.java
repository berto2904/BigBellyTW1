package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.servicios.ServicioAdministrarComponentes;

@Controller
public class ControladorAdministrador {
	
	@Inject
	private ServicioAdministrarComponentes	servicioAdmnComponentes;
	
	
	public ServicioAdministrarComponentes getServicioAdmnComponentes() {
		return servicioAdmnComponentes;
	}

	public void setServicioAdmnComponentes(ServicioAdministrarComponentes servicioAdmnComponentes) {
		this.servicioAdmnComponentes = servicioAdmnComponentes;
	}

	@RequestMapping(path="/administrador")
	public ModelAndView cargarPantallaAdministrador(){
		ModelMap modelo = new ModelMap();
		Pan pan  = new Pan();
		modelo.put("pan", pan);
		List<Pan> listaPanes = servicioAdmnComponentes.listarPanes();
		modelo.put("listaPanes", listaPanes);
//		modelo.put("listaCarne", listaCarne);
		return new ModelAndView("homeAdministrador", modelo);
	}
	
	@RequestMapping(path = "/agregarPan", method = RequestMethod.POST)
	public ModelAndView persistirPan(@ModelAttribute("pan") Pan pan, HttpServletRequest request) {
		Pan p = new Pan(pan.getNombre(),pan.getStock(),pan.getPrecio());
		servicioAdmnComponentes.guardarPan(p);
		return new ModelAndView("redirect:/administrador#pan");
	}
//	@RequestMapping(path = "/eliminarPan", method = RequestMethod.GET)
//	public ModelAndView eliminarPan(@RequestParam("idPan") Long id) {
//		servicioAdmnComponentes.eliminarPan(id);
//		return new ModelAndView("redirect:/administrador#pan");
//	}
	@RequestMapping(path = "/eliminarPan", method = RequestMethod.POST)
	public ModelAndView eliminarPan(@RequestParam("pan") Long id) {
		servicioAdmnComponentes.eliminarPan(id);
		return new ModelAndView("redirect:/administrador#pan");
	}
}
