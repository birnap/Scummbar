package com.sprhib.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurante", catalog = "everistest")
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;

	@Column(name = "descripcion", nullable = false, length = 500)
	private String descripcion;

	@OneToMany(fetch= FetchType.EAGER)
	private List<Mesa> mesas = new ArrayList<Mesa>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public Restaurante(Long id, String nombre, String direccion, String descripcion, List<Mesa> mesas) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.mesas = mesas;
	}
	
	public Restaurante() {
		
	}
}
