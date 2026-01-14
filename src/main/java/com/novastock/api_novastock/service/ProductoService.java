package com.novastock.api_novastock.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.novastock.api_novastock.model.Producto;
import com.novastock.api_novastock.repository.ProductoRepository;

import jakarta.transaction.Transactional;

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

    public Producto updateProducto(Long id, Producto producto) {
        producto.setId(id);
        return repository.save(producto);
    }

    public void deleteProducto(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> buscarPorNombreYCategoria(String nombre, String categoria) {
        return repository.findByNombreAndCategoria(nombre, categoria);
    }

    public Producto saveProducto(Producto nuevoProducto) {        
        if (repository.existsByNombre(nuevoProducto.getNombre())) {
            throw new RuntimeException("Ya existe un producto con el nombre: " + nuevoProducto.getNombre());
        }

        return repository.save(nuevoProducto);
    }

    @Transactional
    public void saveAll(List<Producto> productos) {
        for (Producto producto : productos) {
            if (repository.existsByNombre(producto.getNombre())) {
                throw new RuntimeException("El producto con nombre: " + producto.getNombre() + " ya existe");
            }

            if ("ERROR".equals(producto.getNombre())) {
                throw new RuntimeException("Atributo prohibido, lanzando excepción");
            }

            repository.save(producto);
        }
    }

    public List<Producto> buscarPorStockMinMax(int min, int max) {
        return repository.findByStockBetween(min, max);
    }

    @Transactional
    public Producto patchUpdate(Long id, Map<String, Object> updates) throws RuntimeException {
        List<Producto> productos = getAllProductos();

        for (Producto producto : productos) {
            if (producto.getId().equals(producto.getId())) {
                if (updates.containsKey("nombre")) {
                    producto.setNombre((String) updates.get("nombre"));
                }
                if (updates.containsKey("stock")) {
                    producto.setStock((int) updates.get("stock"));
                }
                if (updates.containsKey("precio")) {
                    producto.setPrecio((double) updates.get("precio"));
                }
                if (updates.containsKey("categoria")) {
                    producto.setCategoria((String) updates.get("categoria"));
                }
                repository.save(producto);
                return producto;
            }
        }
        throw new RuntimeException("Producto no encontrado con el id: " + id);
    }
}
