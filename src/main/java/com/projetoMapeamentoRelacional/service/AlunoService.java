package com.projetoMapeamentoRelacional.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoMapeamentoRelacional.entity.Aluno;
import com.projetoMapeamentoRelacional.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	
	public AlunoService (AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public List <Aluno> buscarTodos(){
		return alunoRepository.findAll();
	}
	
	public Aluno buscarPorId(Long id) {
		Optional <Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElse (null);
	}
	
	public Aluno salvarAluno (Aluno atAluno) {
		return alunoRepository.save(atAluno);
	}
	
	public Aluno atualizarAluno(Long id, Aluno atAluno) {
		Optional<Aluno> exeAluno = alunoRepository.findById(id);
		if (exeAluno.isPresent()) {
		atAluno.setId(id);
		return alunoRepository.save(atAluno);
		} else {
		return null;
		}
		}
		
	public Boolean deletarAluno (Long id) {
		Optional <Aluno> exeAluno = alunoRepository.findById(id);
		if (exeAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}