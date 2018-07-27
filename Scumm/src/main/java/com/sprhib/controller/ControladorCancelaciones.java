package com.sprhib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.dto.CancelarDto;
import com.sprhib.model.entities.Reserva;
import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.entities.Turno;
import com.sprhib.model.negocio.INegocioRestaurant;

@Controller
public class ControladorCancelaciones {

	@Autowired
	INegocioRestaurant negocioRestaurante;

	@RequestMapping(value = "/cancelar", method = RequestMethod.GET)
	public ModelAndView verFormulario() {
		ModelAndView model = new ModelAndView("cancelar");

		CancelarDto dto = new CancelarDto();
		dto.setRestaurantes(negocioRestaurante.getRestaurantes());
		dto.setTurnos(negocioRestaurante.getTurnos());
		model.addObject("command", dto);
		return model;
	}

	@RequestMapping(value = "/cancelado", method = RequestMethod.POST)
	public ModelAndView submitFormulario(CancelarDto dto) {
		ModelAndView model = new ModelAndView("cancelado");
		Reserva reserva = new Reserva();
		Restaurante restaurante = new Restaurante();
		Turno turno = new Turno();

		reserva.setDia(dto.getDia());
		turno.setId(dto.getTurnoId());
		reserva.setTurno(turno);
		reserva.setLocalizador(dto.getLocalizador());
		restaurante.setId(dto.getRestauranteId());

		boolean result = negocioRestaurante.cancelarReserva(reserva);
		
		model.addObject("estado", result);
		model.addObject("localizador", reserva.getLocalizador());
		model.addObject("dia",reserva.getDia());
		return model;
	}
}
