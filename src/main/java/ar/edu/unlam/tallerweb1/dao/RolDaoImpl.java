package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Rol;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("RolDao")
public class RolDaoImpl implements RolDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Rol consultarRolPorId(Long idRol) {
		final Session session = sessionFactory.getCurrentSession();
		Rol rol = (Rol) session.createCriteria(Rol.class)
				.add(Restrictions.eq("id", idRol))
				.uniqueResult();
		return rol;
	}
	
}
