package com.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.ISuministraDAO;
import com.ejercicio.dto.Piezas;
import com.ejercicio.dto.Proveedores;
import com.ejercicio.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService {

	@Autowired
	ISuministraDAO iSuministraDAO;
	
	@Override
	public List<Suministra> listarSuministra() {
		return iSuministraDAO.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {
		return iSuministraDAO.save(suministra);
	}

	@Override
	public Suministra suministraXID(int id) {
		return iSuministraDAO.findById(id).get();
	}

	@Override
	public List<Suministra> listarSuministraPiezas(Piezas pieza) {
		return iSuministraDAO.findByPieza(pieza);
	}

	@Override
	public List<Suministra> listarSuministraProveedores(Proveedores proveedor) {
		return iSuministraDAO.findByProveedor(proveedor);
	}

	@Override
	public Suministra actualizarSuministra(Suministra suministra) {
		return iSuministraDAO.save(suministra);
	}

	@Override
	public void eliminarSuministra(int id) {
		iSuministraDAO.deleteById(id);
	}
}
