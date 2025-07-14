package com.fintech_evoluir.desafio_fintech.repository;

import com.fintech_evoluir.desafio_fintech.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByStatusBloqueio(String status);
}
