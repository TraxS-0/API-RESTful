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

    public Producto createProducto(Producto producto) {
        return repository.save(producto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        producto.setId(id);
        return repository.save(producto);
    }

    public void deleteProducto(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> buscarPorNombreYStock(String nombre, int stock) {
        return repository.findByNombreAndStock(nombre, stock);
    }

    public Long countByProveedor_IdProveedor(Long id_Proveedor) {
        return repository.countByProveedor_IdProveedor(id_Proveedor);
    }

}