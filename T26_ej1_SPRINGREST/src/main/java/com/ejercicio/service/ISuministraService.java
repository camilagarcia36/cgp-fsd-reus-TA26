package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Piezas;
import com.ejercicio.dto.Proveedores;
import com.ejercicio.dto.Suministra;

public interface ISuministraService {

	public List<Suministra> listarSuministra();

	public Suministra guardarSuministra(Suministra suministra);

	public Suministra suministraXID(int id);

	public List<Suministra> listarSuministraPiezas(Piezas pieza);

	public List<Suministra> listarSuministraProveedores(Proveedores proveedor);

	public Suministra actualizarSuministra(Suministra suministra);

	public void eliminarSuministra(int id);
}
