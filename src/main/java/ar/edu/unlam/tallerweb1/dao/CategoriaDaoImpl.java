package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pan;

import java.util.List;

import javax.inject.Inject;

@Repository("categoriaDao")
public class CategoriaDaoImpl implements CategoriaDao {

	@Inject
    private SessionFactory sessionFactory;

	
}
