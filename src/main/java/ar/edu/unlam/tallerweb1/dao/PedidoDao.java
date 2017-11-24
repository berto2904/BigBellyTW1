package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface PedidoDao {
	
	public Pedido consultarPedidoPorId(Long idPedido);
	
	public void actualizarEstadoPedidoAPendEntrega(Long idPedido);
	public void actualizarEstadoPedidoAEntregado(Long idPedido);
	
	public List<Pedido> listarPedidosEnProcPreparacion();
	public List<Pedido> listarPedidosEnProcEntrega();
	public List<Pedido> listarPedidosEntregados();
	
	public List<Pedido> listarPedidosPorFecha(Integer day,Integer month, Integer year);
	

}
