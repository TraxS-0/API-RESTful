package com.novastock.api_novastock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.novastock.api_novastock.model.Proveedor;
import com.novastock.api_novastock.repository.ProveedorRepository;

@Service
public class ProveedorService {

    private final ProveedorRepository repository;

    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }

    public List<Proveedor> getAllProveedor() {
        return repository.findAll();
    }

    public Optional<Proveedor> getByID(Long id) {
        return repository.findById(id);
    }

    public Proveedor createProveedor(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    public Proveedor updateProveedor(Long id, Proveedor proveedor) {
        proveedor.setIdProveedor(id);
        return repository.save(proveedor);
    }

    public void deleteProveedor(Long id) {
        repository.deleteById(id);
    }

    /*public List<Producto> buscarPorNombreYStock(String nombre, int stock) {
        return repository.findByNombreAndStock(nombre, stock);
    }*/
}