package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Pieza;

public interface IPiezaService {

	// Metodos del CRUD
	public List<Pieza> listarPieza(); // Listar All

	public Pieza guardarPieza(Pieza pieza); // Guarda un departamento CREATE

	public Pieza piezaById(int codigo); // Leer datos de un departamento READ

	public Pieza actualizarPieza(Pieza pieza); // Actualiza datos del departamento UPDATE

	public void eliminarPieza(int codigo);// Elimina el departamento DELETE
}
