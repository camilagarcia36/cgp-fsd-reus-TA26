package com.ejercicio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Piezas;
import com.ejercicio.dto.Proveedores;
import com.ejercicio.dto.Suministra;

public interface ISuministraDAO extends JpaRepository<Suministra, Integer> {
	
	public List<Suministra> findByPieza(Piezas pieza);
	public List<Suministra> findByProveedor(Proveedores proveedor);

}