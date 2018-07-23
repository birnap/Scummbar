package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.entities.Mesa;

public interface IMesaDAO {
	void addMesa(Mesa mesa);
	void updateMesa(Mesa mesa);
	public List<Mesa> getMesa();
//	List<Mesa> disponibilidadMesa(Mesa disponibilidadMesa);
}
