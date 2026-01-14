package com.novastock.api_novastock.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Producto>> getAll() {
        try {
            List<Producto> productos = service.getAllProductos();
            if (productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(productos);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getAll(@PathVariable Long id) {
        try {
            Producto producto = service.getByID(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public Producto createProducto(@RequestBody Producto productoNuevo) {
        return service.saveProducto(productoNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoActualizar) {
        try {
            if (service.getByID(id).isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Producto producto = service.updateProducto(id, productoActualizar);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id) {
        try {
            if (service.getByID(id).isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            service.deleteProducto(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> findByNombreAndCategoria(@RequestParam String nombre, @RequestParam String categoria) {
        try {
            List<Producto> productos = service.buscarPorNombreYCategoria(nombre, categoria);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/lote")
    public ResponseEntity<?> crearLote(@RequestBody List<Producto> productos) {
        try {
            service.saveAll(productos);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar-por-stock")
    public ResponseEntity<List<Producto>> findByStockBetween(@RequestParam int min, @RequestParam int max) {
        try {
            List<Producto> productosEncontrados = service.buscarPorStockMinMax(min, max);
            return ResponseEntity.ok(productosEncontrados);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}