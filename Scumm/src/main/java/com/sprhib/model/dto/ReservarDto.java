package com.sprhib.model.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.entities.Turno;

public class ReservarDto {
	private List<Restaurante> restaurantes;
	private List<Turno> turnos;
	
	private Long restauranteId;
	private Date dia;
	private Turno turnoId;
	private Integer personas;
	public List<Restaurante> getRestauranates() {
		return restaurantes;
	}
	public void setRestaurantes(Collection<Restaurante> collection) {
		this.restaurantes = (List<Restaurante>) collection;
	}
	public List<Turno> getTurnos() {
		return turnos;
	}
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
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
	public Turno getTurnoId() {
		return turnoId;
	}
	public void setTurnoId(Turno turnoId) {
		this.turnoId = turnoId;
	}
	public Integer getPersonas() {
		return personas;
	}
	public void setPersonas(Integer personas) {
		this.personas = personas;
	}
	
}
