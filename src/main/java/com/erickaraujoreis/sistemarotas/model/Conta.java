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
@Entity(name = "conta")

public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 50, nullable = false)
	private String email;

	@Column(length = 20, nullable = false)
	private String telefone;

	@Column(length = 30, nullable = false)
	private String senha;

	@OneToMany
	private List<Trajeto> trajetos = new ArrayList<Trajeto>();

	public Conta(String nome, String email, String telefone, String senha, List<Trajeto> trajetos){
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.trajetos = trajetos;
	}
}
