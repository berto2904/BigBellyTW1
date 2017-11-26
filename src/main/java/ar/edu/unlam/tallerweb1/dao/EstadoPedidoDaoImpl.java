package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.EstadoPedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("estadoPedidoDao")
public class EstadoPedidoDaoImpl implements EstadoPedidoDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public EstadoPedido consultarEstadoPorId(Long idEstadoPedido) {
		final Session session = sessionFactory.getCurrentSession();
		EstadoPedido estado = (EstadoPedido) session.createCriteria(EstadoPedido.class)
				.add(Restrictions.eq("idEstadoPedido", idEstadoPedido))
				.uniqueResult();
		return estado;
	}
	
}
