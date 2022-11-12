package com.erickaraujoreis.sistemarotas.service;

import com.erickaraujoreis.sistemarotas.model.Trajeto;
import com.erickaraujoreis.sistemarotas.repository.TrajetoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrajetoService {
	@Autowired
	TrajetoRepository trajetoRepository;

	public Optional<Trajeto> findById(Long id){
		return trajetoRepository.findById(id);
	}

	public List<Trajeto> findAll(){
		return trajetoRepository.findAll();
	}

	public void delete(Long id){
		trajetoRepository.deleteById(id);
	}

	public Trajeto save(Trajeto trajeto){
		return trajetoRepository.save(trajeto);
	}
}
