package com.erickaraujoreis.sistemarotas.repository;

import com.erickaraujoreis.sistemarotas.model.Trajeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetoRepository extends JpaRepository<Trajeto, Long> {
}
