package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.service.RegionesPaisesService;

@Controller
public class PaisesRegionesController {
	
	@Autowired
	private RegionesPaisesService service;
		
	@GetMapping("/regiones")
	public String listaRegiones(Model model) {
		model.addAttribute("regiones", service.getAllRegiones());
		return "regiones";
	}
	
	@GetMapping("/paises/{idRegion}")
	public String getProductosPorCategoria(Model model,
			@PathVariable("idRegion") long idRegion) {
      
		model.addAttribute("region", service.getRegion(idRegion));
		model.addAttribute("paises", 
				 service.getAllPaisesPorRegion(idRegion));
		return "paises-region";
	}

	
	
}
