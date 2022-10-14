package com.erickaraujoreis.sistemarotas.repository;

import com.erickaraujoreis.sistemarotas.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
