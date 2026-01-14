package com.novastock.api_novastock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.novastock.api_novastock.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}