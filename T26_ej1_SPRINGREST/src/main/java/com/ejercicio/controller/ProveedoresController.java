package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.dto.Proveedores;
import com.ejercicio.service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedoresController {

	@Autowired
	ProveedoresServiceImpl proveedoresServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores() {
		return proveedoresServiceImpl.listarProveedores();
	}

	@PostMapping("/proveedores")
	public Proveedores salvarProveedores(@RequestBody Proveedores proveedor) {
		return proveedoresServiceImpl.guardarProveedores(proveedor);
	}

	@GetMapping("/proveedores/{id}")
	public Proveedores proveedoresXID(@PathVariable(name = "id") Long id) {
		Proveedores proveedores_xid = new Proveedores();
		proveedores_xid = proveedoresServiceImpl.proveedoresXID(id);
		System.out.println("Proveedores XID: " + proveedores_xid);
		return proveedores_xid;
	}

	@PutMapping("/proveedores/{id}")
	public Proveedores actualizarProveedores(@PathVariable(name = "id") Long id, @RequestBody Proveedores proveedor) {
		Proveedores proveedores_seleccionado = new Proveedores();
		Proveedores proveedores_actualizado = new Proveedores();
		proveedores_seleccionado = proveedoresServiceImpl.proveedoresXID(id);
		proveedores_seleccionado.setId(proveedor.getId());
		proveedores_seleccionado.setNombre(proveedor.getNombre());
		proveedores_actualizado = proveedoresServiceImpl.actualizarProveedores(proveedores_seleccionado);
		System.out.println("El proveedor actualizado es: " + proveedores_actualizado);
		return proveedores_actualizado;
	}

	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedores(@PathVariable(name = "id") Long id) {
		proveedoresServiceImpl.eliminarProveedores(id);
	}
}