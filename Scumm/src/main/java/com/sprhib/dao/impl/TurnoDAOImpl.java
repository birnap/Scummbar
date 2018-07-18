package com.sprhib.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.dao.ITurnoDAO;
import com.sprhib.model.entities.Turno;

@Repository
public class TurnoDAOImpl implements ITurnoDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTurno(Turno turno) {
		getCurrentSession().save(turno);
	}

	public void updateTurno(Turno turno) {
		Turno turnoToUpdate = (Turno) getCurrentSession().get(Turno.class, turno.getId());
		turnoToUpdate.setDescripcion(turno.getDescripcion());
		getCurrentSession().update(turnoToUpdate);

	}
	
	public Turno getTurno(Long id) {
		Turno turno = (Turno) getCurrentSession().get(Turno.class, id);
		return turno;
	}
	
	public void deleteTurno(Long id) {
		Turno turno = getTurno(id);
		if (turno != null)
			getCurrentSession().delete(turno);
	}
	
	@SuppressWarnings("unchecked")
	public List<Turno> getTurno() {
		return getCurrentSession().createQuery("from Turno").list();
	}

}
