package com.ejercicio.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.dto.*;
import com.ejercicio.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;

	@GetMapping("/suministra")
	public List<Suministra> listarSuministra() {
		return suministraServiceImpl.listarSuministra();
	}

	@GetMapping("/suministra/piezas/{idPieza}")
	public List<Suministra> listarSuministraPiezas(@PathVariable(name = "idPieza") Long id) {
		Piezas pieza = new Piezas();
		pieza.setId(id);
		return suministraServiceImpl.listarSuministraPiezas(pieza);
	}

	@GetMapping("/suministra/proveedores/{idProveedor}")
	public List<Suministra> listarSuministraProveedores(@PathVariable(name = "idProveedor") Long id) {
		Proveedores proveedores = new Proveedores();
		proveedores.setId(id);
		return suministraServiceImpl.listarSuministraProveedores(proveedores);
	}

	@PostMapping("/suministra")
	public Suministra salvarSuministra(@RequestBody Suministra suministra) {
		return suministraServiceImpl.guardarSuministra(suministra);
	}

	@GetMapping("/suministra/{id}")
	public Suministra suministraXID(@PathVariable(name = "id") int id) {
		Suministra suministra_xid = new Suministra();
		suministra_xid = suministraServiceImpl.suministraXID(id);
		System.out.println("Suministra XID: " + suministra_xid);
		return suministra_xid;
	}

	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name = "id") int id, @RequestBody Suministra suministra) {
		Suministra suministra_seleccionado = new Suministra();
		Suministra suministra_actualizado = new Suministra();
		suministra_seleccionado = suministraServiceImpl.suministraXID(id);
		suministra_seleccionado.setId(suministra.getId());
		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setProveedor(suministra.getProveedor());
		suministra_seleccionado.setPrecio(suministra.getPrecio());
		suministra_actualizado = suministraServiceImpl.actualizarSuministra(suministra_seleccionado);
		System.out.println("El suministra actualizado es: " + suministra_actualizado);
		return suministra_actualizado;
	}

	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name = "id") int id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
}