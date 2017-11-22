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
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCrearHamburguesa;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorLogin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
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

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getIdUsuario());
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());

			
			return new ModelAndView("redirect:/home");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		Combo combo = new Combo();
		List<Ingrediente> listaPanes = servicioCrearHamburguesa.listarPanes(); 
		List<Ingrediente> listaCarnes = servicioCrearHamburguesa.listarCarnes(); 
		List<Ingrediente> listaAderezos = servicioCrearHamburguesa.listarAderezos();
		List<Ingrediente> listaVegetales = servicioCrearHamburguesa.listarVegetales();
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		modelo.put("combo", combo);
		modelo.put("listaPanes", listaPanes);
		modelo.put("listaCarne", listaCarnes);
		modelo.put("listaAderezos", listaAderezos);
		modelo.put("listaVegetales", listaVegetales);
		modelo.put("combosDeUsuario", listaCombos);
		return new ModelAndView("home", modelo);
	}
	@RequestMapping(path = "/agregarCombo", method=RequestMethod.POST)
	public ModelAndView crearCombo(
			@RequestParam("pan") Long idPan,
			@RequestParam("carne") Long idCarne,
			@RequestParam("vegetales") Long idVegetal,
			@RequestParam("aderezo") Long idAderezo,
			HttpServletRequest request) {
		
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
	@RequestMapping(path="/confirmar-pedido-cliente")
	public ModelAndView confirmarPedido(HttpServletRequest request) {
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		modelo.put("combosDeUsuario", listaCombos);
//		servicioPedido.guardarPedido(usuario);
		return new ModelAndView("confirmarPedido",modelo);
	}
		
		
		
	@RequestMapping(path="/crear-pedido-cliente")
	public ModelAndView crearPedido(HttpServletRequest request) {
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		
		
		servicioPedido.guardarPedido(usuario);
		List<Combo> listaCombos = servicioCrearHamburguesa.listarCombos(usuario);
		modelo.put("combosDeUsuario", listaCombos);
		return new ModelAndView("home",modelo);
		
	}
	

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}

}
