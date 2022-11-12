package com.erickaraujoreis.sistemarotas.model;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "passageiro")

public class Passageiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 20, nullable = false)
	private double enderecoLat;

	@Column(length = 20, nullable = false)
	private double enderecoLon;

	@ManyToOne
	@JoinColumn(name = "id_trajeto")
	private Trajeto trajeto;

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;

	public Passageiro(String nome, double enderecoLat, double enderecoLon){
		this.nome = nome;
		this.enderecoLat = enderecoLat;
		this.enderecoLon = enderecoLon;
	}
}
