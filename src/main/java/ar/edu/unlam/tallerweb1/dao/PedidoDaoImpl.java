package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.EstadoPedido;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Repository("pedidoDao")
public class PedidoDaoImpl implements PedidoDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Inject
	private EstadoPedidoDao estadoPedido;

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
	public void actualizarEstadoPedidoAPendEntrega(Long idPedido) {
		final Session session = sessionFactory.getCurrentSession();
		Pedido pedido = (Pedido) session.createCriteria(Pedido.class)
				.add(Restrictions.eq("idPedido", idPedido)).uniqueResult();
		
		EstadoPedido estado = estadoPedido.consultarEstadoPedidoPorNombre("En proceso de entrega");
		
		pedido.setEstado(estado);
		session.saveOrUpdate(pedido);
	}

	@Override
	public void actualizarEstadoPedidoAEntregado(Long idPedido) {
		final Session session = sessionFactory.getCurrentSession();
		Pedido pedido = (Pedido) session.createCriteria(Pedido.class)
			.add(Restrictions.eq("idPedido", idPedido)).uniqueResult();	
		
		EstadoPedido estado = estadoPedido.consultarEstadoPedidoPorNombre("Entregado");
		
		pedido.setEstado(estado);
		session.saveOrUpdate(pedido);
	}

	@Override
	public List<Pedido> listarPedidosEnProcPreparacion() {
		final Session session = sessionFactory.getCurrentSession();
		EstadoPedido estado = estadoPedido.consultarEstadoPedidoPorNombre("En proceso de preparacion");
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pan.class)
				.add(Restrictions.eq("estado", estado))
				.list();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosEnProcEntrega() {
		final Session session = sessionFactory.getCurrentSession();
		EstadoPedido estado = estadoPedido.consultarEstadoPedidoPorNombre("En proceso de entrega");
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pan.class)
				.add(Restrictions.eq("estado", estado))
				.list();
		return pedidos;
	}

	@Override
	public List<Pedido> listarPedidosEntregados() {
		final Session session = sessionFactory.getCurrentSession();
		EstadoPedido estado = estadoPedido.consultarEstadoPedidoPorNombre("Entregado");
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pan.class)
				.add(Restrictions.eq("estado", estado))
				.list();
		return pedidos;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Pedido> listarPedidosPorFecha(Integer year,Integer month, Integer day) {
		Date fecha = new Date();
		fecha.setDate(day);
		fecha.setMonth(month);
		fecha.setYear(year);
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pedido.class)
				.add(Restrictions.eq("fechaHora", fecha))
				.list();
		return pedidos;
	}

	
}
