package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhib.model.entities.Restaurante;

@Service
public class RestauranteDAOImpl implements IRestauranteDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addRestaurante(Restaurante restaurante) {
		getCurrentSession().save(restaurante);
	}

	public void updateRestaurante(Restaurante restaurante) {
		Restaurante restauranateToUpdate = (Restaurante) getCurrentSession().get(Restaurante.class, restaurante.getId());
		restauranateToUpdate.setNombre(restaurante.getNombre());
		restauranateToUpdate.setDescripcion(restaurante.getDescripcion());
		restauranateToUpdate.setDireccion(restaurante.getDireccion());
		getCurrentSession().update(restauranateToUpdate);

	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurante> getRestaurante() {
		return getCurrentSession().createQuery("from Restaurante").list();
	}

	
}
