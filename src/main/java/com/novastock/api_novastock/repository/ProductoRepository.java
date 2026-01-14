package com.novastock.api_novastock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novastock.api_novastock.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public List<Producto> findByNombreAndCategoria(String nombre, String categoria);

    public boolean existsByNombre(String nombre);

    public List<Producto> findByStockBetween(int min, int max);
}