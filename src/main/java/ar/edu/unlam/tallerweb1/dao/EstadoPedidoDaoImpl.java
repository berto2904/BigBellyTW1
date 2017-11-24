package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ar.edu.unlam.tallerweb1.modelo.EstadoPedido;

public class EstadoPedidoDaoImpl implements EstadoPedidoDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public EstadoPedido consultarEstadoPedidoPorNombre(String nombre) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			EstadoPedido estado = (EstadoPedido) session.createCriteria(EstadoPedido.class)
					.add(Restrictions.eq("descripcion", nombre)).uniqueResult();
			return estado;
		} catch (Exception e) {
			return null;
		}
	}

}
