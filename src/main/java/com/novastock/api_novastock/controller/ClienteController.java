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

import com.novastock.api_novastock.model.Cliente;
import com.novastock.api_novastock.service.ClienteService;

@RestController
@RequestMapping("/api/Clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> getAll() {
        return service.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getAll(@PathVariable Long id) {
        return service.getByID(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return service.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        service.deleteCliente(id);
    }

    /*@GetMapping("/buscar")
    public List<Cliente> buscarPorNombreYStock(String nombre, int stock) {
        return service.buscarPorNombreYStock(nombre, stock);
    }*/
}