package com.sprhib.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Mesa", catalog = "everistest")
public class Mesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "numero", nullable = false)
	private Integer numero;
	@Column(name = "capacidad", nullable = false)
	private Integer capacidad;
	
	@OneToMany
	private List<Reserva> reservas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public Mesa (Long id, Integer numero, Integer capacidad, ArrayList<Reserva> listaReservas) {
		this.id=id;
		this.numero=numero;
		this.capacidad=capacidad;
		this.reservas=listaReservas;
	}
	
	//Inicializacion para coger Mesa vacia.
	public Mesa() {
		
	}
	
	
	
}
