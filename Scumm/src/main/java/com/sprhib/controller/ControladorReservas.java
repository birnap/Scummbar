package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.formato.horas.impl.CrearIdHoraActualImpl;
import com.sprhib.model.dto.ReservarDto;
import com.sprhib.model.entities.Mesa;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.entities.Turno;
import com.sprhib.model.negocio.INegocioRestaurant;

@Controller
public class ControladorReservas {

	@Autowired
	INegocioRestaurant negocioRestaurante;

	@RequestMapping(value = "/reservar", method = RequestMethod.GET)
	public ModelAndView verFormulario() {
		ModelAndView model = new ModelAndView("reservar");

		ReservarDto dto = new ReservarDto();
		dto.setRestaurantes(negocioRestaurante.getRestaurantes());
		dto.setTurnos(negocioRestaurante.getTurnos());
		// dto.setMesas(negocioRestaurante.getMesas());
		// List<Mesa> mesas = dto.getMesas();
		// int i = 5;
		// List<Mesa> mesasSeleccionables = new ArrayList<>();
		// for (Mesa mesa : mesas) {
		// if (mesa.getCapacidad() >= i)
		// mesasSeleccionables.add(mesa);
		// }
		model.addObject("command", dto);
		return model;
	}

	@RequestMapping(value = "/reservado", method = RequestMethod.POST)
	public ModelAndView submitFormulario(ReservarDto dto) {
		ModelAndView model = new ModelAndView("reservado");
		CrearIdHoraActualImpl crearId = new CrearIdHoraActualImpl();

		Reserva reserva = new Reserva();
		Restaurante restaurante = new Restaurante();
		Turno turno = new Turno();
		Mesa mesa = new Mesa();

		reserva.setDia(dto.getDia());
		reserva.setPersonas(dto.getPersonas());

		turno.setId(dto.getTurnoId());
		reserva.setTurno(turno);

		restaurante.setId(dto.getRestauranteId());
		reserva.setRestaurante(restaurante);

		mesa.setId(crearId.obtenerIdentificadorMesa());

		// Recorrer mesa para ver id
		dto.setMesas(negocioRestaurante.getMesas());
		List<Mesa> mesas = dto.getMesas();

		// prueba con variable
		int i = 9;
		boolean result=false;
		List<Mesa> mesasSeleccionables = new ArrayList<>();
		for (Mesa listaMesa : mesas) {
//			for(Reserva numPersonas : ) {
//				
//			}
			if (listaMesa.getCapacidad() >= i) {
				mesasSeleccionables.add(listaMesa);
			}
		}

		// Cuando no tenga a ningun valor no creara reserva

		if (mesasSeleccionables != null) {
			result = negocioRestaurante.reservar(restaurante, reserva);
		}

		model.addObject("estado", result);
		model.addObject("localizador", reserva.getLocalizador());
		model.addObject("dia", reserva.getDia());
		model.addObject("personas", reserva.getPersonas());

		return model;
	}

}
