package com.fintech_evoluir.desafio_fintech.controller;

import com.fintech_evoluir.desafio_fintech.model.Cliente;
import com.fintech_evoluir.desafio_fintech.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // GET /clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // GET /clientes/{id}
    @GetMapping("/{id}")
    public Optional<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }

    // POST /clientes
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // PUT /clientes/{id}
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
                    cliente.setStatusBloqueio(clienteAtualizado.getStatusBloqueio());
                    cliente.setLimiteCredito(clienteAtualizado.getLimiteCredito());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // GET /clientes/bloqueados
    @GetMapping("/bloqueados")
    public List<Cliente> listarClientesBloqueados() {
        return clienteRepository.findByStatusBloqueio("B");
    }
}
