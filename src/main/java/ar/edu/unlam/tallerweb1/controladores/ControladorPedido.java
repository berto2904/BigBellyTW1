package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorPedido {
	
	@Inject
	private ServicioPedido servicioPedido;
	
	@RequestMapping(path="/cajero/lista-pedidos-cobrar")
	public ModelAndView listaPedidosPendienteCobro(){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosPendCobro();
		modelo.put("listaPedidosACobrar", listaPedidos);
		return new ModelAndView("cajero-pedidos-cobrar", modelo);
	}
	
	@RequestMapping(path="/cocinero/lista-pedidos-cocinar")
	public ModelAndView listaPedidosPendienteCoccion(){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosPendCoccion();
		modelo.put("listaPedidosACocinar", listaPedidos);
		return new ModelAndView("cocinero-pedidos-cocinar", modelo);
	}
	
	@RequestMapping(path="/cajero/lista-pedidos-entregar")
	public ModelAndView listaPedidosPendienteEntrega(){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosPendEntrega();
		modelo.put("listaPedidosAEntregar", listaPedidos);
		return new ModelAndView("cajero-pedidos-entregar", modelo);
	}
	
	@RequestMapping(path="/administrador/lista-pedidos-entregados")
	public ModelAndView listaPedidosEntregados(){
		ModelMap modelo = new ModelMap();
		List<Pedido> listaPedidos = servicioPedido.listarPedidosEntregados();
		modelo.put("listaPedidosEntregados", listaPedidos);
		return new ModelAndView("administrador-pedidos-entregados", modelo);
	}
}
