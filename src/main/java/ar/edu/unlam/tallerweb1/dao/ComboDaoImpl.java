package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Pan;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

import javax.inject.Inject;

@Repository("comboDao")
public class ComboDaoImpl implements ComboDao { 

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Combo consultaComboById(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Combo combito = (Combo) session.createCriteria(Combo.class)
				.add(Restrictions.eq("idCombo", id)).uniqueResult();
		return combito;
	}
	
	@Override
	public void guardarCombo(Combo combo) {
		final Session session = sessionFactory.getCurrentSession();
		session.persist(combo);
		
	}

	@Override
	public Boolean validarCombo(Combo c1) {
		return null;
	}
		
	@Override
	public void desactivarCombo(Long id, Boolean estado) {
		final Session session = sessionFactory.getCurrentSession();
		Combo combo = consultaComboById(id);
		combo.setActivo(estado);
		session.saveOrUpdate(combo);		
	}
	@Override
	public List<Combo> listarCombosByUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Combo> combos = session.createCriteria(Combo.class)
			.add(Restrictions.eq("activo", true))
			.createAlias("usuarioCreador", "userCreador")
			.add(Restrictions.eq("userCreador.idUsuario",usuario.getIdUsuario()))
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
			.list();
		return combos;
	}
	
	@Override
	public void persistirListaCombo(List<Combo> combos) {
		for (Combo combo : combos) {
			final Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(combo);
		}
	}
	
}
