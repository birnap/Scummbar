package com.sprhib.model.negocio;

import java.util.List;

import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.entities.Turno;

public interface INegocioRestaurant {
	void addRestaurante(Restaurante restaurante);
	void updateRestaurante(Restaurante restaurante);
	void deleteRestaurante(Long id);
	
	void addReserva(Reserva reserva);
	void updateReserva(Reserva reserva);
	void deleteReserva(Reserva reserva);
	
	void addTurno(Turno turno);
	void updateTurno(Turno turno);
	void deleteTurno(Long id);
	
	void addMesa(Mesa mesa);
	void updateMesa(Mesa mesa);

	List<Restaurante> getRestaurantes();
	List<Reserva> getReservas();
	List<Turno> getTurnos();
	List<Mesa> getMesas();
	Boolean reservar(final Restaurante restaurante, final Reserva reservas);
	Boolean cancelarReserva(final Reserva reserva);
}