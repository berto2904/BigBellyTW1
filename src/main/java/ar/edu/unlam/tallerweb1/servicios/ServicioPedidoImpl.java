package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PedidoDao;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Service("servicioPedido")
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
	
	@Inject
	private PedidoDao pedidoDao;

	@Override
	public Pedido consultarPedidoPorId(Long idPedido) {
		Pedido pedido = pedidoDao.consultarPedidoPorId(idPedido);
		return pedido;
	}

	@Override
	public void actualizarEstadoPedidoAPendCoccion(Long idPedido) {
		pedidoDao.actualizarEstadoPedidoAPendCoccion(idPedido);
	}

	@Override
	public void actualizarEstadoPedidoAPendEntrega(Long idPedido) {
		pedidoDao.actualizarEstadoPedidoAPendEntrega(idPedido);
	}

	@Override
	public void actualizarEstadoPedidoAEntregado(Long idPedido) {
		pedidoDao.actualizarEstadoPedidoAEntregado(idPedido);
	}

	@Override
	public List<Pedido> listarPedidosPendCobro() {
		List<Pedido> pedidos = pedidoDao.listarPedidosPendCobro();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosPendCoccion() {
		List<Pedido> pedidos = pedidoDao.listarPedidosPendCoccion();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosPendEntrega() {
		List<Pedido> pedidos = pedidoDao.listarPedidosPendEntrega();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosEntregados() {
		List<Pedido> pedidos = pedidoDao.listarPedidosEntregados();
		return pedidos;
	}

}
