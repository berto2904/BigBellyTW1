package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAdministrarCombo;

@Controller
public class ControladorCliente {
	
	@Inject
	private ServicioAdministrarCombo servicioAdmnCombo;
	
	@RequestMapping(path = "/verCombos", method = RequestMethod.GET)
	public ModelAndView listarCombosConStock() {
		ModelMap model = new ModelMap();
		List<Combo> listaCombo = servicioAdmnCombo.listarCombosConStock();
		model.put("combos", listaCombo);
		return new ModelAndView("listaCombos", model);
	}
}
