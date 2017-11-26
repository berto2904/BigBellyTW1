package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorPedido {
	
	@Inject
	private ServicioPedido servicioPedido;
	
	@RequestMapping(path="/cocinero/lista-pedidos-cocinar")
	public ModelAndView listaPedidosPendienteCoccion(){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosPendCoccion();
		modelo.put("listaPedidosACocinar", listaPedidos);
		return new ModelAndView("cocinero-pedidos-cocinar", modelo);
	}
	
	@RequestMapping(path="/cocinero/actualizar-a-pendiente-entrega", method = RequestMethod.POST)
	public String actualizarPedidoAPendienteEntrega(@ModelAttribute("pedido") Pedido pedido){
		Long idPedido = pedido.getIdPedido();
		servicioPedido.actualizarEstadoPedidoAPendEntrega(idPedido);
		String redirectUrl = "/cocinero/lista-pedidos-cocinar";
		return "redirect:" + redirectUrl;
		//redirectView();
	}
	
	@RequestMapping(path="/cajero/lista-pedidos-entregar")
	public ModelAndView listaPedidosPendienteEntrega(){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosPendEntrega();
		modelo.put("listaPedidosAEntregar", listaPedidos);
		return new ModelAndView("cajero-pedidos-entregar", modelo);
	}
	
	@RequestMapping(path="/cajero/actualizar-a-entregado", method = RequestMethod.POST)
	public String actualizarPedidoAEntregado(@ModelAttribute("pedido") Pedido pedido){
		Long idPedido = pedido.getIdPedido();
		servicioPedido.actualizarEstadoPedidoAEntregado(idPedido);
		String redirectUrl = "/cajero/lista-pedidos-entregar";
		return "redirect:" + redirectUrl;
		//redirectView();
	}	
	
	@RequestMapping(path="/administrador/lista-pedidos-entregados")
	public ModelAndView listaPedidosEntregados(){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosEntregados();
		modelo.put("listaPedidosEntregados", listaPedidos);
		return new ModelAndView("administrador-pedidos-entregados", modelo);
	}
	
	@RequestMapping(path="/administrador/lista-pedidos-fecha/{year}/{month}/{day}")
	public ModelAndView listaPedidosPorDia(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosPorFecha(year, month, day);
		modelo.put("day", day);
		modelo.put("month", month);
		modelo.put("year", year);
		modelo.put("listaPedidosFecha", listaPedidos);
		return new ModelAndView("administrador-lista-pedidos-fecha", modelo);
	}
}
