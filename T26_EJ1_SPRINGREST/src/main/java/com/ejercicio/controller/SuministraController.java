package com.ejercicio.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Suministra;
import com.ejercicio.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;;

	@GetMapping("/suministra")
	public List<Suministra> listarSuministra() {
		return suministraServiceImpl.listarSuministra();
	}

	@PostMapping("/suministra")
	public Suministra guardarSuministra(@RequestBody Suministra suministra) {
		return suministraServiceImpl.guardarSuministra(suministra);
	}

	@GetMapping("/suministra/{id}")
	public Suministra suministraById(@PathVariable(name = "id") int id) {
		Suministra suministra = new Suministra();
		suministra = suministraServiceImpl.suministraById(id);
		return suministra;
	}

	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name = "id") int id, @RequestBody Suministra suministra) {

		Suministra suministra_seleccionado = new Suministra();
		Suministra suministra_actualizado = new Suministra();
		suministra_seleccionado = suministraServiceImpl.suministraById(id);
		suministra_seleccionado.setPrecio(suministra.getPrecio());
		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setProveedor(suministra.getProveedor());

		suministra_actualizado = suministraServiceImpl.actualizarSuministra(suministra_seleccionado);
		return suministra_actualizado;
	}

	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name = "id") int id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
}