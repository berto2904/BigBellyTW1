package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;

import java.util.List;
import java.util.Set;

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
	public List<Ingrediente> listarIngredientesActivosConStockByCategoria(String categoria) {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ingrediente> ingredientes = session.createCriteria(Ingrediente.class)
			.add(Restrictions.eq("activo", true))
			.createAlias("categoria", "cat")
			.add(Restrictions.eq("cat.descripcion",categoria))
			.add(Restrictions.gt("stock", (long)0))
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
			.list();
		return ingredientes;
	}
	
//	@Override
//	public void guardarStockIngrediente(Long idIngrediente, long stockActual)  
//	 {		
//			Ingrediente ingrediente = consultarIngredienteById(idIngrediente);
//			ingrediente.setStock(stockActual);
//			final Session session = sessionFactory.getCurrentSession();
//			session.saveOrUpdate(ingrediente);	
//	     } 

	
	@Override
	public void persisitIngrediente(Ingrediente ingrediente, Categoria categoria) {
		final Session session = sessionFactory.getCurrentSession();
		ingrediente.setCategoria(categoria);
		session.saveOrUpdate(ingrediente);
	}
	@Override
	public void persisirListaIngrediente(Set<Ingrediente> ingredientes) {
		for (Ingrediente ingrediente : ingredientes) {
			final Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(ingrediente);
//			session.close();
//			session.evict(ingrediente);
		}
	}
	@Override
	public Set<Ingrediente> listarIngredientePersistidos() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Set<Ingrediente> ingredientes = (Set<Ingrediente>) session.createCriteria(Ingrediente.class)
				.list();
		return ingredientes;
	}


	@Override
	public List<Ingrediente> listarIngrediente() {
		final Session session = sessionFactory.getCurrentSession();
		List<Ingrediente> ingredientes1 = session.createCriteria(Ingrediente.class).list();
		return ingredientes1;
	}

	@Override
	public Ingrediente consultarIngredienteByNombre(String nombreIngrediente) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			Ingrediente ingredientecito = (Ingrediente) session.createCriteria(Ingrediente.class)
					.add(Restrictions.eq("nombre", nombreIngrediente)).uniqueResult();
			return ingredientecito;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void guardarIngrediente(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ingrediente);
		
	}

	@Override
	public void eliminarIngredienteEnCombo(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(ingrediente);		
	}

	@Override
	public void guardarIngredienteEnCombo(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ingrediente); 
		
	}

	@Override
	public void persisirListaIngredienteAdmin(Set<Ingrediente> listaIngredientes) {
		for (Ingrediente ingrediente : listaIngredientes) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ingrediente);
		
	} 	
	
}

	@Override
	public void eliminarIngrediente(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(ingrediente);
		
	}
    //NUEVO
	@Override
	public List<Categoria> listarCategoria() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Categoria> categorias = session.createCriteria(Categoria.class)			
			.list();
		return categorias;
	}
	
	
	
	@Override
	public void guardarCategoria(Categoria categoria) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(categoria);
	}
}
