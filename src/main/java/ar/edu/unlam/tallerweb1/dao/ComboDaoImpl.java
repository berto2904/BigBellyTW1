package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
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
	
}
