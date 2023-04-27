package com.ejercicio.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Asignado;
import com.ejercicio.service.AsignadoServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoController {

	@Autowired
	AsignadoServiceImpl asignadoServiceImpl;;

	@GetMapping("/asignado")
	public List<Asignado> listarAsignado() {
		return asignadoServiceImpl.listarAsignado();
	}

	@PostMapping("/asignado")
	public Asignado guardarAsignado(@RequestBody Asignado asignado) {
		return asignadoServiceImpl.guardarAsignado(asignado);
	}

	@GetMapping("/asignado/{id}")
	public Asignado asignadoById(@PathVariable(name = "id") int id) {
		Asignado asignado = new Asignado();
		asignado = asignadoServiceImpl.asignadoById(id);
		return asignado;
	}

	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name = "id") int id, @RequestBody Asignado asignado) {

		Asignado asignado_seleccionado = new Asignado();
		Asignado asignado_actualizado = new Asignado();
		asignado_seleccionado = asignadoServiceImpl.asignadoById(id);
	
		asignado_seleccionado.setCientifico(asignado.getCientifico());
		asignado_seleccionado.setProyecto(asignado.getProyecto());

		asignado_actualizado = asignadoServiceImpl.actualizarAsignado(asignado_seleccionado);
		return asignado_actualizado;
	}

	@DeleteMapping("/asignado/{id}")
	public void eliminarAsignado(@PathVariable(name = "id") int id) {
		asignadoServiceImpl.eliminarAsignado(id);
	}
}