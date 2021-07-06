package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.penitenciaria.models.Ocupacoes;
import com.penitenciaria.repository.OcupacoesRepository;

@Controller
public class OcupacoesController {
	
	@Autowired
	private OcupacoesRepository or;
	
	@RequestMapping(value="/ocupacoes/add", method=RequestMethod.GET)
	public String form() {
		return "Ocupacoes/addOcupacoes";
	}
	
	@RequestMapping(value="/ocupacoes/add", method=RequestMethod.POST)
	public String form(Ocupacoes ocupacao) {
		
		or.save(ocupacao);
		
		return "redirect:/ocupacoes/add";
	}
	
	@RequestMapping(value="/ocupacoes", method=RequestMethod.GET)
	public ModelAndView listaOcupacoes() {
		ModelAndView mv = new ModelAndView("Ocupacoes/indexOcupacoes");
		
		Iterable<Ocupacoes> ocupacoes = or.findAll();
		
		mv.addObject("ocupacoes", ocupacoes);
		
		return mv;
	}
}
