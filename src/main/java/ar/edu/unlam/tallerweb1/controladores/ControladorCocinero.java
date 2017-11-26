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
public class ControladorCocinero {
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
	
	@RequestMapping(path = "/home-cocinero", method = RequestMethod.GET)
	public ModelAndView irAHomeCocinero(HttpServletRequest request) {
		Usuario usuario = servicioLogin.consultarUsuarioById((Long) request.getSession().getAttribute("idUsuario"));
		ModelMap modelo = new ModelMap();
		modelo.put("usuario", usuario);
		List<Pedido> listaPedidos = servicioPedido.listarPedidosPendCoccion();
		modelo.put("listaPedidos", listaPedidos);
		return new ModelAndView("homeCocinero", modelo);
	}
	
	@RequestMapping(path = "/procesar-pedido-pendCoccion", method = RequestMethod.POST)
	public ModelAndView procesarPendienteDeEntrega(@RequestParam("pedido") Long idPedido) {
		servicioPedido.actualizarEstadoPedidoAPendEntrega(idPedido);
		return new ModelAndView("homeCocinero");
	}
	
	
	
}
