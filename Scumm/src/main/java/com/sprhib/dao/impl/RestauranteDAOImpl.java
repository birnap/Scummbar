package com.sprhib.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.dao.IRestauranteDAO;
import com.sprhib.model.entities.Restaurante;

@Repository
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
	
	public Restaurante getRestaurante(Long id) {
		Restaurante restaurante = (Restaurante) getCurrentSession().get(Restaurante.class, id);
		return restaurante;
	}
	
	public void deleteRestaurante(Long id) {
		Restaurante restaurante = getRestaurante(id);
		if (restaurante != null)
			getCurrentSession().delete(restaurante);
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurante> getRestaurante() {
		//select * from reserva where localizador = 1224;
		return getCurrentSession().createQuery("from Restaurante").list();
	}
	
	//crear metodo para coger los datos del query con el hql
	
	
}
