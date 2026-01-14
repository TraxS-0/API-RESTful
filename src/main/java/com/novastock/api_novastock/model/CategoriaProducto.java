package com.novastock.api_novastock.model;

import java.util.List;

public class CategoriaProducto {
    String nombre;
    List<Producto> productos;

    public CategoriaProducto(String nombre) {
        this.nombre = nombre;
    }

    public void add(Producto producto) {
        productos.add(producto);
    }
}
