package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.penitenciaria.models.Sentencas;
import com.penitenciaria.repository.SentencasRepository;

@Controller
public class SentencasController {
	
	@Autowired
	private SentencasRepository or;
	
	@RequestMapping(value="/sentencas/add", method=RequestMethod.GET)
	public String form() {
		return "Sentencas/addSentencas";
	}
	
	@RequestMapping(value="/sentencas/add", method=RequestMethod.POST)
	public String form(Sentencas sentenca) {
		
		or.save(sentenca);
		
		return "redirect:/sentencas/add";
	}
}
