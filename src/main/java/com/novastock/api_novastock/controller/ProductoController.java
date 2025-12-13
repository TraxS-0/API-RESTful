package com.novastock.api_novastock.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.novastock.api_novastock.model.Producto;
import com.novastock.api_novastock.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Producto> getAll() {
        return repo.findAll();
    }
}