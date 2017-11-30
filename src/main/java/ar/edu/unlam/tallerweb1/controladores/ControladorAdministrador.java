package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAdministrarComponentes;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearHamburguesa;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorAdministrador {
	
	@Inject
	private ServicioLogin servicioLogin;
	
	@Inject
	private ServicioAdministrarComponentes	servicioAdmnComponentes;
	
	@Inject
	private ServicioCrearHamburguesa servicioCrearHamburguesa;
	
	public ServicioCrearHamburguesa getServicioCrearHamburguesa() {
		return servicioCrearHamburguesa;
	}

	public void setServicioCrearHamburguesa(ServicioCrearHamburguesa servicioCrearHamburguesa) {
		this.servicioCrearHamburguesa = servicioCrearHamburguesa;
	}
	
	
	public ServicioAdministrarComponentes getServicioAdmnComponentes() {
		return servicioAdmnComponentes;
	}

	public void setServicioAdmnComponentes(ServicioAdministrarComponentes servicioAdmnComponentes) {
		this.servicioAdmnComponentes = servicioAdmnComponentes;
	}

	@RequestMapping(path="/administrador")
	public ModelAndView cargarPantallaAdministrador(HttpServletRequest request){
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		Ingrediente ingrediente  = new Ingrediente();
		modelo.put("ingrediente", ingrediente);
		Combo combo  = new Combo();
		modelo.put("combo", combo);
		List<Ingrediente> listaIngredientes = servicioAdmnComponentes.listarIngredientes();
		List<Ingrediente> listaPanes = servicioCrearHamburguesa.listarPanes(); 
		List<Ingrediente> listaCarnes = servicioCrearHamburguesa.listarCarnes(); 
		List<Ingrediente> listaAderezos = servicioCrearHamburguesa.listarAderezos();
		List<Ingrediente> listaVegetales = servicioCrearHamburguesa.listarVegetales();
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		List<Categoria> listaCategorias = servicioAdmnComponentes.listarcategorias();
		modelo.put("combo", combo);
		modelo.put("listaPanes", listaPanes);
		modelo.put("listaCarne", listaCarnes);
		modelo.put("listaAderezos", listaAderezos);
		modelo.put("listaVegetales", listaVegetales);
		modelo.put("combosDeAdministrador", listaCombos);
		modelo.put("listaIngredientes", listaIngredientes);
		modelo.put("listaCombos", listaCombos);
		modelo.put("listaCategorias", listaCategorias);
		return new ModelAndView("homeAdministrador", modelo);
	}
	
	@RequestMapping(path = "/agregarIngrediente", method = RequestMethod.POST)
	public ModelAndView persistirIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente, HttpServletRequest request) {		
		Ingrediente i = new Ingrediente(ingrediente.getIdIngrediente(), ingrediente.getNombre(),ingrediente.getStock(),ingrediente.getTiempoCoccion(),ingrediente.getPrecio(),ingrediente.getCategoria());
		servicioAdmnComponentes.guardarIngrediente(i);
		return new ModelAndView("redirect:/administrador#ingrediente");
	}
	@RequestMapping(path = "/eliminarIngrediente", method = RequestMethod.GET)
	public ModelAndView eliminarIngrediente(@RequestParam("idIngrediente") Long id) {
		servicioAdmnComponentes.eliminarIngrediente(id);
		return new ModelAndView("redirect:/administrador#ingrediente");
	}
	
	
	@RequestMapping(path = "/eliminarComboAdmin", method = RequestMethod.GET)
	public ModelAndView eliminarCombo(@RequestParam("idCombo") Long id) {
		servicioCrearHamburguesa.eliminarComboAdmin(id);
		return new ModelAndView("redirect:/administrador#combo");
	}
	
	@RequestMapping(path = "/agregarComboAdmin", method=RequestMethod.POST)
	public ModelAndView crearCombo(
			@RequestParam("pan") Long idPan,
			@RequestParam("carne") Long idCarne,
			@RequestParam("vegetales") Long idVegetal,
			@RequestParam("aderezo") Long idAderezo,
			HttpServletRequest request) throws Exception {
		
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		Set<Ingrediente> ingredientes = new HashSet<>();
		ArrayList<Long> idsIngredientes = new ArrayList<Long>();
		
		idsIngredientes.add(idPan);
		idsIngredientes.add(idCarne);
		idsIngredientes.add(idVegetal);
		idsIngredientes.add(idAderezo);
		for (Long id : idsIngredientes) {
			Ingrediente ingrediente = servicioCrearHamburguesa.consultarIngredienteById(id);
			ingredientes.add(ingrediente);
		}
		
		servicioCrearHamburguesa.guardarCombo(ingredientes,usuario);
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		modelo.put("combosDeUsuario", listaCombos);

		return new ModelAndView("home",modelo);
	}

	

}
