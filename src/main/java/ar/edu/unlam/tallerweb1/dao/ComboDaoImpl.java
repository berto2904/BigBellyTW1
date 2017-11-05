package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;

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
	public List<Combo> listarComboConStock() {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Combo> combos = session.createCriteria(Combo.class)
				.createAlias("ingrediente", "ingr")
				.add(Restrictions.gt("ingr.stock", "0"))
				.list();
			return combos;
	}
	
}
