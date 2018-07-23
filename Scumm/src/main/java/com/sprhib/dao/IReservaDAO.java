package com.sprhib.dao;

import java.util.Date;
import java.util.List;

import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;

public interface IReservaDAO {
	void addReserva(Reserva reserva);

	void updateReserva(Reserva reserva);
	
	Reserva getReserva(Long id);

	Boolean deleteReserva(Reserva reserva);

	public List<Reserva> getReserva();
	
	List<Reserva> comprobarDiaDeReserva(Long restauranteId, Date diaReserva);
	
	List<Reserva> cancelarConLocalizador(Reserva reserva);
	
}
