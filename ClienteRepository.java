package com.example.cliente.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Exercicio 3
    Optional<Cliente> findByEmail(String email);

    // Exercicio 4
    List<Cliente> findByNome(String nome);

    // Exercicio 5
    List<Cliente> findByNomeStartingWith(String nome);
}
