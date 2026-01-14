package com.novastock.api_novastock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novastock.api_novastock.controller.CategoriaProducto;

public interface CategoriaRepository extends JpaRepository<CategoriaProducto, Long> {
    public boolean existsByNombre(String nombre);
}