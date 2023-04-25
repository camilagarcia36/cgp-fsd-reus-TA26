package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Proveedores;

public interface IProveedoresService {
	
	public List<Proveedores> listarProveedores();

	public Proveedores guardarProveedores(Proveedores proveedor);

	public Proveedores proveedoresXID(Long id);

	public Proveedores actualizarProveedores(Proveedores proveedor);

	public void eliminarProveedores(Long id);
}