package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.entities.Reserva;

public interface IReservaDAO {
	void addReserva(Reserva reserva);

	void updateReserva(Reserva reserva);
	
	Reserva getReserva(Long id);

	void deleteReserva(Reserva reserva);

	public List<Reserva> getReserva();
}
