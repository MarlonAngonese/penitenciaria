package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.penitenciaria.models.Condenados;
import com.penitenciaria.repository.CondenadosRepository;

@Controller
public class CondenadosController {
	
	@Autowired
	private CondenadosRepository or;
	
	//Adicionar - Get
	@RequestMapping(value="/condenados/add", method=RequestMethod.GET)
	public String form() {
		return "Condenados/addCondenados";
	}
	
	//Adicionar - Post
	@RequestMapping(value="/condenados/add", method=RequestMethod.POST)
	public String form(Condenados condenado) {
		
		or.save(condenado);
		
		return "redirect:/condenados";
	}
	
	//Index - Listagem de Registros
	@RequestMapping(value="/condenados", method=RequestMethod.GET)
	public ModelAndView listaCondenados() {
		ModelAndView mv = new ModelAndView("Condenados/indexCondenados");
		
		Iterable<Condenados> condenados = or.findAllByOrderByCodigoDesc();
		
		mv.addObject("condenados", condenados);
		
		return mv;
	}
	
	//Editar - Get
	@RequestMapping(value="/condenados/edit/{codigo}", method=RequestMethod.GET)
	public ModelAndView editarCondenados(@PathVariable("codigo") long codigo) {
		Condenados condenado = or.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("Condenados/editCondenados");
		mv.addObject("condenado", condenado);
		return mv;
	}
	
	//Editar - Post
	@RequestMapping(value="/condenados/edit/{codigo}", method=RequestMethod.POST)
	public String editarCondenadosP(Condenados condenado, @PathVariable("codigo") long codigo) {
		condenado.setCodigo(codigo);
		or.save(condenado);
		return "redirect:/condenados";
	}
	
	//Excluir (Deletar)
	@RequestMapping(value="/condenados/delete/{codigo}", method=RequestMethod.GET)
	public String deletarCondenados(@PathVariable("codigo") long codigo) {
		Condenados condenado = or.findByCodigo(codigo);
		
		or.delete(condenado);
		
		return "redirect:/condenados";
	}
}
