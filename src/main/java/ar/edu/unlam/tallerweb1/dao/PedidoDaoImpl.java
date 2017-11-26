package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.EstadoPedido;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("pedidoDao")
public class PedidoDaoImpl implements PedidoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Pedido consultarPedidoPorId(Long idPedido) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			Pedido pedido = (Pedido) session.createCriteria(Pedido.class)
				.add(Restrictions.eq("idPedido", idPedido))
				.uniqueResult();
			return pedido;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public void guardarPedido(Pedido pedido) {
		final Session session = sessionFactory.getCurrentSession();
		session.persist(pedido);
	}
	
	@Override
	public List<Pedido> listarPedidosByUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pedido.class)
				.add(Restrictions.eq("usuario", usuario))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return pedidos;
	}
	
	@Override
	public List<Pedido> listarPedidosByEstado(EstadoPedido estado) {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = session.createCriteria(Pedido.class)
				.add(Restrictions.eq("estado", estado))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return pedidos;
	}
}
