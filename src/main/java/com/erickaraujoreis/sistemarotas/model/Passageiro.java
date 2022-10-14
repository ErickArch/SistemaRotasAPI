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
	private String endereco;

	@ManyToOne
	@JoinColumn(name = "id_trajeto", nullable = false)
	private Trajeto trajeto;

	public Passageiro(String nome, String endereco){
		this.nome = nome;
		this.endereco = endereco;
	}
}
