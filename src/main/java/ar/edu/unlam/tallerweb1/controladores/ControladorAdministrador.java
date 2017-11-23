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

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.servicios.ServicioAdministrarCombo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAdministrarComponentes;

@Controller
public class ControladorAdministrador {
	
	@Inject
	private ServicioAdministrarComponentes	servicioAdmnComponentes;
	
	@Inject
	private ServicioAdministrarCombo	servicioAdmnCombo;
	
	
	public ServicioAdministrarComponentes getServicioAdmnComponentes() {
		return servicioAdmnComponentes;
	}

	public void setServicioAdmnComponentes(ServicioAdministrarComponentes servicioAdmnComponentes) {
		this.servicioAdmnComponentes = servicioAdmnComponentes;
	}

	@RequestMapping(path="/administrador")
	public ModelAndView cargarPantallaAdministrador(){
		ModelMap modelo = new ModelMap();
//		Pan pan  = new Pan();
//		modelo.put("pan", pan);
		Ingrediente ingrediente  = new Ingrediente();
		modelo.put("ingrediente", ingrediente);
		Combo combo  = new Combo();
		modelo.put("combo", combo);
//		List<Pan> listaPanes = servicioAdmnComponentes.listarPanes();
		List<Ingrediente> listaIngredientes = servicioAdmnComponentes.listarIngredientes();
		List<Combo> listaCombos = servicioAdmnCombo.listarCombo();
//		modelo.put("listaPanes", listaPanes);
		modelo.put("listaIngredientes", listaIngredientes);
		modelo.put("listaCombos", listaCombos);
		return new ModelAndView("homeAdministrador", modelo);
	}
	
//	@RequestMapping(path = "/agregarPan", method = RequestMethod.POST)
//	public ModelAndView persistirPan(@ModelAttribute("pan") Pan pan, HttpServletRequest request) {
//		Pan p = new Pan(pan.getNombre(),pan.getStock(),pan.getPrecio());
//		servicioAdmnComponentes.guardarPan(p);
//		return new ModelAndView("redirect:/administrador#pan");
//	}
//	@RequestMapping(path = "/eliminarPan", method = RequestMethod.GET)
//	public ModelAndView eliminarPan(@RequestParam("idPan") Long id) {
//		servicioAdmnComponentes.eliminarPan(id);
//		return new ModelAndView("redirect:/administrador#pan");
//	}
	
	@RequestMapping(path = "/agregarIngrediente", method = RequestMethod.POST)
	public ModelAndView persistirIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente, HttpServletRequest request) {
		Ingrediente i = new Ingrediente(ingrediente.getIdIngrediente(), ingrediente.getNombre(),ingrediente.getStock(),ingrediente.getPrecio());
		servicioAdmnComponentes.guardarIngrediente(i);
		return new ModelAndView("redirect:/administrador#ingrediente");
	}
	@RequestMapping(path = "/eliminarIngrediente", method = RequestMethod.GET)
	public ModelAndView eliminarIngrediente(@RequestParam("idIngrediente") Long id) {
		servicioAdmnComponentes.eliminarIngrediente(id);
		return new ModelAndView("redirect:/administrador#ingrediente");
	}
	
	@RequestMapping(path = "/agregarComboAdmin", method = RequestMethod.POST)
	public ModelAndView persistirCombo(@ModelAttribute("combo") Combo combo, HttpServletRequest request) {
		Combo c = new Combo(combo.getIdCombo(), combo.getDescripcion(),combo.getPrecioFinal());
		servicioAdmnCombo.guardarCombo(c);
		return new ModelAndView("redirect:/administrador#combo");
	}
	@RequestMapping(path = "/eliminarComboAdmin", method = RequestMethod.GET)
	public ModelAndView eliminarCombo(@RequestParam("idCombo") Long id) {
		servicioAdmnCombo.eliminarCombo(id);
		return new ModelAndView("redirect:/administrador#combo");
	}
		
	
}
