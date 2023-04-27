package com.ejercicio.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Proveedor;
import com.ejercicio.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;

	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedor() {
		return proveedorServiceImpl.listarProveedor();
	}

	@PostMapping("/proveedores")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}

	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorById(@PathVariable(name = "id") int id) {
		Proveedor proveedor = new Proveedor();
		proveedor = proveedorServiceImpl.proveedorById(id);
		return proveedor;
	}

	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name = "id") int id, @RequestBody Proveedor proveedor) {

		Proveedor proveedor_seleccionado = new Proveedor();
		Proveedor proveedor_actualizado = new Proveedor();
		proveedor_seleccionado = proveedorServiceImpl.proveedorById(id);

		proveedor_seleccionado.setNombre(proveedor.getNombre());
		proveedor_seleccionado.setSuministra(proveedor.getSuministra());

		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);
		return proveedor_actualizado;
	}

	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name = "id") int id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}

}