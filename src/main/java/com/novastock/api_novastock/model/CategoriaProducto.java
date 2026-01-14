package com.novastock.api_novastock.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class CategoriaProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    List<Producto> productos;

    public CategoriaProducto(String nombre) {
        this.nombre = nombre;
    }

    public void guardarProducto(Producto producto) {
        productos.add(producto);
    }

    public String getNombre() {
        return nombre;
    }
}
