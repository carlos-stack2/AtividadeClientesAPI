package com.example.cliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente.model.Cliente;
import com.example.cliente.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    // Exercicio 7 
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    // Exercicio 8 
    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    // Exercicio 9 
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Exercicio 10 
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return "Cliente removido com sucesso!";
    }

    // Exercicio 11 
    @GetMapping("/buscarPorNome")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
        return repository.findByNome(nome);
    }

    // Buscar por email
    @GetMapping("/buscarPorEmail")
    public Optional<Cliente> buscarPorEmail(@RequestParam String email) {
        return repository.findByEmail(email);
    }
}
