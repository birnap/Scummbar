package com.sprhib.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.dao.IReservaDAO;
import com.sprhib.model.entities.Reserva;

@Repository
public class ReservaDAOImpl implements IReservaDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addReserva(Reserva reserva) {
		getCurrentSession().save(reserva);
	}

	public void updateReserva(Reserva reserva) {
		Reserva reservaToUpdate = (Reserva) getCurrentSession().get(Reserva.class, reserva.getId());
		reservaToUpdate.setDia(reserva.getDia());
		reservaToUpdate.setLocalizador(reserva.getLocalizador());
		reservaToUpdate.setPersonas(reserva.getPersonas());
		reservaToUpdate.setTurno(reserva.getTurno());
		getCurrentSession().update(reservaToUpdate);

	}

	public Reserva getReserva(Long id) {
		Reserva reserva = (Reserva) getCurrentSession().get(Reserva.class, id);
		return reserva;
	}

//	public void deleteReserva(Long id) {
//		Reserva reserva = getReserva(id);
//		if (reserva != null)
//			getCurrentSession().delete(reserva);
//	}

	@SuppressWarnings("unchecked")
	public List<Reserva> getReserva() {
		return getCurrentSession().createQuery("from Reserva").list();
	}

	public void deleteReserva(Reserva reserva) {
		if (reserva != null) {
			Query query = getCurrentSession().createQuery("delete Reserva where localizador = :localizador");
			query.setParameter("localizador", reserva.getLocalizador());
			query.executeUpdate();
		}
	}

}
