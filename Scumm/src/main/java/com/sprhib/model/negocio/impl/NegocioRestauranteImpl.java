package com.sprhib.model.negocio.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.IRestauranteDAO;
import com.sprhib.dao.RestauranteDAOImpl;
import com.sprhib.model.Team;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.negocio.INegocioRestaurant;

@Service
@Transactional
public class NegocioRestauranteImpl implements INegocioRestaurant {
	
	@Autowired
	private IRestauranteDAO restauranteDao;
	
	
	public void addRestaurante(Restaurante restaurante) {
		restauranteDao.addRestaurante(restaurante);
	}

	public void updateRestaurante(Restaurante restaurante) {
		restauranteDao.updateRestaurante(restaurante);
	}	

	public List<Restaurante> getRestaurantes() {
		return restauranteDao.getRestaurante();

	}
	public Boolean reservar(final Restaurante restaurante, final Reserva reserva) {
		return null;

	}

	public Boolean cancelarReserva(final String localizador) {
		return null;

	}


}
