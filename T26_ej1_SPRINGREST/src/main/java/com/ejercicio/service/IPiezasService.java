package com.ejercicio.service;

import java.util.List;

import com.ejercicio.dto.Piezas;

public interface IPiezasService {

		
		public List<Piezas> listarPiezas();

		public Piezas guardarPiezas(Piezas pieza);

		public Piezas piezasXID(Long id);

		public Piezas actualizarPiezas(Piezas pieza);

		public void eliminarPiezas(Long id);
}
