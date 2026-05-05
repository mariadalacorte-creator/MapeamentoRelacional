package com.projetoMapeamentoRelacional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoMapeamentoRelacional.entity.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long>{
	List <Aluno> findByCidade (String cidade);
}
