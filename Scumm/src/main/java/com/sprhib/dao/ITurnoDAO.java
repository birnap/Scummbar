package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.entities.Turno;

public interface ITurnoDAO {
	void addTurno(Turno turno);

	void updateTurno(Turno turno);

	Turno getTurno(Long id);

	void deleteTurno(Long id);

	public List<Turno> getTurno();

}
