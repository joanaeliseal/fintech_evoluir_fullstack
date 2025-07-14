package com.fintech_evoluir.desafio_fintech.service;

import com.fintech_evoluir.desafio_fintech.model.*;
import com.fintech_evoluir.desafio_fintech.repository.ClienteRepository;
import com.fintech_evoluir.desafio_fintech.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class FaturaService {

    private final FaturaRepository faturaRepository;
    private final ClienteRepository clienteRepository;

    public FaturaService(FaturaRepository faturaRepository, ClienteRepository clienteRepository) {
        this.faturaRepository = faturaRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Fatura> listarPorCliente(Long clienteId) {
        return faturaRepository.findByClienteId(clienteId);
    }

    public List<Fatura> listarAtrasadas() {
        LocalDate limite = LocalDate.now().minusDays(3);
        return faturaRepository.findByStatusAndDataVencimentoBefore(StatusFatura.B, limite);
    }

    public Fatura registrarPagamento(Long id) {
        Fatura fatura = faturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fatura não encontrada"));

        fatura.setStatus(StatusFatura.P);
        fatura.setDataPagamento(LocalDate.now());
        faturaRepository.save(fatura);

        return fatura;
    }

    public void verificarAtrasosEFazerBloqueios() {
        List<Fatura> atrasadas = listarAtrasadas();

        for (Fatura fatura : atrasadas) {
            fatura.setStatus(StatusFatura.A);
            faturaRepository.save(fatura);

            Cliente cliente = fatura.getCliente();
            cliente.setStatusBloqueio(StatusBloqueio.B);
            cliente.setLimiteCredito(BigDecimal.ZERO);
            clienteRepository.save(cliente);
        }
    }
}