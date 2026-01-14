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

import com.novastock.api_novastock.model.Proveedor;
import com.novastock.api_novastock.service.ProveedorService;

@RestController
@RequestMapping("/api/Proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Proveedor> getAll() {
        return service.getAllProveedor();
    }

    @GetMapping("/{id}")
    public Proveedor getAll(@PathVariable Long id) {
        return service.getByID(id)
            .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return service.createProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        return service.updateProveedor(id, proveedor);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable Long id) {
        service.deleteProveedor(id);
    }

    /*@GetMapping("/buscar")
    public List<Cliente> buscarPorNombreYStock(String nombre, int stock) {
        return service.buscarPorNombreYStock(nombre, stock);
    }*/
}