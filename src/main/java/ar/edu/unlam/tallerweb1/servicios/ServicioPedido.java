package ar.edu.unlam.tallerweb1.servicios;

import java.text.ParseException;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioPedido {

	public Pedido consultarPedidoPorId(Long idPedido);
	public void actualizarEstadoPedidoAPendCoccion(Long idPedido);
	public void guardarPedido(Usuario usuario, String direccionUsuario);
	public List<Pedido> listarPedidosByUsuario(Usuario usuario);
	void actualizarEstadoPedidoAPendEntrega(Long idPedido);
	void actualizarEstadoPedidoAEntregado(Long idPedido);
	List<Pedido> listarPedidosPendCoccion();
	List<Pedido> listarPedidosPendEntrega();
	List<Pedido> listarPedidosEntregados();
	public List<Pedido> listarPedidosPorFecha(Integer year, Integer month, Integer day);
	
	
}
