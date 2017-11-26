package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoPedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface PedidoDao {
	
	public Pedido consultarPedidoPorId(Long idPedido);
	public void guardarPedido(Pedido pedido);
	public List<Pedido> listarPedidosByUsuario(Usuario usuario);
	public List<Pedido> listarPedidosByEstado(EstadoPedido estado);

}
