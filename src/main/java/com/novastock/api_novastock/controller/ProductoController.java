package com.novastock.api_novastock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novastock.api_novastock.model.Producto;
import com.novastock.api_novastock.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> getAll() {
        return service.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getAll(@PathVariable Long id) {
        return service.getByID(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @PostMapping
    public void createProducto(@RequestBody Producto producto) {
        service.createProducto(producto);
    }
}