package com.penitenciaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.penitenciaria.models.Ocupacoes;
import com.penitenciaria.repository.OcupacoesRepository;

@Controller
public class OcupacoesController {
	
	@Autowired
	private OcupacoesRepository or;
	
	//Adicionar - Get
	@RequestMapping(value="/ocupacoes/add", method=RequestMethod.GET)
	public String form() {
		return "Ocupacoes/addOcupacoes";
	}
	
	//Adicionar - Post
	@RequestMapping(value="/ocupacoes/add", method=RequestMethod.POST)
	public String form(Ocupacoes ocupacao) {
		
		or.save(ocupacao);
		
		return "redirect:/ocupacoes";
	}
	
	//Index - Listagem de Registros
	@RequestMapping(value="/ocupacoes", method=RequestMethod.GET)
	public ModelAndView listaOcupacoes() {
		ModelAndView mv = new ModelAndView("Ocupacoes/indexOcupacoes");
		
		Iterable<Ocupacoes> ocupacoes = or.findAllByOrderByCodigoDesc();
		
		mv.addObject("ocupacoes", ocupacoes);
		
		return mv;
	}
	
	//Editar - Get
	@RequestMapping(value="/ocupacoes/edit/{codigo}", method=RequestMethod.GET)
	public ModelAndView editarOcupacoes(@PathVariable("codigo") long codigo) {
		Ocupacoes ocupacao = or.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("Ocupacoes/editOcupacoes");
		mv.addObject("ocupacao", ocupacao);
		return mv;
	}
	
	//Editar - Post
	@RequestMapping(value="/ocupacoes/edit/{codigo}", method=RequestMethod.POST)
	public String editarOcupacoesP(Ocupacoes ocupacao, @PathVariable("codigo") long codigo) {
		ocupacao.setCodigo(codigo);
		or.save(ocupacao);
		return "redirect:/ocupacoes";
	}
	
	//Excluir (Deletar)
	@RequestMapping(value="/ocupacoes/delete/{codigo}", method=RequestMethod.GET)
	public String deletarOcupacoes(@PathVariable("codigo") long codigo) {
		Ocupacoes ocupacao = or.findByCodigo(codigo);
		
		or.delete(ocupacao);
		
		return "redirect:/ocupacoes";
	}
}
