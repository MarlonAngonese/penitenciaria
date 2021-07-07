package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.penitenciaria.models.Policiais;
import com.penitenciaria.repository.PoliciaisRepository;

@Controller
public class PoliciaisController {
	
	@Autowired
	private PoliciaisRepository or;
	
	@RequestMapping(value="/policiais/add", method=RequestMethod.GET)
	public String form() {
		return "Policiais/addPoliciais";
	}
	
	@RequestMapping(value="/policiais/add", method=RequestMethod.POST)
	public String form(Policiais policial) {
		
		or.save(policial);
		
		return "redirect:/policiais";
	}
	
	@RequestMapping(value="/policiais", method=RequestMethod.GET)
	public ModelAndView listaPoliciais() {
		ModelAndView mv = new ModelAndView("Policiais/indexPoliciais");
		
		Iterable<Policiais> policiais = or.findAllByOrderByCodigoDesc();
		
		mv.addObject("policiais", policiais);
		
		return mv;
	}
	
	@RequestMapping(value="/policiais/edit/{codigo}", method=RequestMethod.GET)
	public ModelAndView editarPoliciais(@PathVariable("codigo") long codigo) {
		Policiais policial = or.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("Policiais/editPoliciais");
		mv.addObject("policial", policial);
		return mv;
	}
	
	@RequestMapping(value="/policiais/edit/{codigo}", method=RequestMethod.POST)
	public String editarPoliciaisP(Policiais policial, @PathVariable("codigo") long codigo) {
		policial.setCodigo(codigo);
		or.save(policial);
		return "redirect:/policiais";
	}
	
	@RequestMapping(value="/policiais/delete/{codigo}", method=RequestMethod.GET)
	public String deletarPoliciais(@PathVariable("codigo") long codigo) {
		Policiais policial = or.findByCodigo(codigo);
		
		or.delete(policial);
		
		return "redirect:/policiais";
	}
}
