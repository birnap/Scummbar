package com.sprhib.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
		model.addObject("command", dto);
		return model;
	}

	@RequestMapping(value = "/reservado", method = RequestMethod.POST)
	public ModelAndView submitFormulario(ReservarDto dto) {
		ModelAndView model = new ModelAndView("reservado");
		// CrearIdHoraActualImpl crearId = new CrearIdHoraActualImpl();

		Reserva reserva = new Reserva();
		Restaurante restaurante = new Restaurante();
		Turno turno = new Turno();
//		Mesa mesa = new Mesa();

		//Tipos de datos coge.
		reserva.setDia(dto.getDia());
		reserva.setPersonas(dto.getPersonas());

		restaurante.setId(dto.getRestauranteId());
		reserva.setRestaurante(restaurante);
		
		turno.setId(dto.getTurnoId());
		reserva.setTurno(turno);

//		// Recorrer mesa para ver id
//		dto.setMesas(negocioRestaurante.getMesas());
//
//		dto.setRestaurantes(negocioRestaurante.getRestaurantes());
//		dto.setTurnos(negocioRestaurante.getTurnos());
//		Collection<Mesa> mesas = negocioRestaurante.getRestaurante(dto.getRestauranteId()).getMesas();
//		
//		List<Restaurante> restaurantes = dto.getRestaurantes();
//		List<Turno> turnos = dto.getTurnos();
////		 Falta poner que si pasa la cantidad de mesas no pueda reservar.
//		boolean result = false;
//		// boolean resultDia = negocioRestaurante.cancelarReserva(reserva);
//		List<Mesa> mesasSeleccionables = new ArrayList<>();
//////		
//		for (Mesa listaMesa : mesas) {
//			if (listaMesa.getCapacidad() >= reserva.getPersonas()) {
//				// Coge los valores de 1 en 1 pero por vuelta bien.
//				mesa.setId(dto.getMesaId());
//				listaMesa.setId(listaMesa.getId());
//				
//				
////				Primera vuelta obtiene el valor del id y lo guarda en reserva.mesa
//				reserva.setMesa(listaMesa);
//				
////				Se le añade a mesasSeleccionables la mesa que cumpla la capacidad con personas
//				mesasSeleccionables.add(listaMesa);
//				
//				
////				TODO Filtro turnos (por acabar)
////				for(Turno listaTurno : turnos) {
////					listaTurno.setId(listaTurno.getId());
////					if(listaTurno == reserva.getTurno()) {
////						
////						break;
////					}
////				}
//				
//	
////				TODO Quitar comentarios al if para que funcione
////				if (listaMesa != reserva.getMesa() //&& condicion AND de turno para poder hacer el filtro de mesas y solo coja la disponible) {
//					
//					
////				} else {
////					break;
////				} 
//
//				// Antes de guardar las mesas tiene que comprobar que no este ocupada (turno y
//				// restaurante disponibles).
//
//				// if(listaMesa.getId()) {
//				
//				// }
//				// reserva.setMesa(mesa);
//				if (!mesasSeleccionables.isEmpty()) {
//					result = negocioRestaurante.reservar(reserva);
//				}
//			}		
//		}

		//
		// dto.setReservas(negocioRestaurante.getReservas());
		// List<Reserva> reservas = dto.getReservas();
		//
		// List<Reserva> diasDisponibles = new ArrayList<>();
		// for(Reserva listaDias : reservas) {
		// if(listaDias.getDia() == ) {
		//
		// }else {
		//
		// }
		// }

		// Cuando no tenga a ningun valor no creara reserva

		model.addObject("estado", negocioRestaurante.buscarMesa(dto, reserva));
		model.addObject("localizador", reserva.getLocalizador());
		model.addObject("dia", reserva.getDia());
		model.addObject("personas", reserva.getPersonas());

		return model;
	}

}