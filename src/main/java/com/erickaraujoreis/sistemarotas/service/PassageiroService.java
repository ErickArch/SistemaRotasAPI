package com.erickaraujoreis.sistemarotas.service;

import com.erickaraujoreis.sistemarotas.model.Passageiro;
import com.erickaraujoreis.sistemarotas.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {
	@Autowired
	PassageiroRepository passageiroRepository;

	public Optional<Passageiro> findById(Long id){
		return passageiroRepository.findById(id);
	}

	public List<Passageiro> findAll(){
		return passageiroRepository.findAll();
	}

	public void delete(Long id){
		passageiroRepository.deleteById(id);
	}

	public Passageiro save(Passageiro passageiro){
		return passageiroRepository.save(passageiro);
	}
}
