package com.sprhib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.entities.Restaurante;

@Controller
public class LinkController {

	@RequestMapping(value = "/")
	public ModelAndView mainPage() {

		return new ModelAndView("helloworld");
	}

	@RequestMapping(value = "/hello")
	public ModelAndView indexPage(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		//TODO
		//NegocioRestaurten.initData(){
//		restaranteDao.crearRestaurantes(){
//			Restaurante r1 = new Resturante();
//			r1.setDescripcion("mc");
//			
//			getSession.save(r1);
//		}
		model.addAttribute("name", name);
		return new ModelAndView("helloworld");
	}
}
