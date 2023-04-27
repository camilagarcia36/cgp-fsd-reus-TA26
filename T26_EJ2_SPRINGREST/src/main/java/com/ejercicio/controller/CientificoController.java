package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Cientifico;
import com.ejercicio.service.CientificosServiceImpl;



@RestController
@RequestMapping("/api")
public class CientificoController {
	
	@Autowired
	CientificosServiceImpl cientificoServiceImpl;
	
	@GetMapping("/Cientifico")
	public List<Cientifico> listarCientifico(){
		return cientificoServiceImpl.listarCientifico();
	}
	
	@PostMapping("/Cientifico")
	public Cientifico guardarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}
	
	@GetMapping("/Cientifico/{idcientificos}")
	public Cientifico cientificoById(@PathVariable(name="idcientificos") int idcientificos) {
		Cientifico cientifico= new Cientifico();
		cientifico=cientificoServiceImpl.cientificoById(idcientificos);
		return cientifico;
	}
	
	@PutMapping("/Cientifico/{idcientificos}")
	public Cientifico actualizarCientifico(@PathVariable(name="idcientificos")int idcientificos,@RequestBody Cientifico cientifico) {
		
		Cientifico cientifico_seleccionado= new Cientifico();
		Cientifico cientifico_actualizado= new Cientifico();
		cientifico_seleccionado= cientificoServiceImpl.cientificoById(idcientificos);
		cientifico_seleccionado.setDni(cientifico.getDni());
		cientifico_seleccionado.setNombreApellido(cientifico.getNombreApellido()); 
		cientifico_seleccionado.setAsignado(cientifico.getAsignado());
		
		
		cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(cientifico_seleccionado);
		
		return cientifico_actualizado;
	}
	
	@DeleteMapping("/Cientifico/{idcientificos}")
	public void eliminarCientifico(@PathVariable(name="idcientificos")int idcientificos) {
		cientificoServiceImpl.eliminarCientifico(idcientificos);
	}

}
