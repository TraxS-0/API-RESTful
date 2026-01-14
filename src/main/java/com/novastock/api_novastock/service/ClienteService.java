package com.novastock.api_novastock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.novastock.api_novastock.model.Cliente;
import com.novastock.api_novastock.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }

    public Optional<Cliente> getByID(Long id) {
        return repository.findById(id);
    }

    public Cliente createCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }

    /*public List<Producto> buscarPorNombreYStock(String nombre, int stock) {
        return repository.findByNombreAndStock(nombre, stock);
    }*/
}