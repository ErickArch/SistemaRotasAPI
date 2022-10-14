package com.erickaraujoreis.sistemarotas.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "trajeto")

public class Trajeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false)
	private String pontoPartida;

	@Column(length = 20, nullable = false)
	private String pontoChegada;

	@Column(length = 20, nullable = false)
	private List<String> paradas;

	@OneToMany
	private List<Passageiro> passageiros = new ArrayList<Passageiro>();

	@ManyToOne
	@JoinColumn(name = "id_conta", nullable = false)
	private Conta conta;

	public Trajeto(String pontoPartida, String pontoChegada, List<String> paradas, List<Passageiro> passageiros){
		this.pontoPartida = pontoPartida;
		this.pontoChegada = pontoChegada;
		this.paradas = paradas;
		this.passageiros = passageiros;
	}
}
