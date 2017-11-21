package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface PedidoDao {
	
	public Pedido consultarPedidoPorId(Long idPedido);
	
	public Pedido actualizarEstadoPedidoAPendCoccion(Long idPedido);
	public Pedido actualizarEstadoPedidoAPendEntrega(Long idPedido);
	public Pedido actualizarEstadoPedidoAEntregado(Long idPedido);
	
	public List<Pedido> listarPedidosPendCobro();
	public List<Pedido> listarPedidosPendCoccion();
	public List<Pedido> listarPedidosPendEntrega();
	public List<Pedido> listarPedidosEntregados();

	public void guardarPedido(Pedido pedido);
	

}
