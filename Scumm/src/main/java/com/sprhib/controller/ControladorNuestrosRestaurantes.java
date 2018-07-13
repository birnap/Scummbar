package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.entities.Restaurante;
import com.sprhib.model.negocio.INegocioRestaurant;

@Controller
public class ControladorNuestrosRestaurantes {
	@Autowired
	private INegocioRestaurant negocioRestaurante;

	@RequestMapping(value = "/restaurantes", method = RequestMethod.GET)
	public ModelAndView allRestaurantes() {
		ModelAndView model = new ModelAndView("restaurantes");
		
		List<Restaurante> listaRestaurantes = negocioRestaurante.getRestaurantes();
		model.addObject("listaRestaurantes", listaRestaurantes);
		
		return model;
	}
}