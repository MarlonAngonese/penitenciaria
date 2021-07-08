package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.penitenciaria.models.Cozinheiros;
import com.penitenciaria.repository.CozinheirosRepository;

@Controller
public class CozinheirosController {
	
	@Autowired
	private CozinheirosRepository cr;
	
	//Adicionar - Get
	@RequestMapping(value="/cozinheiros/add", method=RequestMethod.GET)
	public String form() {
		return "Cozinheiros/addCozinheiros";
	}
	
	//Adicionar - Post
	@RequestMapping(value="/cozinheiros/add", method=RequestMethod.POST)
	public String form(Cozinheiros cozinheiro) {
		
		cr.save(cozinheiro);
		
		return "redirect:/cozinheiros";
	}
	
	//Index - Listagem de Registros
	@RequestMapping(value="/cozinheiros", method=RequestMethod.GET)
	public ModelAndView listaCozinheiros() {
		ModelAndView mv = new ModelAndView("Cozinheiros/indexCozinheiros");
		
		Iterable<Cozinheiros> cozinheiros = cr.findAllByOrderByCodigoDesc();
		
		mv.addObject("cozinheiros", cozinheiros);
		
		return mv;
	}
	
	//Editar - Get
	@RequestMapping(value="/cozinheiros/edit/{codigo}", method=RequestMethod.GET)
	public ModelAndView editarCozinheiros(@PathVariable("codigo") long codigo) {
		Cozinheiros cozinheiro = cr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("Cozinheiros/editCozinheiros");
		mv.addObject("cozinheiro", cozinheiro);
		return mv;
	}
	
	//Editar - Post
	@RequestMapping(value="/cozinheiros/edit/{codigo}", method=RequestMethod.POST)
	public String editarCozinheirosP(Cozinheiros cozinheiro, @PathVariable("codigo") long codigo) {
		cozinheiro.setCodigo(codigo);
		cr.save(cozinheiro);
		return "redirect:/cozinheiros";
	}
	
	//Excluir (Deletar)
	@RequestMapping(value="/cozinheiros/delete/{codigo}", method=RequestMethod.GET)
	public String deletarCozinheiros(@PathVariable("codigo") long codigo) {
		Cozinheiros cozinheiro = cr.findByCodigo(codigo);
		
		cr.delete(cozinheiro);
		
		return "redirect:/cozinheiros";
	}
}
