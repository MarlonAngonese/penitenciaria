package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.penitenciaria.models.Condenados;
import com.penitenciaria.repository.CondenadosRepository;

@Controller
public class CondenadosController {
	
	@Autowired
	private CondenadosRepository or;
	
	@RequestMapping(value="/condenados/add", method=RequestMethod.GET)
	public String form() {
		return "Condenados/addCondenados";
	}
	
	@RequestMapping(value="/condenados/add", method=RequestMethod.POST)
	public String form(Condenados condenado) {
		
		or.save(condenado);
		
		return "redirect:/condenados/add";
	}
}
