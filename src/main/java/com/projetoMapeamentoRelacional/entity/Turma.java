package com.projetoMapeamentoRelacional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "turma")
public class Turma {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column
	private String cidade;
	
	@NotNull
	@NotBlank
	@Column
	@Email(message = "Informe o e-mail corretamente") 
	private String email;
	
	@NotNull
	@NotBlank
	@Column
	private String nome;
	
	@NotNull
	@NotBlank
	@Column
	private String ra;
	
	@NotNull
	@NotBlank
	@Column
	private double renda;
	
	@NotNull
	@NotBlank
	@Column
	private String telefone;
	
	@ManyToOne
    @JoinColumn(name = "aluno_id") 
    private Aluno aluno;
}
