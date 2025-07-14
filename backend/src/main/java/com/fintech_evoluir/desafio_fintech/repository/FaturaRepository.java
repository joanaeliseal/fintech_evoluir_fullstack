package com.fintech_evoluir.desafio_fintech.repository;

import com.fintech_evoluir.desafio_fintech.model.Fatura;
import com.fintech_evoluir.desafio_fintech.model.StatusFatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {

    List<Fatura> findByClienteId(Long clienteId);

    List<Fatura> findByStatus(StatusFatura status);

    List<Fatura> findByStatusAndDataVencimentoBefore(StatusFatura status, LocalDate dataLimite);
}
