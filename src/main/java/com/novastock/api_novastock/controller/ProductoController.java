package com.novastock.api_novastock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{idProveedor}")
    public Producto getAll(@PathVariable Long idProveedor) {
        return service.getByID(idProveedor)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @GetMapping("/{idProveedor}/conteo-productos")
    public Long conteoProductos(@PathVariable Long idProveedor) {
        return service.countByProveedor_IdProveedor(idProveedor);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return service.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return service.updateProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        service.deleteProducto(id);
    }

    @GetMapping("/buscar")
    public List<Producto> buscarPorNombreYStock(String nombre, int stock) {
        return service.buscarPorNombreYStock(nombre, stock);
    }
}