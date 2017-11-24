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
	public void actualizarEstadoPedidoAPendEntrega(Long idPedido) {
		pedidoDao.actualizarEstadoPedidoAPendEntrega(idPedido);
	}

	@Override
	public void actualizarEstadoPedidoAEntregado(Long idPedido) {
		pedidoDao.actualizarEstadoPedidoAEntregado(idPedido);
	}

	@Override
	public List<Pedido> listarPedidosEnPreparacion() {
		List<Pedido> pedidos = pedidoDao.listarPedidosEnProcPreparacion();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosEnEntrega() {
		List<Pedido> pedidos = pedidoDao.listarPedidosEnProcEntrega();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosEntregados() {
		List<Pedido> pedidos = pedidoDao.listarPedidosEntregados();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosPorFecha(Integer year, Integer month, Integer day) {
		List<Pedido> pedidos = pedidoDao.listarPedidosPorFecha(year, month, day);
		return pedidos;
	}

}
