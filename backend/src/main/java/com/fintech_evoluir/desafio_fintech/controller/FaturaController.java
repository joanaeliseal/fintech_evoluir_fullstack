package com.fintech_evoluir.desafio_fintech.controller;

import com.fintech_evoluir.desafio_fintech.model.Fatura;
import com.fintech_evoluir.desafio_fintech.service.FaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    // GET /faturas/{id} → lista todas as faturas de um cliente
    @GetMapping("/{id}")
    public List<Fatura> listarFaturasDoCliente(@PathVariable Long id) {
        return faturaService.listarPorCliente(id);
    }

    // PUT /faturas/{id}/pagamento → registra pagamento
    @PutMapping("/{id}/pagamento")
    public Fatura registrarPagamento(@PathVariable Long id) {
        return faturaService.registrarPagamento(id);
    }

    // GET /faturas/atrasadas → lista faturas com vencimento há mais de 3 dias
    @GetMapping("/atrasadas")
    public List<Fatura> listarFaturasAtrasadas() {
        return faturaService.listarAtrasadas();
    }

    // Endpoint opcional para forçar a verificação de atraso e bloqueio (ex: teste manual)
    @PostMapping("/verificar-bloqueios")
    public void verificarAtrasosEAtualizarStatus() {
        faturaService.verificarAtrasosEFazerBloqueios();
    }
}
