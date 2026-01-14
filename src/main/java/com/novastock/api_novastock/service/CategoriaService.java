package com.novastock.api_novastock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.novastock.api_novastock.model.CategoriaProducto;
import com.novastock.api_novastock.model.GestorProductos;
import com.novastock.api_novastock.model.Producto;
import com.novastock.api_novastock.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<CategoriaProducto> getAllCategorias() {
        return repository.findAll();
    }

    public Optional<CategoriaProducto> getByID(Long id) {
        return repository.findById(id);
    }

    public Producto updateProducto(Long id, Producto producto) {
        producto.setId(id);
        return repository.save(producto);
    }

    public void deleteCategoria(Long id) {
        repository.deleteById(id);
    }

    public Producto saveProducto(Producto nuevoProducto) {        
        if (repository.existsByNombre(nuevoProducto.getNombre())) {
            throw new RuntimeException("Ya existe un producto con el nombre: " + nuevoProducto.getNombre());
        }
        if (!GestorProductos.categoriaExist(nuevoProducto.getCategoria())) {
            CategoriaProducto nuevaCategoria = new CategoriaProducto(nuevoProducto.getCategoria());
            GestorProductos.guardarCategoria(nuevaCategoria);
        } else {
            GestorProductos.guardarEnCategoria(nuevoProducto.getCategoria(), nuevoProducto);
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
}
