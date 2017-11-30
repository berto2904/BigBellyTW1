package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearHamburguesa;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorCliente {
	@Inject
	private ServicioLogin servicioLogin;
	
	@Inject
	private ServicioCrearHamburguesa servicioCrearHamburguesa;

	@Inject
	private ServicioPedido servicioPedido;
	
	public ServicioCrearHamburguesa getServicioCrearHamburguesa() {
		return servicioCrearHamburguesa;
	}

	public void setServicioCrearHamburguesa(ServicioCrearHamburguesa servicioCrearHamburguesa) {
		this.servicioCrearHamburguesa = servicioCrearHamburguesa;
	}
	@RequestMapping(path = "/home-cliente", method = RequestMethod.GET)
	public ModelAndView irAHomeCliente(HttpServletRequest request) {
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		modelo.put("usuario", usuario);
		Combo combo = new Combo();
		List<Ingrediente> listaPanes = servicioCrearHamburguesa.listarPanes(); 
		List<Ingrediente> listaCarnes = servicioCrearHamburguesa.listarCarnes(); 
		List<Ingrediente> listaAderezos = servicioCrearHamburguesa.listarAderezos();
		List<Ingrediente> listaVegetales = servicioCrearHamburguesa.listarVegetales();
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		List<Pedido> listaPedidos = servicioPedido.listarPedidosByUsuario(usuario);
		modelo.put("pedidosDeUsuario", listaPedidos);
		modelo.put("combo", combo);
		modelo.put("listaPanes", listaPanes);
		modelo.put("listaCarne", listaCarnes);
		modelo.put("listaAderezos", listaAderezos);
		modelo.put("listaVegetales", listaVegetales);
		modelo.put("combosDeUsuario", listaCombos);
		return new ModelAndView("homeCliente", modelo);
	}
	
	
//	@RequestMapping(path = "/agregarCombo", method=RequestMethod.POST)
//	public ModelAndView crearCombo(
//			@RequestParam("pan") Long idPan,
//			@RequestParam("carne") Long idCarne,
//			@RequestParam("vegetales") Long idVegetal,
//			@RequestParam("aderezo") Long idAderezo,
//			HttpServletRequest request) {
//		
//		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
//		ModelMap modelo = new ModelMap();
//		Set<Ingrediente> ingredientes = new HashSet<>();
//		ArrayList<Long> idsIngredientes = new ArrayList<Long>();
//		
//		idsIngredientes.add(idPan);
//		idsIngredientes.add(idCarne);
//		idsIngredientes.add(idVegetal);
//		idsIngredientes.add(idAderezo);
//		for (Long id : idsIngredientes) {
//			Ingrediente ingrediente = servicioCrearHamburguesa.consultarIngredienteById(id);
//			ingredientes.add(ingrediente);
//		}
	
	@RequestMapping(path = "/agregarCombo", method=RequestMethod.POST)
	public ModelAndView crearCombo(
			@RequestParam("pan") Long idPan,
			@RequestParam("carne") Long idCarne,
			@RequestParam("vegetales[]") Long[] idVegetales,
			@RequestParam("aderezo[]") Long[] idAderezos,
			HttpServletRequest request) {
		
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		Set<Ingrediente> ingredientes = new HashSet<>();
		ArrayList<Long> idsIngredientes = new ArrayList<Long>();
		
		idsIngredientes.add(idPan);
		idsIngredientes.add(idCarne);
		for (Long vegetal : idVegetales) {
			idsIngredientes.add(vegetal);
		}
		for (Long aderezo : idAderezos) {
			idsIngredientes.add(aderezo);		
		}
		for (Long id : idsIngredientes) {
			Ingrediente ingrediente = servicioCrearHamburguesa.consultarIngredienteById(id);
			ingredientes.add(ingrediente);
		}
		
		servicioCrearHamburguesa.guardarCombo(ingredientes,usuario);
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		modelo.put("combosDeUsuario", listaCombos);

		return new ModelAndView("homeCliente",modelo);
	}
	
	@RequestMapping(path="/confirmar-pedido-cliente")
	public ModelAndView confirmarPedido(HttpServletRequest request) {
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		modelo.put("combosDeUsuario", listaCombos);
		return new ModelAndView("confirmarPedido",modelo);
	}
		
	@RequestMapping(path="/crear-pedido-cliente")
	public ModelAndView crearPedido(@RequestParam("direccion") String direccionUsuario,HttpServletRequest request) {
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		servicioPedido.guardarPedido(usuario, direccionUsuario);
		
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosByUsuario(usuario);
		modelo.put("pedidosDeUsuario", listaPedidos);
		return new ModelAndView("homeCliente",modelo);
	}
	
	@RequestMapping(path = "/eliminar-combo-creacion", method=RequestMethod.POST)
	public ModelAndView crearCombo(@RequestParam("idCombo") Long idCombo, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		servicioCrearHamburguesa.eliminarComboCreacionPedido(idCombo);
		return new ModelAndView("redirect:/home-cliente",modelo);
	}
	
}
