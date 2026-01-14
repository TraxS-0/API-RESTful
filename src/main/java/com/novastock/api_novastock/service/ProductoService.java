package com.novastock.api_novastock.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Producto> getByID(Long id) {
        return repository.findById(id);
    }

    public Producto createProducto(String nombre, String categoria) {
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setCategoria(categoria);
        return repository.save(nuevoProducto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        producto.setId(id);
        return repository.save(producto);
    }

    public void deleteProducto(Long id) {
        repository.deleteById(id);
    }
}
