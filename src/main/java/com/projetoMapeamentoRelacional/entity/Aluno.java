package com.projetoMapeamentoRelacional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //cria getters e setters
@NoArgsConstructor //cria construtor vazio
@AllArgsConstructor //cria construtor com todos os atributos
@Entity
@Table (name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Column
	private String descrição;
	
	@NotBlank
	@NotNull
	@Column
	private String nome;
}
