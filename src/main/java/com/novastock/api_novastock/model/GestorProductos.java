package com.novastock.api_novastock.model;

import java.util.List;

public class GestorProductos {
    static List<CategoriaProducto> categorias;

    public static boolean categoriaExist(String categoriaNombre) {
        for (CategoriaProducto thisCategoria : categorias) {
            if (categoriaNombre.equals(thisCategoria.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public static void guardarEnCategoria(String categoriaNombre, Producto productoAGuardar) {
        for (CategoriaProducto thisCategoria : categorias) {
            if (categoriaNombre.equals(thisCategoria.getNombre())) {
                thisCategoria.guardarProducto(productoAGuardar);
            }
        }
    }

    public static void guardarCategoria(CategoriaProducto categoria) {
        categorias.add(categoria);
    }
}
