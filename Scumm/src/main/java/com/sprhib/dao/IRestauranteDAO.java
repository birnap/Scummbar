package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.entities.Restaurante;

public interface IRestauranteDAO {
	void addRestaurante(Restaurante restaurante);

	void updateRestaurante(Restaurante restaurante);

	Restaurante getRestaurante(Long id);

	void deleteRestaurante(Long id);

	public List<Restaurante> getRestaurante();
}
