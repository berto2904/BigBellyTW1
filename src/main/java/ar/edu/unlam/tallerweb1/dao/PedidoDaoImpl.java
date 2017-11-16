package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Repository("pedidoDao")
public class PedidoDaoImpl implements PedidoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Pedido consultarPedidoPorId(Long idPedido) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			Pedido pedido = (Pedido) session.createCriteria(Pedido.class)
				.add(Restrictions.eq("idPedido", idPedido)).uniqueResult();
			return pedido;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Pedido actualizarEstadoPedidoAPendCoccion(Long idPedido) {
		final Session session = sessionFactory.getCurrentSession();
		Pedido pedido = (Pedido) session.createCriteria(Pedido.class)
			.add(Restrictions.eq("idPedido", idPedido)).uniqueResult();
		return pedido;
		pedido.setEstado(2);
		session.saveOrUpdate(pedido);
	}

	@Override
	public Pedido actualizarEstadoPedidoAPendEntrega(Long idPedido) {
		final Session session = sessionFactory.getCurrentSession();
		Pedido pedido = (Pedido) session.createCriteria(Pedido.class)
				.add(Restrictions.eq("idPedido", idPedido)).uniqueResult();
		return pedido;
		pedido.setEstado(3);
		session.saveOrUpdate(pedido);
	}

	@Override
	public Pedido actualizarEstadoPedidoAEntregado(Long idPedido) {
		final Session session = sessionFactory.getCurrentSession();
		Pedido pedido = (Pedido) session.createCriteria(Pedido.class)
			.add(Restrictions.eq("idPedido", idPedido)).uniqueResult();
		return pedido;
		pedido.setEstado(4);
		session.saveOrUpdate(pedido);
	}

	@Override
	public List<Pedido> listarPedidosPendCobro() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pan.class)
				.add(Restrictions.eq("estado", 1))
				.list();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosPendCoccion() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pan.class)
				.add(Restrictions.eq("estado", 2))
				.list();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosPendEntrega() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pan.class)
				.add(Restrictions.eq("estado", 3))
				.list();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosEntregados() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pan.class)
				.add(Restrictions.eq("estado", 4))
				.list();
		return pedidos;
	}

	
}
