package com.sprhib.model.negocio;

import java.util.List;

import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;

public interface INegocioRestaurant {
	void addRestaurante(Restaurante restaurante);
	void updateRestaurante(Restaurante restaurante);
	Boolean reservar(final Restaurante restaurante, final Reserva reservas);
	Boolean cancelarReserva(final String localizador);
	List<Restaurante> getRestaurantes();
	
}