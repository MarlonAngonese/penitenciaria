package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		
		return "redirect:/sentencas";
	}
	
	@RequestMapping(value="/sentencas", method=RequestMethod.GET)
	public ModelAndView listaSentencas() {
		ModelAndView mv = new ModelAndView("Sentencas/indexSentencas");
		
		Iterable<Sentencas> sentencas = or.findAllByOrderByCodigoDesc();
		
		mv.addObject("sentencas", sentencas);
		
		return mv;
	}

	@RequestMapping(value="/sentencas/edit/{codigo}", method=RequestMethod.GET)
	public ModelAndView editarSentencas(@PathVariable("codigo") long codigo) {
		Sentencas sentenca = or.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("Sentencas/editSentencas");
		mv.addObject("sentenca", sentenca);
		return mv;
	}
	
	@RequestMapping(value="/sentencas/edit/{codigo}", method=RequestMethod.POST)
	public String editarSentencasP(Sentencas sentenca, @PathVariable("codigo") long codigo) {
		sentenca.setCodigo(codigo);
		or.save(sentenca);
		return "redirect:/sentencas";
	}
	
	@RequestMapping(value="/sentencas/delete/{codigo}", method=RequestMethod.GET)
	public String deletarSentencas(@PathVariable("codigo") long codigo) {
		Sentencas sentenca = or.findByCodigo(codigo);
		
		or.delete(sentenca);
		
		return "redirect:/sentencas";
	}
}
