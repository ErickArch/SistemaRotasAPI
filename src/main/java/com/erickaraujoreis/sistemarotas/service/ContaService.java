package com.erickaraujoreis.sistemarotas.service;

import com.erickaraujoreis.sistemarotas.model.Conta;
import com.erickaraujoreis.sistemarotas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
	@Autowired
	ContaRepository contaRepository;

	public Optional<Conta> findById(Long id){
		return contaRepository.findById(id);
	}

	public List<Conta> findAll(){
		return contaRepository.findAll();
	}

	public void delete(Long id){
		contaRepository.deleteById(id);
	}

	public Conta save(Conta conta){
		return contaRepository.save(conta);
	}
}
