package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface ServicioPedido {

	public Pedido consultarPedidoPorId(Long idPedido);
	
	public void actualizarEstadoPedidoAPendEntrega(Long idPedido);
	public void actualizarEstadoPedidoAEntregado(Long idPedido);
	
	public List<Pedido> listarPedidosEnPreparacion();
	public List<Pedido> listarPedidosEnEntrega();
	public List<Pedido> listarPedidosEntregados();
	
	public List<Pedido> listarPedidosPorFecha(Integer year,Integer month, Integer day);
	
	
}
