package com.sprhib.model.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.IMesaDAO;
import com.sprhib.dao.IReservaDAO;
import com.sprhib.dao.IRestauranteDAO;
import com.sprhib.dao.ITurnoDAO;
import com.sprhib.formato.horas.impl.CrearIdHoraActualImpl;
import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.entities.Turno;
import com.sprhib.model.negocio.INegocioRestaurant;

@Repository
@Transactional
public class NegocioRestauranteImpl implements INegocioRestaurant {

	@Autowired
	private IRestauranteDAO restauranteDAO;

	@Autowired
	private IReservaDAO reservaDAO;

	@Autowired
	private ITurnoDAO turnoDAO;

	@Autowired
	private IMesaDAO mesaDAO;

	public void addRestaurante(Restaurante restaurante) {
		restauranteDAO.addRestaurante(restaurante);
	}

	public void updateRestaurante(Restaurante restaurante) {
		restauranteDAO.updateRestaurante(restaurante);
	}

	public void deleteRestaurante(Long id) {
		restauranteDAO.deleteRestaurante(id);
	}

	public void addReserva(Reserva reserva) {
		reservaDAO.addReserva(reserva);
	}

	public void updateReserva(Reserva reserva) {
		reservaDAO.updateReserva(reserva);
	}

	public void deleteReserva(Reserva reserva) {
		reservaDAO.deleteReserva(reserva);
	}

	public void addTurno(Turno turno) {
		turnoDAO.addTurno(turno);
	}

	public void updateTurno(Turno turno) {
		turnoDAO.updateTurno(turno);
	}

	public void deleteTurno(Long id) {
		turnoDAO.deleteTurno(id);
	}

	public void addMesa(Mesa mesa) {
		mesaDAO.addMesa(mesa);
	}

	public void updateMesa(Mesa mesa) {
		mesaDAO.updateMesa(mesa);
	}

	public List<Restaurante> getRestaurantes() {
		return restauranteDAO.getRestaurante();

	}

	public List<Reserva> getReservas() {
		return reservaDAO.getReserva();
	}

	public List<Turno> getTurnos() {
		return turnoDAO.getTurno();

	}

	public List<Mesa> getMesas() {
		return mesaDAO.getMesa();
	}

	public Boolean reservar(Restaurante restaurante, final Reserva reserva) {
		CrearIdHoraActualImpl crearId = new CrearIdHoraActualImpl();
		Mesa mesa = new Mesa();
		reserva.setLocalizador(crearId.obtenerHora());
		
		mesa.setId(crearId.obtenerIdentificadorMesa());
		reserva.setMesa(mesa);
		
//		List<Reserva> lista = reservaDAO.comprobarDiaDeReserva(restaurante.getId(), reserva.getDia());
		
//		restaurante = restauranteDAO.getRestaurante(restaurante.getId());
		
		
//		List<Mesa> mesas = restaurante.getMesas().stream().filter(j -> isTableFreeOn(j, reservas, personas, turno))
//				.sorted((o1, o2) -> o1.getCapacidad().compareTo(o2.getCapacidad())).collect(Collectors.toList());

		// Stream stream = lista.stream();
		// .flatMap(Array::stream);

		// https://www.oracle.com/technetwork/es/articles/java/expresiones-lambda-api-stream-java-2737544-esa.html
		// disponibles.stream().filter <--- algo asi, es un filtro.
		if (reserva != null) {
			reservaDAO.addReserva(reserva);
			return true;
		} else {
			return false;
		}
	}

	public Boolean cancelarReserva(final Reserva reserva) {
		List<Reserva> lista = reservaDAO.cancelarConLocalizador(reserva);
		if (!lista.isEmpty()) {
			reservaDAO.deleteReserva(reserva);
			return true;
		} else {
			return false;
		}

	}

}
