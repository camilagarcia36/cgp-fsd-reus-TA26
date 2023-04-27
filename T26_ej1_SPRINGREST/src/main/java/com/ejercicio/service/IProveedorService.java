package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Proveedor;

public interface IProveedorService {
	
	public List<Proveedor> listarProveedor(); // Listar All

	public Proveedor guardarProveedor(Proveedor proveedor); // Guarda un proveedor CREATE

	public Proveedor proveedorById(int id); // Leer datos de un proveedor READ

	public Proveedor actualizarProveedor(Proveedor proveedor); // Actualiza datos del proveedor UPDATE

	public void eliminarProveedor(int id);// Elimina el proveedor DELETE
}