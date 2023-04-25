package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Proveedores;

public interface IProveedoresDAO extends JpaRepository<Proveedores, Long> {

}