package com.sprhib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.dto.ReservarDto;
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
		model.addObject("command", dto);
		return model;
	}

	@RequestMapping(value = "/reservado", method = RequestMethod.POST)
	public ModelAndView submitFormulario(ReservarDto dto) {
		ModelAndView model = new ModelAndView("reservado");

		Reserva reserva = new Reserva();
		Restaurante restaurante = new Restaurante();
		
		reserva.setDia(dto.getDia());
		reserva.setPersonas(dto.getPersonas());
		Turno turno = new Turno();
		turno.setId(dto.getTurnoId());
		reserva.setTurno(turno);
		restaurante.setId(dto.getRestauranteId());
		boolean result=negocioRestaurante.reservar(restaurante, reserva);
		
		if(result) {
			model.addObject("localizador", reserva.getLocalizador());
		}else {
			model.addObject("localizador", "Localizador no encontrado.");
		}
		return model;
	}

}
