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
		Passageiro passageiro1 = new Passageiro("João Souza", "15°47'56.0\"S 47°51'38.0\"W");
		Passageiro passageiro2 = new Passageiro("Aline Almeida", "c");
		passageiro1 = passageiroRepository.save(passageiro1);
		passageiro2 = passageiroRepository.save(passageiro2);

		// Instanciando o trajeto
		List<String> paradas = new ArrayList<>();
		paradas.add("15°47'56.0\"S 47°51'38.0\"W");
		paradas.add("15°47'56.0\"S 47°51'38.0\"W");

		List<Passageiro> passageiros = new ArrayList<>();
		passageiros.add(passageiro1);
		passageiros.add(passageiro2);

		Trajeto trajeto1 = new Trajeto("15°47'56.0\"S 47°51'38.0\"W", "22°57′07\″S 43°12′38\″W", paradas, passageiros);
		trajeto1 = trajetoRepository.save(trajeto1);

		// Instanciando a conta
		List<Trajeto> trajetos = new ArrayList<>();
		trajetos.add(trajeto1);

		Conta conta1 = new Conta("Felipe Santos", "felipesantos@email.com", "12912345678", "12345678", trajetos);
	}

}
