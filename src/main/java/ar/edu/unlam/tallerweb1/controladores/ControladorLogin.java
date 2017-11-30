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
public class ControladorLogin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Usuario usuarioLogin = new Usuario();
		Usuario clienteNuevo = new Usuario();
		modelo.put("usuario", usuarioLogin);
		modelo.put("usuarioNuevo", clienteNuevo);
		return new ModelAndView("home", modelo);
	}
	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getIdUsuario());
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			if (usuarioBuscado.getRol().getId() == 2) {
				return new ModelAndView("redirect:/home-cliente");
			}else if (usuarioBuscado.getRol().getId() == 4) {
				return new ModelAndView("redirect:/home-cocinero");
			}else if(usuarioBuscado.getRol().getId() == 1) {
				return new ModelAndView("redirect:/administrador");			
			}else if(usuarioBuscado.getRol().getId() == 3) {
				return new ModelAndView("redirect:/home-cajero");
			}
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("redirect:/home", model);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path="/cerrar-sesion", method=RequestMethod.GET)
	public ModelAndView invalidate(HttpServletRequest request) {
		request.getSession().invalidate();
	  return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path = "/crear-usuario-cliente", method=RequestMethod.POST)
	public ModelAndView crearUsuarioCliente(@ModelAttribute("usuarioNuevo") Usuario usuario, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		servicioLogin.crearCliente(usuario);
		return new ModelAndView("redirect:/home",modelo);
	}
}
