package com.sprhib.model.negocio.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.IMesaDAO;
import com.sprhib.dao.IReservaDAO;
import com.sprhib.dao.IRestauranteDAO;
import com.sprhib.dao.ITurnoDAO;
import com.sprhib.formato.horas.impl.CrearIdHoraActualImpl;
import com.sprhib.model.dto.ReservarDto;
import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.entities.Turno;
import com.sprhib.model.negocio.INegocioRestaurant;

@Service
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

	public Restaurante getRestaurante(Long id) {
		return restauranteDAO.getRestaurante(id);
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

	public void initData() {
		List<Turno> turnos = new ArrayList<Turno>() {
			{
				add(new Turno((long) 1, "de 13:00h a 15:00h"));
				add(new Turno((long) 2, "de 15:00h a 17:00h"));
				add(new Turno((long) 3, "de 20:00h a 22:00h"));
				add(new Turno((long) 4, "de 22:00h a 00:00h"));

			}
		};
		if (turnoDAO.getTurno().isEmpty()) {
			for (Turno turno : turnos) {
				turnoDAO.addTurno(turno);
			}
		}

		final ArrayList<Mesa> mesas1 = new ArrayList<Mesa>() {
			{
				add(new Mesa((long) 1, 4, 1, new ArrayList<Reserva>()));
				add(new Mesa((long) 2, 6, 2, new ArrayList<Reserva>()));
				add(new Mesa((long) 3, 4, 3, new ArrayList<Reserva>()));
				add(new Mesa((long) 4, 8, 4, new ArrayList<Reserva>()));
				add(new Mesa((long) 5, 7, 5, new ArrayList<Reserva>()));
			}
		};

		final ArrayList<Mesa> mesas2 = new ArrayList<Mesa>() {
			{
				add(new Mesa((long) 6, 4, 1, new ArrayList<Reserva>()));
				add(new Mesa((long) 7, 6, 2, new ArrayList<Reserva>()));
				add(new Mesa((long) 8, 4, 3, new ArrayList<Reserva>()));
				add(new Mesa((long) 9, 8, 4, new ArrayList<Reserva>()));
			}
		};

		final ArrayList<Mesa> mesas3 = new ArrayList<Mesa>() {
			{
				add(new Mesa((long) 10, 4, 1, new ArrayList<Reserva>()));
				add(new Mesa((long) 11, 6, 2, new ArrayList<Reserva>()));
				add(new Mesa((long) 12, 4, 3, new ArrayList<Reserva>()));
				add(new Mesa((long) 13, 8, 4, new ArrayList<Reserva>()));
			}
		};

		if (mesaDAO.getMesa().isEmpty()) {
			for (Mesa mesa : mesas1) {
				mesaDAO.addMesa(mesa);
			}
			for (Mesa mesa : mesas2) {
				mesaDAO.addMesa(mesa);
			}
			for (Mesa mesa : mesas3) {
				mesaDAO.addMesa(mesa);
			}
		}
		// public Restaurante(Long id, String nombre, String direccion, String
		// descripcion, List<Mesa> mesas) {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>() {
			{
				add(new Restaurante((long) 1, "Saiko", "P.Sherman calle wallaby 42 Sidney", "Restaurante comida rápida",
						mesas1));
				add(new Restaurante((long) 2, "Yoshino", "Calle Mallorca 128", "Japones", mesas2));
				add(new Restaurante((long) 3, "McDonalds", "Calle Jerez 98", "Restaurante comida rápida", mesas3));
			}
		};

		if (restauranteDAO.getRestaurante().isEmpty()) {
			for (Restaurante restaurante : restaurantes) {
				restauranteDAO.addRestaurante(restaurante);
			}
		}

	}

	public Boolean buscarMesa(ReservarDto dto, Reserva reserva) {
		// ReservarDto dto = new ReservarDto();
		// Reserva reserva = new Reserva();

		List<Mesa> mesas = getRestaurante(dto.getRestauranteId()).getMesas();
		// List<Restaurante> restaurantes = dto.getRestaurantes();
		boolean result = false;
		List<Mesa> mesasSeleccionables = new ArrayList<>();

		for (Mesa mesa : mesas) {
			if (mesa.getCapacidad() >= reserva.getPersonas()) {
				// Coge los valores de 1 en 1 pero por vuelta bien.
				mesa.setId(mesa.getId());

				// Primera vuelta obtiene el valor del id y lo guarda en reserva.mesa
				reserva.setMesa(mesa);

				List<Reserva> listaReservas = mesa.getReservas();
				boolean found = false;
				for (Reserva res : listaReservas) {
					if (res.getDia().compareTo(reserva.getDia()) == 0) {
						if (res.getTurno().getId() == reserva.getTurno().getId()) {
							found = true;
						}
					}
				}

				// Se le añade a mesasSeleccionables la mesa que cumpla la capacidad con
				// personas
				if (found == false) {
					mesasSeleccionables.add(mesa);
				}

			}
		}

		if (!mesasSeleccionables.isEmpty()) {
			Mesa mesa = mesasSeleccionables.get(0);
			reserva.setMesa(mesa);
			mesa.getReservas().add(reserva);
			updateMesa(mesa);
			result = reservar(reserva);
		}

		return result;
	}

	public Boolean reservar(final Reserva reserva) {
		CrearIdHoraActualImpl crearId = new CrearIdHoraActualImpl();
		reserva.setLocalizador(crearId.obtenerHora());

		if (reserva != null) {
			reservaDAO.addReserva(reserva);
			return true;
		} else {
			return false;
		}

		// List<Reserva> lista = reservaDAO.comprobarDiaDeReserva(restaurante.getId(),
		// reserva.getDia());

		// restaurante = restauranteDAO.getRestaurante(restaurante.getId());

		// List<Mesa> mesas = restaurante.getMesas().stream().filter(j ->
		// isTableFreeOn(j, reservas, personas, turno))
		// .sorted((o1, o2) ->
		// o1.getCapacidad().compareTo(o2.getCapacidad())).collect(Collectors.toList());

		// Stream stream = lista.stream();
		// .flatMap(Array::stream);

		// https://www.oracle.com/technetwork/es/articles/java/expresiones-lambda-api-stream-java-2737544-esa.html
		// disponibles.stream().filter <--- algo asi, es un filtro.

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
