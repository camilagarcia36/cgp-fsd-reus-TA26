package com.ejercicio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.dto.Pieza;

public interface IPiezaDAO extends JpaRepository<Pieza, Integer> {

}