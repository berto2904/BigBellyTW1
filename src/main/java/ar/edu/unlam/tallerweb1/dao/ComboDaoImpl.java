package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;

import java.util.List;

import javax.inject.Inject;

@Repository("comboDao")
public class ComboDaoImpl implements ComboDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void guardarCombo(Combo combo) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(combo);		
	}

	@Override
	public Combo consultarComboByNombre(String descripcion) {
		try {
			final Session session = sessionFactory.getCurrentSession();
			Combo combito = (Combo) session.createCriteria(Combo.class)
					.add(Restrictions.eq("nombre", descripcion)).uniqueResult();
			return combito;
		} catch (Exception e) {
			return null;
		}
	}	

	@Override
	public void eliminarCombo(Combo combo) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(combo);		
	}

	@Override
	public List<Combo> listarCombo() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Combo> combos = session.createCriteria(Combo.class).list();
		return combos;
	}

	@Override
	public Combo consultarComboById(Long idCombo) {
		try {
		final Session session = sessionFactory.getCurrentSession();
		Combo combo = (Combo) session.createCriteria(Combo.class)
			.add(Restrictions.eq("idCombo", idCombo)).uniqueResult();
		return combo;
	} catch (Exception e) {
		return null;
	}
 }
}
