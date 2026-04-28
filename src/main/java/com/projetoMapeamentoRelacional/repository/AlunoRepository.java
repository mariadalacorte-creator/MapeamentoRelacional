package com.projetoMapeamentoRelacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoMapeamentoRelacional.entity.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long>{

}
