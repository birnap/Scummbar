package com.sprhib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.negocio.INegocioRestaurant;
import com.sprhib.model.negocio.impl.NegocioRestauranteImpl;

@Controller
public class ControladorDeLinks {
	@Autowired
	INegocioRestaurant negocioRestauranteImpl;
	
	@RequestMapping(value = "/")
	public ModelAndView mainPage(){
		negocioRestauranteImpl.initData();
		return new ModelAndView("menu");
	}	
}
