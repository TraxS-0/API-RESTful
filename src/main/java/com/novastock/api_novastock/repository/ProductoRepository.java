package com.novastock.api_novastock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novastock.api_novastock.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    public List<Producto> findByNombreAndStock(String nombre, int stock);
    long countByProveedor_IdProveedor(Long idProveedor);
}