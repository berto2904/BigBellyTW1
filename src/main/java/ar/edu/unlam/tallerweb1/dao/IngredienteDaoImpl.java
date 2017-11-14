package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;

import java.util.List;

import javax.inject.Inject;

@Repository("ingredienteDao")
public class IngredienteDaoImpl implements IngredienteDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Ingrediente consultarIngredienteById(Long idIngrediente) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			Ingrediente ingrediente = (Ingrediente) session.createCriteria(Ingrediente.class)
				.add(Restrictions.eq("idIngrediente", idIngrediente)).uniqueResult();
			return ingrediente;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Ingrediente> listarPanesActivos() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ingrediente> panes = session.createCriteria(Ingrediente.class)
			.add(Restrictions.eq("activo", true))
			.createAlias("categoria", "cat")
			.add(Restrictions.eq("cat.descripcion","pan"))
			.list();
		return panes;
	}
	
	@Override
	public List<Ingrediente> listarCarnesActivos() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ingrediente> carnes = session.createCriteria(Ingrediente.class)
			.add(Restrictions.eq("activo", true))
			.createAlias("categoria", "cat")
			.add(Restrictions.eq("cat.descripcion","carne"))
			.list();
		return carnes;
	}
	
	@Override
	public List<Ingrediente> listarAderezosActivos() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ingrediente> aderezos = session.createCriteria(Ingrediente.class)
			.add(Restrictions.eq("activo", true))
			.createAlias("categoria", "cat")
			.add(Restrictions.eq("cat.descripcion","aderezo"))
			.list();
		return aderezos;
	}
	
	@Override
	public List<Ingrediente> listarVegetalesActivos() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ingrediente> vegetales = session.createCriteria(Ingrediente.class)
			.add(Restrictions.eq("activo", true))
			.createAlias("categoria", "cat")
			.add(Restrictions.eq("cat.descripcion","vegetales"))
			.list();
		return vegetales;
	}
	
	@Override
	public void guardarStockIngrediente(Long idIngrediente, long stockActual) {
		Ingrediente ingrediente = consultarIngredienteById(idIngrediente);
		ingrediente.setStock(stockActual);
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ingrediente);
	}
	@Override
	public void persisitIngrediente(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ingrediente);
		
	}
}
