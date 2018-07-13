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
//
//	@Autowired
//	private INegocioRestaurant negocioRestaurante;
//
//	@RequestMapping(value = "/reservar", method = RequestMethod.GET)
//	public ModelAndView verFormulario() {
//		ModelAndView model = new ModelAndView("reservar");
//		
//		ReservarDto dto = new ReservarDto();
//		dto.setRestaurantes(negocioRestaurante.getRestaurantes());
//		return model;
//	}
//
//	@RequestMapping(value = "/reservar", method = RequestMethod.POST)
//	public ModelAndView submitFormulario(ReservarDto dto) {
//		ModelAndView model = new ModelAndView("reservado");
//
//		Reserva reserva = new Reserva();
//		reserva.setDia(dto.getDia());
//		reserva.setPersonas(dto.getPersonas());
//		reserva.setTurno(dto.getTurnoId());
//		
//		Restaurante restaurante = new Restaurante();
//		restaurante.setId(dto.getRestauranteId());
//
//		model.addObject("localizador", negocioRestaurante.reservar(restaurante, reserva));
//		return model;
//	}

}
