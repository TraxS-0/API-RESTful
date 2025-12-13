package com.novastock.api_novastock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.novastock.api_novastock.model.Producto;
import com.novastock.api_novastock.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> getAllProductos() {
        return repository.findAll();
    }
}
