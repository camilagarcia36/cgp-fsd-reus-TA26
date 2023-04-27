package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Cajero;
import com.ejercicio.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;

	@GetMapping("/Cajeros")
	public List<Cajero> listarCajero() {
		return cajeroServiceImpl.listarCajero();
	}

	@PostMapping("/Cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}

	@GetMapping("/Cajeros/{id}")
	public Cajero cajeroById(@PathVariable(name = "id") int id) {
		Cajero cajero = new Cajero();
		cajero = cajeroServiceImpl.cajeroById(id);
		return cajero;
	}

	@PutMapping("/Cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name = "id") int id, @RequestBody Cajero cajero) {

		Cajero cajero_seleccionado = new Cajero();
		Cajero cajero_actualizado = new Cajero();
		cajero_seleccionado = cajeroServiceImpl.cajeroById(id);
		cajero_seleccionado.setNombre(cajero.getNombre());
		cajero_seleccionado.setVenta(cajero.getVenta());

		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		return cajero_actualizado;
	}

	@DeleteMapping("/Cajeros/{id}")
	public void eliminarCajero(@PathVariable(name = "id") int id) {
		cajeroServiceImpl.eliminarCajero(id);
	}

}