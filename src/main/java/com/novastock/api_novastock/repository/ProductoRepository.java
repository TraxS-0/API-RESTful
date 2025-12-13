package com.novastock.api_novastock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novastock.api_novastock.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
