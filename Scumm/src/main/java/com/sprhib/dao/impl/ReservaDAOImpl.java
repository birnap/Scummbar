package com.sprhib.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.dao.IReservaDAO;
import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;

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

	@SuppressWarnings("unchecked")
	public List<Reserva> getReserva() {
		return getCurrentSession().createQuery("from Reserva").list();
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> comprobarDiaDeReserva(Long restauranteId, Date diaReserva) {
		Query query = getCurrentSession().createQuery("from Reserva where restaurante_id = :restaurante_id");
		query.setParameter("restaurante_id", restauranteId);
		query.setParameter("diaReserva", diaReserva);
		return query.list();
	}

	public Boolean deleteReserva(Reserva reserva) {
		Query query = getCurrentSession().createQuery("delete from Reserva where localizador = :localizador");
		query.setParameter("localizador", reserva.getLocalizador());
		int result = query.executeUpdate();
		if (result != 0) {
			return true;
		} else {
			return false;
		}
	}

//	@SuppressWarnings("unchecked")
//	public List<Mesa> crearInterrelacionRestauranteMesa(Mesa mesa, Restaurante restaurante) {
//		Query query = getCurrentSession()
//				.createQuery("insert into restaurante_mesa from restaurante inner join id on restaurante_mesa.Restaurante_id where restaurante.id=");
//		query.setParameter("idMesa", mesa.getId());
//		query.setParameter("idRestaurante", restaurante.getId());
//		return query.list();
//	}

	@SuppressWarnings("unchecked")
	public List<Reserva> cancelarConLocalizador(Reserva reserva) {
		Query query = getCurrentSession().createQuery("from Reserva where localizador = :localizador AND dia = :dia");
		query.setParameter("localizador", reserva.getLocalizador());
		query.setDate("dia", reserva.getDia());
		return query.list();
	}
}
