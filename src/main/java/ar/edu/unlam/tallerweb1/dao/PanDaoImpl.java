package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pan;

import java.util.List;

import javax.inject.Inject;

@Repository("panDao")
public class PanDaoImpl implements PanDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Pan consultarPanById(Long idPan) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			Pan pancito = (Pan) session.createCriteria(Pan.class)
				.add(Restrictions.eq("idPan", idPan)).uniqueResult();
			return pancito;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Pan consultarPanByNombre(String nombrePan) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			Pan pancito = (Pan) session.createCriteria(Pan.class)
					.add(Restrictions.eq("nombre", nombrePan)).uniqueResult();
			return pancito;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public void guardarPan(Pan pan) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pan);
	}

	@Override
	public void eliminarPan(Pan pan) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(pan);
	}

	@Override
	public List<Pan> listarPanes() {
		final Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Pan> panes = session.createCriteria(Pan.class).list();
		return panes;
	}
}
