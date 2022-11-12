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
	private double pontoPartidaLat;

	@Column(length = 20, nullable = false)
	private double pontoPartidaLon;

	@Column(length = 20, nullable = false)
	private double pontoChegadaLat;

	@Column(length = 20, nullable = false)
	private double pontoChegadaLon;

	@OneToMany
	private List<Passageiro> passageiros = new ArrayList<Passageiro>();

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;

	public Trajeto(double pontoPartidaLat, double pontoPartidaLon, double pontoChegadaLat, double pontoChegadaLon, List<Passageiro> passageiros){
		this.pontoPartidaLat = pontoPartidaLat;
		this.pontoPartidaLon = pontoPartidaLon;
		this.pontoChegadaLat = pontoChegadaLat;
		this.pontoChegadaLon = pontoChegadaLon;
		this.passageiros = passageiros;
	}
}
