package com.novastock.api_novastock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novastock.api_novastock.model.Producto;
import com.novastock.api_novastock.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    private ProductoService service;

    @GetMapping
    public List<Producto> getAll() {
        return service.getAllProductos();
    }
}
