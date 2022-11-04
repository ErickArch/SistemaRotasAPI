package com.erickaraujoreis.sistemarotas;

import com.erickaraujoreis.sistemarotas.model.Conta;
import com.erickaraujoreis.sistemarotas.model.Passageiro;
import com.erickaraujoreis.sistemarotas.model.Trajeto;
import com.erickaraujoreis.sistemarotas.repository.ContaRepository;
import com.erickaraujoreis.sistemarotas.repository.PassageiroRepository;
import com.erickaraujoreis.sistemarotas.repository.TrajetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SistemaRotasApplication implements ApplicationRunner {

	@Autowired
	PassageiroRepository passageiroRepository;

	@Autowired
	TrajetoRepository trajetoRepository;

	@Autowired
	ContaRepository contaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaRotasApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception{
		// Instanciando os passageiros
		Passageiro passageiro1 = new Passageiro("João Souza", -19.851616300183196, -43.955840012372015);
		Passageiro passageiro2 = new Passageiro("Aline Almeida", -22.820454154695202, -43.086546873376);
		passageiro1 = passageiroRepository.save(passageiro1);
		passageiro2 = passageiroRepository.save(passageiro2);

		// Instanciando o trajeto
		List<Passageiro> passageiros = new ArrayList<>();
		passageiros.add(passageiro1);
		passageiros.add(passageiro2);

		Trajeto trajeto1 = new Trajeto(-22.73941911532092, -47.096556298128576, -15.584640226722062, -47.75573592959476, passageiros);
		trajeto1 = trajetoRepository.save(trajeto1);

		// Instanciando a conta
		List<Trajeto> trajetosConta = new ArrayList<>();
		List<Passageiro> passageirosConta = new ArrayList<>();
		trajetosConta.add(trajeto1);
		passageirosConta.add(passageiro1);
		passageirosConta.add(passageiro2);

		Conta conta1 = new Conta("Felipe Santos", "felipesantos@email.com", "12912345678", trajetosConta, passageirosConta);
	}

}
