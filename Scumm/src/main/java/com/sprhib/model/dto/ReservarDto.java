package com.sprhib.model.dto;

import java.util.Date;
import java.util.List;

import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.entities.Turno;

public class ReservarDto {
	private List<Restaurante> restaurantes;
	private List<Turno> turnos;
	private List<Mesa> mesas;
	private List<Reserva> reservas;

	private Long restauranteId;
	private Date dia;
	private Long turnoId;
	private Integer personas;
	private Long mesaId;

	public Long getMesaId() {
		return mesaId;
	}

	public void setMesaId(Long mesaId) {
		this.mesaId = mesaId;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Long getRestauranteId() {
		return restauranteId;
	}

	public void setRestauranteId(Long restauranteId) {
		this.restauranteId = restauranteId;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Long getTurnoId() {
		return turnoId;
	}

	public void setTurnoId(Long turnoId) {
		this.turnoId = turnoId;
	}

	public Integer getPersonas() {
		return personas;
	}

	public void setPersonas(Integer personas) {
		this.personas = personas;
	}

}
