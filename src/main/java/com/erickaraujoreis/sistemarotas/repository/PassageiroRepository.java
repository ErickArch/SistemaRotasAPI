package com.erickaraujoreis.sistemarotas.repository;

import com.erickaraujoreis.sistemarotas.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
}
