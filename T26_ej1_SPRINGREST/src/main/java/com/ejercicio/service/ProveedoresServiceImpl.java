package com.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.dao.IProveedoresDAO;
import com.ejercicio.dto.Proveedores;

@Service
public class ProveedoresServiceImpl implements IProveedoresService{

	@Autowired
	IProveedoresDAO iProveedoresDAO;
	
	@Override
	public List<Proveedores> listarProveedores() {
		return iProveedoresDAO.findAll();
	}

	@Override
	public Proveedores guardarProveedores(Proveedores proveedor) {
		return iProveedoresDAO.save(proveedor);
	}

	@Override
	public Proveedores proveedoresXID(Long id) {
		return iProveedoresDAO.findById(id).get();
	}

	@Override
	public Proveedores actualizarProveedores(Proveedores proveedor) {
		return iProveedoresDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedores(Long id) {
		iProveedoresDAO.deleteById(id);
	}

}
