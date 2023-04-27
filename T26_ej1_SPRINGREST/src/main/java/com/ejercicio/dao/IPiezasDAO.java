package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Piezas;

public interface IPiezasDAO extends JpaRepository<Piezas, Long> {

}