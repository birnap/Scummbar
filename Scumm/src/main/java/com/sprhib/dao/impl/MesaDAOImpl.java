package com.sprhib.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.dao.IMesaDAO;
import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;


@Repository
public class MesaDAOImpl implements IMesaDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addMesa(Mesa mesa) {
		getCurrentSession().save(mesa);
	}

	public void updateMesa(Mesa mesa) {
		Mesa mesaToUpdate = (Mesa) getCurrentSession().get(Mesa.class, mesa.getId());
		mesaToUpdate.setNumero(mesa.getNumero());
		mesaToUpdate.setCapacidad(mesa.getCapacidad());
		getCurrentSession().update(mesaToUpdate);

	}

	@SuppressWarnings("unchecked")
	public List<Mesa> getMesa() {
		return getCurrentSession().createQuery("from Mesa").list();
	}

}