package com.novastock.api_novastock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int stock;
    private double precio;
    private String categoria;

    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public Producto() {

    }



}