package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.penitenciaria.models.Financeiros;
import com.penitenciaria.repository.FinanceirosRepository;

@Controller
public class FinanceirosController {
	
	@Autowired
	private FinanceirosRepository or;
	
	@RequestMapping(value="/financeiros/add", method=RequestMethod.GET)
	public String form() {
		return "Financeiros/addFinanceiros";
	}
	
	@RequestMapping(value="/financeiros/add", method=RequestMethod.POST)
	public String form(Financeiros financeiro) {
		
		or.save(financeiro);
		
		return "redirect:/financeiros";
	}
	
	@RequestMapping(value="/financeiros", method=RequestMethod.GET)
	public ModelAndView listaFinanceiros() {
		ModelAndView mv = new ModelAndView("Financeiros/indexFinanceiros");
		
		Iterable<Financeiros> financeiros = or.findAllByOrderByCodigoDesc();
		
		mv.addObject("financeiros", financeiros);
		
		return mv;
	}
	
	@RequestMapping(value="/financeiros/edit/{codigo}", method=RequestMethod.GET)
	public ModelAndView editarFinanceiros(@PathVariable("codigo") long codigo) {
		Financeiros financeiro = or.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("Financeiros/editFinanceiros");
		mv.addObject("financeiro", financeiro);
		return mv;
	}
	
	@RequestMapping(value="/financeiros/edit/{codigo}", method=RequestMethod.POST)
	public String editarFinanceirosP(Financeiros financeiro, @PathVariable("codigo") long codigo) {
		financeiro.setCodigo(codigo);
		or.save(financeiro);
		return "redirect:/financeiros";
	}
	
	@RequestMapping(value="/financeiros/delete/{codigo}", method=RequestMethod.GET)
	public String deletarFinanceiros(@PathVariable("codigo") long codigo) {
		Financeiros financeiro = or.findByCodigo(codigo);
		
		or.delete(financeiro);
		
		return "redirect:/financeiros";
	}
}
